import React,{Component, useState} from "react";
import "../../stylesheets/homePage/homePage.css"
import BoxLogo from "../../images/homePage/boxlogo.png"
import Lock from "../../images/homePage/lock.png"
import deliveryMan from "../../images/homePage/deliveryMan.png"
import Wave from "../../images/svg/wave.svg"
import HalfCircle from "../../images/svg/halfCircle.svg"
import WaveFlipped from "../../images/svg/wave-flipped.svg"
import Restaurant from "../../images/homePage/restaurant.png"
import Grossery from "../../images/homePage/grossery.png"
import Delivery from "../../images/homePage/delivery.png"

class HomePage extends Component{
   render(){
       return(
          <div class="main-container">
          <section class="section1">
          <span id="circle-section1"></span>   
           <div class="container-fluid my-container">
               <div className="col row1">
                 <div className="d-flex flex-row f-row" >
                <div className="nav-item-logo">
                 <img src={BoxLogo} id="box-img" alt="Box logo"/>
                 <span id="boxLogo">Delly</span>
                 
                </div>
                 <div className="nav-item">
                     <a href="#Oferta" className="nav-text">Oferta</a>
                 </div>
                 <div className="nav-item">
                     <a href="#Wspolpraca" className="nav-text">Współpraca</a>
                 </div>
                <div className="nav-item">
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

          <img src={HalfCircle} id="half-circle-img" alt="deliveryman"/> 
            <span id="title-section2">Dostarczymy wszystko</span>   

            <div class="d-flex flex-row justify-content-center flex-container2">
            <div class="nav-item2">
               <img src={Restaurant} id="sec2-img1" alt="Lock"/>
               <span className="sec2-text1">Popularne restauracje w <br/>Twoim mieście<br/></span>
               <span className="sec2-text2">Dzięki szerokiej ofercie restauracji<br/> możesz zamówić swoje ulubione<br/> jedzenie.</span>
            </div>
            <div class="nav-item2">
               <img src={Delivery} id="sec2-img2" alt="Lock"/>
               <spam className="sec2-text1">Szybka dostawa<br/></spam>
               <span className="sec2-text2">Szybka dostawa jest dla nas<br/> kluczowa. Zamów lub wyślij<br/> dowolny artykuł w swoim mieście.</span>
            </div>
            <div class="nav-item2">
               <img src={Grossery} id="sec2-img3" alt="Lock"/>
               <span className="sec2-text1">Dostawa artykułów <br/>spożywczych i nie tylko<br/></span>
               <span className="sec2-text2">Z nami znajdziesz wszystko! Od<br/> supermarketów po sklepy, apteki i<br/> kwiaciarnie — jeśli punkt działa w<br/> Twoim mieście, zajmiemy się dostawą.</span>
            </div>
            </div>

            <img src={Wave} id="wave-img" alt="deliveryman"/>

          </section>
          <section id="Wspolpraca" class="section3">
          </section>
          <section id="Lokalizacja" class="section4">
             <img src={WaveFlipped} id="wave-flipped-img" alt="deliveryman"/> 
          </section>
          </div>
       )
   }
} export default HomePage;