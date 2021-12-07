import React,{Component} from "react";
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
import Splash1 from "../../images/homePage/splash-1.png"
import Splash2 from "../../images/homePage/splash-2.png"
import Splash3 from "../../images/homePage/splash-3.png"
import WhiteLogo from "../../images/homePage/box-logo-white.png"
import MapImg from "../../images/homePage/map-img.png"
import LoginPopup from "../Pop'up/Login.jsx"

class HomePage extends Component{

   constructor(){
      super();
      this.state={
         open: false
      }
   }

   render(){
       return(
          <div className="main-container">
          <section className="section1">
          <span id="circle-section1"></span>   
           <div className="container-fluid my-container">
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
                    <a href="#Lokalizacja" className="nav-text">Kontakt</a>
                </div>
                <div className="p-3 ml-auto p-2 nav-item">
                <input onClick={() => this.setState({open: true})} type="image" src={Lock} id="lock-img"/>   
                </div>
               </div>
              </div>
              <div className="col row2">
              <div id="welcome-text">    
              <span id="text-1">Dostawa jedzenia i <br/>nie tylko<br/></span>
              <span id="text-2">Supermarkety, sklepy, apteki, cokolwiek <br/>potrzebujesz!</span>   
              </div> 
              <img src={deliveryMan} id="delivery-man-img" alt="deliveryman"/> 
              <button onClick={ () => this.setState({open: true})} className="btn btn-primary rounded-pill" id="start-button" type="submit">Rozpocznij</button>
              <LoginPopup openPopup={this.state.open} closePopup={() => this.setState({open: false})}/>
              </div>
          </div>
          </section>
          <section id="Oferta" className="section2">

          <img src={HalfCircle} id="half-circle-img" alt="deliveryman"/> 
            <span id="title-section2">Dostarczymy wszystko</span>   

            <div className="d-flex flex-row justify-content-center flex-container2">
            <div className="nav-item2">
               <img src={Restaurant} id="sec2-img1" alt="Lock"/>
               <span className="sec2-text1">Popularne restauracje w <br/>Twoim mieście<br/></span>
               <span className="sec2-text2">Dzięki szerokiej ofercie restauracji<br/> możesz zamówić swoje ulubione<br/> jedzenie.</span>
            </div>
            <div className="nav-item2">
               <img src={Delivery} id="sec2-img2" alt="Lock"/>
               <span className="sec2-text1">Szybka dostawa<br/></span>
               <span className="sec2-text2">Szybka dostawa jest dla nas<br/> kluczowa. Zamów lub wyślij<br/> dowolny artykuł w swoim mieście.</span>
            </div>
            <div className="nav-item2">
               <img src={Grossery} id="sec2-img3" alt="Lock"/>
               <span className="sec2-text1">Dostawa artykułów <br/>spożywczych i nie tylko<br/></span>
               <span className="sec2-text2">Z nami znajdziesz wszystko! Od<br/> supermarketów po sklepy, apteki i<br/> kwiaciarnie — jeśli punkt działa w<br/> Twoim mieście, zajmiemy się dostawą.</span>
            </div>
            </div>

            <img src={Wave} id="wave-img" alt="deliveryman"/>

          </section>
          <section id="Wspolpraca" className="section3">

          <span id="title-section3">Razem możemy więcej!</span> 

          <div className="d-flex flex-row justify-content-center flex-container3">
            <div className="nav-item3">
               <img src={Splash1} id="sec3-img1" alt="Lock"/>
               <span className="sec3-text1">Zostań kurierem<br/></span>
               <span className="sec3-text2">Nie potrzebujesz szefa! Korzystaj z <br/>elastyczności, swobody i zarobków,<br/> które umożliwia Delly..</span>
            </div>
            <div className="nav-item3">
               <img src={Splash2} id="sec3-img2" alt="Lock"/>
               <spam className="sec3-text1">Zostań Pracownikiem<br/></spam>
               <span className="sec3-text2">Szukasz ciekawej pracy? Jeśli<br/> uwielbiasz wyzwania, pomaganie i<br/> kontakt z ludźmi, skontaktuj się z<br/> nami!</span>
            </div>
            <div className="nav-item3">
               <img src={Splash3} id="sec3-img3" alt="Lock"/>
               <span className="sec3-text1">Zostań partnerem<br/></span>
               <span className="sec3-text2">Rozwijaj działalność z pomocą<br/> Delly! Nasze rozwiązania i baza<br/> użytkowników pomagają<br/> zwiększyć sprzedaż i poszerzać<br/> klientelę!</span>
            </div>
            </div>
          </section>
          <section id="Lokalizacja" className="section4">
          <img src={WaveFlipped} id="wave-flipped-img" alt="deliveryman"/> 
          <div id="logo2">
          <img src={WhiteLogo} id="logo-white-img" alt="Box logo"/>
          <span id="boxLogo-white">Delly</span>
          </div>
          <div id="list">
             <div className="d-flex flex-row flex-container4">
                 <div className="nav-item4"><spam>Współpraca</spam></div>
                 <div className="nav-item4"><spam>Przydatne linki</spam></div>
                 <div className="nav-item4"><spam>Obserwuj nas</spam></div>
             </div>
             <div className="d-flex flex-row flex-container5">
                 <div className="nav-item5"><spam>Delly dla partnerów</spam></div>
                 <div className="nav-item5"><spam>O nas</spam></div>
                 <div className="nav-item5"><spam>Facebook</spam></div>
             </div>
             <div className="d-flex flex-row flex-container6">
                 <div className="nav-item5"><spam>Kurierzy</spam></div>
                 <div className="nav-item5"><spam>FAQ</spam></div>
                 <div className="nav-item5"><spam>Instagram</spam></div>
             </div>
             </div>
          <img src={MapImg} id="map-img" alt="Box logo"/>  
          </section>
          </div>
       )
   }
} export default HomePage;