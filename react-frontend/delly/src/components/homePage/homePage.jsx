import React, { Component } from "react";
import "../../stylesheets/homePage/homePage.scss";
import HomeSection1 from "../homePage/HomeSection1.jsx"
import HomeSection2 from "../homePage/HomeSection2.jsx";
import HomeSection3 from "../homePage/HomeSection3.jsx";
import HomeSection4 from "../homePage/HomeSection4.jsx";

class HomePage extends Component {

  render() {
    return (
      <div className="main-container">
              
        <HomeSection1/>      
        <HomeSection2/>
        <HomeSection3/>
        <HomeSection4/>
        
      </div>
    );
  }
}
export default HomePage;
