import * as React from "react";
import "../../stylesheets/map/map.css";
import Test from "../map/test.jsx";
import Box from "../../images/box_local_icon.png"
import Meta from "../../images/meta_icon.png"

class map extends React.Component {
  constructor(props) {
    super(props);
    this.ref = React.createRef();
    this.map = null;
    this.H = null;
    this.platform = null;
  }

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
            return: 'polyline,turnByTurnActions,actions,instructions,travelSummary'
          }
      )
  }

  successThenDrawRoute = (result) => {
    
        if (result.routes.length) {
          result.routes[0].sections.forEach((section) => {
            // Create a linestring to use as a point source for the route line
            let linestring = this.H.geo.LineString.fromFlexiblePolyline(
              section.polyline
            );

            // Create a polyline to display the route:
            let routeLine = new this.H.map.Polyline(linestring, {
              style: { strokeColor: "rgba(73, 73, 73, 0.8)", lineWidth: 6 },
            });

            var startIcon = new this.H.map.Icon(Box);
            // Create a marker for the start point:
            let startMarker = new this.H.map.Marker( section.departure.place.location, {icon: startIcon});

            var endIcon = new this.H.map.Icon(Meta);
            // Create a marker for the end point:
            let endMarker = new this.H.map.Marker(section.arrival.place.location, {icon: endIcon});

            // Add the route polyline and the two markers to the map:
            this.map.addObjects([routeLine, startMarker, endMarker]);

            // Set the map's viewport to make the whole route visible:
            this.map
              .getViewModel()
              .setLookAtData({ bounds: routeLine.getBoundingBox() });
          });
        }
  }

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

  drawRoute = async (from, to) => {
      
    var routingService = this.platform.getRoutingService(null, 8);

    const [fromGeocode, toGeocode] = await Promise.all([this.calculateGeocode(from), this.calculateGeocode(to)]);

    console.log(fromGeocode + " " + toGeocode);

    // oblicza routa i wyswietla
    routingService.calculateRoute(
        this.getRoutingDetails(fromGeocode, toGeocode),
        this.successThenDrawRoute, 
        (error) => {
        console.error(error);
      }
    )
  }


  render() {
    return (
        <div>
        <Test drawRoute={this.drawRoute}/>
        <div ref={this.ref} class="map" style={{ height: "800px" }} />
        </div>
    );
  }
}

export default map;
