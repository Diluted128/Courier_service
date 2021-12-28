import React, { Component } from "react";
import "../../stylesheets/homePage/homePage.scss";
import HomeSection1 from "./HomeSection1.js"
import HomeSection2 from "./HomeSection2.js";
import HomeSection3 from "./HomeSection3.js";
import HomeSection4 from "./HomeSection4.js";

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
