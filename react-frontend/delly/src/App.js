
import '../src/App.css'
import PDF from './components/ShipLabel/generatePDF'
import Map from './components/map/map.js'
import Test from './components/map/test.jsx'
import {DistanceMatrixService} from "react-google-maps"
import HomePage from "./components/homePage/homePage.jsx"
import { Component } from 'react'
import Login from "./components/Pop'up/Login.jsx"

class App extends Component{

  render(){
  return (
    <>
     {/* <Map/> */}
    {/* <HomePage/> */}
    <HomePage/>
    </>
  );
  }
}

export default App;
