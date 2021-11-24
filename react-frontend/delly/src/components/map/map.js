import * as React from "react"
import '../../stylesheets/map/map.css'
import Test from '../map/test.jsx'

class map extends React.Component{

    state = {
        map: null,
        platform: null,
        H: null,
        routingService: null
    }

    mapRef = React.createRef();

    componentDidMount(){
        
        var H = window.H;
        var platform = new H.service.Platform({
            apikey: "tPpNaaUaiKemvwf0c7oBk8L04D7iJfanL94O4PkXUaU"
        });

        var defaultLayers = platform.createDefaultLayers();
        
        var map = new H.Map(
            this.mapRef.current,
            defaultLayers.vector.normal.map,
            {
              // This map is centered over Europe
              center: { lat: 50, lng: 5 },
              zoom: 4,
            }
        );
        
        const behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(map));

        const ui = H.ui.UI.createDefault(map, defaultLayers);

        // map.dispose();

        var routingService = platform.getRoutingService(null, 8);
       
       // 'origin': '49.64008, 19.32883',
       // 'destination': '50.00627, 19.87327',
        routingService.calculateRoute(
                {
                    'routingMode': 'fast',
                    'transportMode': 'car',
                    // The start point of the route:
                    'origin': '49.640080000000,19.3288300000',
                    // The end point of the route:
                    'destination': '50.00627,19.87327',
                    // Include the route shape in the response
                    'return': 'polyline'
    
                },
                result => {
                    if (result.routes.length) {
                        result.routes[0].sections.forEach((section) => {
                             // Create a linestring to use as a point source for the route line
                            let linestring = H.geo.LineString.fromFlexiblePolyline(section.polyline);
                    
                            // Create a polyline to display the route:
                            let routeLine = new H.map.Polyline(linestring, {
                              style: { strokeColor: 'blue', lineWidth: 3 }
                            });
                    
                            // Create a marker for the start point:
                            let startMarker = new H.map.Marker(section.departure.place.location);
                    
                            // Create a marker for the end point:
                            let endMarker = new H.map.Marker(section.arrival.place.location);
                    
                            // Add the route polyline and the two markers to the map:
                            map.addObjects([routeLine, startMarker, endMarker]);
                    
                            // Set the map's viewport to make the whole route visible:
                            map.getViewModel().setLookAtData({bounds: routeLine.getBoundingBox()});
                        });
                      }
                },
                error => {
                    console.error(error);
                }
            )    

    }

    drawRoute = () => {

        var start = {
            lat: "37",
            lng: "-121"
        }

        var finish = {
            lat: "38",
            lng: "-122"
        }

        console.log(this.state.routingService)
        this.state.routingService.calculateRoute(
            {
                'routingMode': 'fast',
                'transportMode': 'car',
                 "origin": '50.1120423728813,8.68340740740811',
                 "destination": '52.5309916298853,13.3846220493377',
                 'return': 'polyline'

            },
            data => {
                console.log("udalo sie nice");
            },
            error => {
                console.error(error.message);
            }
        )
    }

    render(){
        return(
            <>
            <Test />
            <div ref={this.mapRef} style={{ height: "500px" }} />
            </>
        )
    }
}


export default map;


