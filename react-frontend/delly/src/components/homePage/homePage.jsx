import React,{Component, useState} from "react";
import "../../stylesheets/homePage/homePage.css"
import BoxLogo from "../../images/homePage/boxlogo.png"
import Lock from "../../images/homePage/lock.png"
import deliveryMan from "../../images/homePage/deliveryMan.png"

class HomePage extends Component{
   render(){
       return(
          <div class="main-container">
          <section class="section1">
          <span class="circle"></span>   
           <div class="container-fluid my-container">
               <div className="col row1">
                 <div className="d-flex flex-row" >
                <div className="nav-item-logo">
                 <img src={BoxLogo} id="box-img" alt="Box logo"/>
                 <span id="boxLogo">Delly</span>
                 
                </div>
                 <div className="nav-item">
                     <a href="#Oferta" className="nav-text">Oferta</a>
                 </div>
                 <div className=" nav-item">
                     <a href="#Wspolpraca" className="nav-text">Współpraca</a>
                 </div>
                <div className=" nav-item">
                    <a href="#Lokalizacja" className="nav-text">Lokalizacja</a>
                </div>
                <div className="p-3 ml-auto p-2 nav-item">
                <img src={Lock} id="lock-img" alt="Lock"/>
                </div>
               </div>
              </div>
              <div className="col row2">
              <div id="welcome-text">    
              <span id="text-1">Dostawa jedzenia i <br/>nie tylko<br/></span>
              <span id="text-2">Supermarkety, sklepy, apteki, cokolwiek <br/>potrzebujesz!</span>   
              </div> 
              <img src={deliveryMan} id="delivery-man-img" alt="deliveryman"/> 
              <button class="btn btn-primary rounded-pill" id="start-button" type="submit">Rozpocznij</button>
              </div>
          </div>
          </section>
          <section id="Oferta" class="section2">
              <p>cso</p>
          </section>
          <section id="Wspolpraca" class="section3">
              <p>cso</p>
          </section>
          <section id="Lokalizacja" class="section4">
              <p>cso</p>
          </section>
          </div>
       )
   }
} export default HomePage;