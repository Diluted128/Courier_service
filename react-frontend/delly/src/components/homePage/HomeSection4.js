import React, { Component } from "react";
import WaveFlipped from "../../images/svg/wave-flipped.svg";
import WhiteLogo from "../../images/homePage/box-logo-white.png";
import MapImg from "../../images/homePage/map-img.png";
import "../../stylesheets/homePage/homeSection4.scss";

class HomeSection4 extends Component {
  render() {
    return (
      <section className="section4">
        <img src={WaveFlipped} className="section4__wave-svg" alt="deliveryman" />
        <div className="section4__logo-container">
          <img src={WhiteLogo} className="section4__logo-container__logo-img" alt="Box logo" />
          <span className="section4__logo-container__logo-text">Delly</span>
        </div>
        <div className="section4__links-container">
          <div className="d-flex flex-row section4__links-container__row">
            <div className="section4__links-container__row__item section4__links-container__row__item--bold">
              <span>Współpraca</span>
            </div>
            <div className="section4__links-container__row1__item section4__links-container__row__item--bold">
              <span>Przydatne linki</span>
            </div>
            <div className="section4__links-container__row1__item section4__links-container__row__item--bold">
              <span>Obserwuj nas</span>
            </div>
          </div>
          <div className="d-flex flex-row section4__links-container__row">
            <div className="section4__links-container__row__item">
              <span>Delly dla partnerów</span>
            </div>
            <div className="section4__links-container__row__item">
              <span>O nas</span>
            </div>
            <div className="section4__links-container__row__item">
              <span>Facebook</span>
            </div>
          </div>
          <div className="d-flex flex-row section4__links-container__row">
            <div className="section4__links-container__row__item">
              <span>Kurierzy</span>
            </div>
            <div className="section4__links-container__row__item">
              <span>FAQ</span>
            </div>
            <div className="section4__links-container__row__item">
              <span>Instagram</span>
            </div>
          </div>
        </div>
        <img src={MapImg} className="section4__map" alt="Box logo" />
      </section>
    );
  }
}
export default HomeSection4;
