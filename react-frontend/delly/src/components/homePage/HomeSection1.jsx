import React, { Component } from "react";
import deliveryMan from "../../images/homePage/deliveryMan.png";
import BoxLogo from "../../images/homePage/boxlogo.png";
import Lock from "../../images/homePage/lock.png";
import LoginPopup from "../Pop'up/Login.jsx";
import RegistrationPopup from "../Pop'up/Registration.jsx";
import PasswordPopup from "../Pop'up/Password.jsx";
import "../../stylesheets/homePage/homeSection1.scss";

class homeSection1 extends Component {
  constructor() {
    super();
    this.state = {
      openLogin: false,
      openApply: false,
      openRegistration: false,
      openPassword: false,
    };
  }

  render() {
    return (
      <section className="section1">
        <span className="section1__circle-background" />
        <div className="container-fluid section1__header">
          <div className="col section1__header__first-row">
            <div className="d-flex flex-row section1__header__first-row__row">
              <div className="section1__header__first-row__row__logo-container">
                <img
                  src={BoxLogo}
                  className="section1__header__first-row__row__logo-container__logo-img"
                  alt="Box logo"
                />
                <span className="section1__header__first-row__row__logo-container__logo-text">
                  Delly
                </span>
              </div>
              <div className="section1__header__first-row__row__navigation-item">
                <a
                  href="#Oferta"
                  className="section1__header__first-row__row__navigation-item__text"
                >
                  Oferta
                </a>
              </div>
              <div className="section1__header__first-row__row__navigation-item">
                <a
                  href="#Wspolpraca"
                  className="section1__header__first-row__row__navigation-item__text"
                >
                  Współpraca
                </a>
              </div>
              <div className="section1__header__first-row__row__navigation-item">
                <a
                  href="#Lokalizacja"
                  className="section1__header__first-row__row__navigation-item__text"
                >
                  Kontakt
                </a>
              </div>
              <div className="p-3 ml-auto p-2 section1__header__first-row__row__navigation-item">
                <input
                  onClick={() => this.setState({ openLogin: true })}
                  type="image"
                  src={Lock}
                  className="section1__header__first-row__row__navigation-item__lock-img"
                />
              </div>
            </div>
          </div>
          <div className="col container-fluid section1__header__second-row">
            <div className="section1__header__second-row__welcome-text-container">
              <span className="section1__header__second-row__welcome-text-container__title">
                Dostawa jedzenia i <br />
                nie tylko
                <br />
              </span>
              <span className="section1__header__second-row__welcome-text-container__decription">
                Supermarkety, sklepy, apteki, cokolwiek <br />
                potrzebujesz!
              </span>
            </div>
            <img
              src={deliveryMan}
              className="section1__header__second-row__delivery-man-img"
              alt="deliveryman"
            />
            <button
              onClick={() =>
                this.setState({
                  openLogin: true,
                  openApply: false,
                  openRegistration: false,
                  openPassword: false,
                })
              }
              className="btn btn-primary rounded-pill section1__header__second-row__start-button"
              type="submit"
            >
              Rozpocznij
            </button>
            <LoginPopup
              openPopup={this.state.openLogin}
              closePopup={() =>
                this.setState({
                  openLogin: false,
                  openLogin: false,
                  openRegistration: false,
                  openPassword: false,
                })
              }
              openRegistry={() =>
                this.setState({
                  openLogin: false,
                  openLogin: false,
                  openRegistration: true,
                  openPassword: false,
                })
              }
              openPassword={() =>
                this.setState({
                  openLogin: false,
                  openApply: false,
                  openRegistration: false,
                  openPassword: true,
                })
              }
            />
            <RegistrationPopup
              openPopup={this.state.openRegistration}
              openLogin={() =>
                this.setState({
                  openLogin: true,
                  openApply: false,
                  openRegistration: false,
                  openPassword: false,
                })
              }
              closePopup={() =>
                this.setState({
                  openLogin: false,
                  openApply: false,
                  openRegistration: false,
                  openPassowrd: false,
                })
              }
            />
            <PasswordPopup
              openPopup={this.state.openPassword}
              openLogin={() =>
                this.setState({
                  openLogin: true,
                  openApply: false,
                  openRegistration: false,
                  openPassword: false,
                })
              }
              closePopup={() =>
                this.setState({
                  openLogin: false,
                  openApply: false,
                  openRegistration: false,
                  openPassword: false,
                })
              }
            />
          </div>
        </div>
      </section>
    );
  }
}
export default homeSection1;
