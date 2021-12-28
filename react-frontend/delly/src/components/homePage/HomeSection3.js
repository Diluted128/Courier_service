import "../../stylesheets/homePage/homeSection3.scss";
import React, { Component } from "react";
import ApplyPopup from "../Pop'up/Apply.js";
import Splash1 from "../../images/homePage/splash-1.png";
import Splash2 from "../../images/homePage/splash-2.png";
import Splash3 from "../../images/homePage/splash-3.png";

class homeSection3 extends Component {
  constructor() {
    super();
    this.state = {
      openApply: false,
    };
  }

  render() {
    return (
      <section className="section3">
        <span className="section3__title">Razem możemy więcej!</span>
        <div className="d-flex flex-row justify-content-center section3__flex-container">
          <div className="section3__flex-container__item">
            <img
              src={Splash1}
              className="section3__flex-container__item__img1"
              alt="Lock"
            />
            <span className="section3__flex-container__item__title">
              Zostań kurierem
              <br />
            </span>
            <span className="section3__flex-container__item__description">
              Nie potrzebujesz szefa! Korzystaj z <br />
              elastyczności, swobody i zarobków,
              <br /> które umożliwia Delly..
            </span>
          </div>
          <div className="section3__flex-container__item">
            <img
              src={Splash2}
              className="section3__flex-container__item__img2"
              alt="Lock"
            />
            <span className="section3__flex-container__item__title">
              Zostań Pracownikiem
              <br />
            </span>
            <span className="section3__flex-container__item__description">
              Szukasz ciekawej pracy? Jeśli
              <br /> uwielbiasz wyzwania, pomaganie i<br /> kontakt z ludźmi,
              skontaktuj się z<br /> nami!
            </span>
            <button
              onClick={() =>
                this.setState({ openLogin: false, openApply: true })
              }
              className="btn btn-primary rounded-pill section3__flex-container__item__button"
              type="submit"
            >
              Aplikuj
            </button>
            <ApplyPopup
              openPopup={this.state.openApply}
              closeApply={() =>
                this.setState({ openLogin: false, openApply: false })
              }
            />
          </div>
          <div className="section3__flex-container__item">
            <img
              src={Splash3}
              className="section3__flex-container__item__img3"
              alt="Lock"
            />
            <span className="section3__flex-container__item__title">
              Zostań partnerem
              <br />
            </span>
            <span className="section3__flex-container__item__description">
              Rozwijaj działalność z pomocą
              <br /> Delly! Nasze rozwiązania i baza
              <br /> użytkowników pomagają
              <br /> zwiększyć sprzedaż i poszerzać
              <br /> klientelę!
            </span>
          </div>
        </div>
      </section>
    );
  }
}
export default homeSection3;
