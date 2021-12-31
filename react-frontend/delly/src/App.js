
import '../src/App.scss'
import HomePage from "./components/homePage/homePage.js"
import ClientSide from "./components/client/MainPage.js"
import { Component } from 'react'
import { BrowserRouter as Router, Routes, Route} from "react-router-dom"

class App extends Component{

  render(){
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage/>} />
        <Route path="/client" element={<ClientSide/>} />
      </Routes>
    </Router>
  );
  }
}

export default App;
