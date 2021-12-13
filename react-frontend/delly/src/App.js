
import '../src/App.scss'

import HomePage from "./components/homePage/homePage.jsx"
import { Component } from 'react'
// import MainPage from "./components/clientside/mainPage.jsx"

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
