
import '../src/App.css'
import PDF from './components/ShipLabel/generatePDF'
import Map from './components/map/map.js'
import Test from './components/map/test.jsx'
import {DistanceMatrixService} from "react-google-maps"
import { Component } from 'react'

class App extends Component{

  state = {
    calcDistance: null
  }

  // calcDistance = () => {

  //   google
  //   <DistanceMatrixService
  //   options={{
  //     destinations: [{lat:1.296788, lng:103.778961}],
  //     origins: [{lng:103.780267, lat:1.291692}],
  //     travelMode: "DRIVING",
  //   }}
  
  //   callback = {(response) => {console.log(response)}}
  //   />
  // }



  render(){
  return (
    <>
     <Map/>
    </>
  );
  }
}

export default App;
