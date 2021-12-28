import "../../stylesheets/homePage/homeSection2.scss"
import Restaurant from "../../images/homePage/restaurant.png";
import Grossery from "../../images/homePage/grossery.png";
import Delivery from "../../images/homePage/delivery.png";
import Wave from "../../images/svg/wave.svg";
import HalfCircle from "../../images/svg/halfCircle.svg";
import React, { Component } from "react";

class homeSection2 extends Component {
 
  render() {
    return (
      <section className="Oferta" className="section2">
        <img src={HalfCircle} className="section2__half-circle-svg" alt="deliveryman" />
        <span className="section2__title">Dostarczymy wszystko</span>

        <div className="d-flex flex-row justify-content-center section2__flex-container">
          <div className="section2__flex-container__item">
            <img src={Restaurant} className="section2__flex-container__item__img1" alt="Lock" />
            <span className="section2__flex-container__item__title">
              Popularne restauracje w <br />
              Twoim mieście
              <br />
            </span>
            <span className="section2__flex-container__item__description">
              Dzięki szerokiej ofercie restauracji
              <br /> możesz zamówić swoje ulubione
              <br /> jedzenie.
            </span>
          </div>
          <div className="section2__flex-container__item">
            <img src={Delivery} className="section2__flex-container__item__img2" alt="Lock" />
            <span className="section2__flex-container__item__title">
              Szybka dostawa
              <br />
            </span>
            <span className="section2__flex-container__item__description">
              Szybka dostawa jest dla nas
              <br /> kluczowa. Zamów lub wyślij
              <br /> dowolny artykuł w swoim mieście.
            </span>
          </div>
          <div className="section2__flex-container__item">
            <img src={Grossery} className="section2__flex-container__item__img3" alt="Lock" />
            <span className="section2__flex-container__item__title">
              Dostawa artykułów <br />
              spożywczych i nie tylko
              <br />
            </span>
            <span className="section2__flex-container__item__description">
              Z nami znajdziesz wszystko! Od
              <br /> supermarketów po sklepy, apteki i<br /> kwiaciarnie — jeśli
              punkt działa w<br /> Twoim mieście, zajmiemy się dostawą.
            </span>
          </div>
        </div>

        <img src={Wave} className="section2__wave-svg" alt="section2__wave-svg" />
      </section>
    );
  }
}
export default homeSection2;
