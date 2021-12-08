
import '../src/App.css'
import PDF from './components/ShipLabel/generatePDF'
import Map from './components/map/map.js'
import Test from './components/map/test.jsx'
import HomePage from "./components/homePage/homePage.jsx"
import { Component } from 'react'
import Password from "./components/Pop'up/Password.jsx"

class App extends Component{

  render(){
  return (
    <>
     {/* <Map/> */}
    <HomePage/>
    </>
  );
  }
}

export default App;
