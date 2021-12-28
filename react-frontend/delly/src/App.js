
import '../src/App.scss'
import HomePage from "./components/homePage/homePage.js"
import ClientSide from "./components/client/MainPage.js"
import { Component } from 'react'
import { BrowserRouter as Router, Routes, Route} from "react-router-dom"
import MyData from "./components/client/MyData.js"

class App extends Component{

  render(){
  return (
    <MyData/>
    // <Router>
    //   <Routes>
    //     <Route path="/" element={<HomePage/>} />
    //     <Route path="/client" element={<ClientSide/>} />
    //   </Routes>
    // </Router>
  );
  }
}

export default App;
