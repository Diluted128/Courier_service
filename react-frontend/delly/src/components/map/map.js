import * as React from "react";
import "../../stylesheets/map/map.css";
import Test from "../map/test.jsx";
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

      var a = [];
      a.push(new this.H.map.Marker(route.departure.place.location))
      a.push(new this.H.map.Marker(route.arrival.place.location))
      
      this.map.addObjects([routeLine, startMarker, endMarker]);

      this.map
        .getViewModel()
        .setLookAtData({ bounds: routeLine.getBoundingBox() });
    
      return a;
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

  drawRoute = async (curierAddress, parcelAddress, clientAddress) => {
      
    this.map.removeObjects(this.map.getObjects());

    const [curierGeocode, parcelGeocode, clientGeocode] = await Promise.all([this.calculateGeocode(curierAddress), this.calculateGeocode(parcelAddress), this.calculateGeocode(clientAddress)]);

    const [routeOb1, routeOb2] = await Promise.all([this.calculateRoute(curierGeocode, parcelGeocode), this.calculateRoute(parcelGeocode, clientGeocode)])

    var a = this.drawObjectsOnMap(routeOb1[0], 'curier-percel', "rgba(253, 90, 90, 0.8)");
    var b = this.drawObjectsOnMap(routeOb2[0], 'percel-client', "rgba(104, 205, 255, 0.8)");

    var c = [];
    c.push(a[0])
    c.push(b[0])
    c.push(b[1])

    // Aby uzyskac dobry zoom na te punkty
    // 1. znajdz, ktory punkt jest oddalony najbardziej na wschod, zachod, polnoc i poludnie
    // 2. W zaleznosci od punktu przesun go w strone w ktora jest najbardziej oddalony 
    // 3. zapisz te punkty do tablicy i wrzuc nizej 

    var group = new this.H.map.Group();
    
    group.addObjects(c);

    this.map.getViewModel().setLookAtData({
      bounds: group.getBoundingBox()
    }); 

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
