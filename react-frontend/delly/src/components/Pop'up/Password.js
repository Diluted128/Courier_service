import React, { Component } from "react";
import "../../stylesheets/Pop'up/Password.scss";
import Cross from "../../images/svg/cross.svg";
import ReactDom from "react-dom";

class Login extends Component {
  render() {
    if (this.props.openPopup == false) return null;
    return ReactDom.createPortal(
      <div className="gray-cover">
        <div className="gray-cover__password-recover-block">
          <input
            onClick={this.props.closePopup}
            type="image"
            src={Cross}
            className="gray-cover__password-recover-block__cross-img"
          />
          <span className="gray-cover__password-recover-block__change-password-title">
            <br />
            Zmień hasło
            <br />
          </span>
          <div className="d-flex flex-row gray-cover__password-recover-block__row">
            <form className="gray-cover__password-recover-block__row__form">
              <span className="gray-cover__password-recover-block__row__form__email-text">
                Email
              </span>
              <input
                type="email"
                class="gray-cover__password-recover-block__row__form__email-input"
                aria-describedby="emailHelp"
                placeholder="Wprowadz email"
              />
            </form>
          </div>
          <button
            class="btn-primary"
            className="gray-cover__password-recover-block__send-button"
            type="submit"
          >
            Wyślij
          </button>
          <span className="gray-cover__password-recover-block__info-text">
            Kolejne kroki będą zawarte w <br />
            otrzymanym mailu.
          </span>
          <span
            onClick={this.props.openLogin}
            className="gray-cover__password-recover-block__back-to-login-text"
          >
            Powrót na stronę logowania
          </span>
        </div>
      </div>,
      document.getElementById("portal")
    );
  }
}
export default Login;
