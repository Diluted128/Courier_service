import * as React from "react";
import "../../stylesheets/map/map.css";
import Test from "../map/test.js";
import Box from "../../images/box_local_icon.png"
import Meta from "../../images/meta_icon.png"
import Curier from "../../images/curier_icon.png"

class map extends React.Component {
  constructor(props) {
    super(props);
    this.ref = React.createRef();
    this.map = null;
    this.H = null;
    this.platform = null;
    this.marker2 = null;
    this.marker3 = null;
    this.state={
      distance: 0,
      duration: 0
    }
  
  }

  //initialize map
  componentDidMount() {
    const H = window.H;

    const platform = new H.service.Platform({
      apikey: "tPpNaaUaiKemvwf0c7oBk8L04D7iJfanL94O4PkXUaU",
    });

    const defaultLayers = platform.createDefaultLayers();

    const map = new H.Map(
      this.ref.current,
      defaultLayers.vector.normal.map,
      {
        center: { lat: 50.06139, lng: 19.93800 },
        zoom: 13,
      }
    );

    new H.mapevents.Behavior(new H.mapevents.MapEvents(map));

    H.ui.UI.createDefault(map, defaultLayers);

    this.map = map;
    this.H = H;
    this.platform = platform;

  }


  getRoutingDetails = (fromGeo, toGeo) => {
     
      return (
        {
            routingMode: "fast",
            transportMode: "pedestrian",
            origin: fromGeo,
            destination: toGeo,
            return: 'polyline,actions,instructions,travelSummary'
          }
      )
  }

  //puts merkers and polyline on map
  drawObjectsOnMap(route, type, rgb){

      const linestring = this.H.geo.LineString.fromFlexiblePolyline(
        route.polyline
      );


      var startIcon;
      var startMarker;
      var endIcon;
      var endMarker;
  
     const routeLine = new this.H.map.Polyline(linestring, {
        style: { strokeColor: rgb, lineWidth: 6, lineJoin: "bevel" },
      });

      if(type == 'curier-percel'){
          startIcon = new this.H.map.Icon(Curier);
          endIcon = new this.H.map.Icon(Box);
          startMarker = new this.H.map.Marker( route.departure.place.location, {icon: startIcon});
          endMarker = new this.H.map.Marker( route.arrival.place.location, {icon: endIcon});

      }

      if(type == 'percel-client'){
          startIcon = new this.H.map.Icon(Box);
          endIcon = new this.H.map.Icon(Meta);
          startMarker = new this.H.map.Marker( route.departure.place.location, {icon: startIcon});
          endMarker = new this.H.map.Marker( route.arrival.place.location, {icon: endIcon});
      }
      
      this.map.addObjects([routeLine, startMarker, endMarker]);

      this.map
        .getViewModel()
        .setLookAtData({ bounds: routeLine.getBoundingBox() });
    
  }


  calculateRoute = (startGeo, finishGeo) => {
      
    const routingService = this.platform.getRoutingService(null, 8);

    return new Promise((res, rej) => {
    routingService.calculateRoute(
      this.getRoutingDetails(startGeo, finishGeo),
      (result) => {
           res(result.routes[0].sections)
      }, 
      (error) => {
        rej.error(error);
      }
    );
    });
  }

  // Converts address to geocode 
  calculateGeocode = (start) => {

    const geocoderStart = this.platform.getSearchService(),
          geocodingParameters =  {
          q: start,
          };
    

    return new Promise((res, rej) => {
        geocoderStart.geocode(
          geocodingParameters,
          (result) => {

            const locations = result.items[0];
   
            const cord = locations.position.lat + "," + locations.position.lng;
            
            console.log("In function: " + cord)
            res(cord);
          },
          (error) => {
            rej(error);
          }
        );
      });
  }

  zoomMapOnMarkers(curierAddress, parcelAddress, clientAddress){
      
    const zoomValue = 0.002;

    console.log(curierAddress);
    console.log(parcelAddress);
    console.log(clientAddress);

    var cordinates = [
       [parseFloat(curierAddress.substr(0, curierAddress.indexOf(','))), parseFloat(curierAddress.substr(curierAddress.indexOf(',') + 1))],
       [parseFloat(parcelAddress.substr(0, parcelAddress.indexOf(','))), parseFloat(parcelAddress.substr(parcelAddress.indexOf(',') + 1))],
       [parseFloat(clientAddress.substr(0, clientAddress.indexOf(','))), parseFloat(clientAddress.substr(clientAddress.indexOf(',') + 1))]
    ]
    
    var newCordinates = [
      [parseFloat(curierAddress.substr(0, curierAddress.indexOf(','))), parseFloat(curierAddress.substr(curierAddress.indexOf(',') + 1))],
      [parseFloat(parcelAddress.substr(0, parcelAddress.indexOf(','))), parseFloat(parcelAddress.substr(parcelAddress.indexOf(',') + 1))],
      [parseFloat(clientAddress.substr(0, clientAddress.indexOf(','))), parseFloat(clientAddress.substr(clientAddress.indexOf(',') + 1))]
    ]  

    var characteristics = [
       Math.min(Math.min(cordinates[0][1], cordinates[1][1]), cordinates[2][1]),
       Math.max(Math.max(cordinates[0][0], cordinates[1][0]), cordinates[2][0]),
       Math.max(Math.max(cordinates[0][1], cordinates[1][1]), cordinates[2][1]), 
       Math.min(Math.min(cordinates[0][0], cordinates[1][0]), cordinates[2][0])
    ]  

    console.log(characteristics)
    
    if(characteristics[0] == cordinates[0][1])
        newCordinates[0][1] = characteristics[0] - zoomValue;
    else if(characteristics[0] == cordinates[1][1])
        newCordinates[1][1] = characteristics[0] - zoomValue;
    else if(characteristics[0] == cordinates[2][1])
        newCordinates[2][1] = characteristics[0] - zoomValue;
    
    if(characteristics[1] == cordinates[0][0])
        newCordinates[0][0] = characteristics[1] + zoomValue;
    else if(characteristics[1] == cordinates[1][0])
        newCordinates[1][0] = characteristics[1] + zoomValue;
    else if(characteristics[1] == cordinates[2][0])
        newCordinates[2][0] = characteristics[1] + zoomValue;

    if(characteristics[2] == cordinates[0][1])
        newCordinates[0][1] = characteristics[2] + zoomValue;
    else if(characteristics[2] == cordinates[1][1])
        newCordinates[1][1] = characteristics[2] + zoomValue;
    else if(characteristics[2] == cordinates[2][1])
        newCordinates[2][1] = characteristics[2] + zoomValue;
     
    if(characteristics[3] == cordinates[0][0])
        newCordinates[0][0] = characteristics[3] - zoomValue;
    else if(characteristics[3] == cordinates[1][0])
        newCordinates[1][0] = characteristics[3] - zoomValue;
    else if(characteristics[3] == cordinates[2][0])
        newCordinates[2][0] = characteristics[3] - zoomValue;


    console.log(cordinates)
    console.log(newCordinates);

    var group = new this.H.map.Group();
  
    var clientMarker= new this.H.map.Marker({lat: newCordinates[0][0],  lng: newCordinates[0][1]})
    var percelMarker = new this.H.map.Marker({lat: newCordinates[1][0], lng: newCordinates[1][1]})
    var curierMarker = new this.H.map.Marker({lat: newCordinates[2][0], lng: newCordinates[2][1]})

    group.addObjects([clientMarker, percelMarker, curierMarker]);

    this.map.getViewModel().setLookAtData({
      bounds: group.getBoundingBox()
    });
  }

  drawRoute = async (curierAddress, parcelAddress, clientAddress) => {
      
    this.map.removeObjects(this.map.getObjects());

    const [curierGeocode, parcelGeocode, clientGeocode] = await Promise.all([this.calculateGeocode(curierAddress), this.calculateGeocode(parcelAddress), this.calculateGeocode(clientAddress)]);

    const [routeOb1, routeOb2] = await Promise.all([this.calculateRoute(curierGeocode, parcelGeocode), this.calculateRoute(parcelGeocode, clientGeocode)])

    this.drawObjectsOnMap(routeOb1[0], 'curier-percel', "rgba(253, 90, 90, 0.8)");
    this.drawObjectsOnMap(routeOb2[0], 'percel-client', "rgba(104, 205, 255, 0.8)");

    this.zoomMapOnMarkers(curierGeocode, parcelGeocode, clientGeocode)

    this.setState({distance: routeOb1[0].travelSummary.length + routeOb2[0].travelSummary.length + " m"});

    this.setState({duration: Math.floor((routeOb1[0].travelSummary.duration + routeOb2[0].travelSummary.duration) / 60)});
  }

  render() {
    return (
        <div>
        <Test drawRoute={this.drawRoute} dist={this.state.distance} duration={this.state.duration}/>
        <div ref={this.ref} class="map" style={{ height: "800px" }} />
        </div>
    );
  }
}

export default map;
