import React, { Component } from "react";
import "../../stylesheets/Pop'up/Login.scss";
import Cross from "../../images/svg/cross.svg";
import ReactDom from "react-dom";

class Login extends Component {
  render() {
    if (this.props.openPopup == false) return null;
    return ReactDom.createPortal(
      <div className="gray-cover">
        <div className="gray-cover__login-block">
          <input
            onClick={this.props.closePopup}
            type="image"
            src={Cross}
            className="gray-cover__login-block__cross"
          />
          <span className="gray-cover__login-block__title">
            <br />
            Witaj ponownie!
            <br />
          </span>
          <span className="gray-cover__login-block__description">
            Nie masz konta? 
            <span
              onClick={this.props.openRegistry}
              className="gray-cover__login-block__description__registration-text"
            >
               Zarejestruj się
            </span>
          </span>
          <div className="d-flex flex-row gray-cover__login-block__flex-row">
            <form className="gray-cover__login-block__flex-row__form">
              <span className="gray-cover__login-block__flex-row__form__title">
                Email
              </span>
              <input
                type="email"
                className="gray-cover__login-block__flex-row__form__input"
                aria-describedby="emailHelp"
                placeholder="Wprowadz email"
              />
            </form>
          </div>
          <div className="d-flex flex-row gray-cover__login-block__flex-row">
            <form className="gray-cover__login-block__flex-row__form">
              <span className="gray-cover__login-block__flex-row__form__title">
                Hasło
              </span>
              <input
                type="email"
                className="gray-cover__login-block__flex-row__form__input"
                aria-describedby="emailHelp"
                placeholder="Wprowadz hasło"
              />
            </form>
          </div>
          <span
            onClick={this.props.openPassword}
            className="gray-cover__login-block__password-recover"
          >
            Przywróć hasło
          </span>
          <button
            className="btn btn-primary gray-cover__login-block__login-button"
            type="submit"
          >
            Zaloguj się
          </button>
        </div>
      </div>,
      document.getElementById("portal")
    );
  }
}
export default Login;
