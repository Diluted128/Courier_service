import React, { Component } from "react";
import ReactDom from "react-dom";
import "../../stylesheets/Pop'up/Apply.scss";
import Cross from "../../images/svg/cross.svg";

class Apply extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    if (this.props.openPopup == false) return null;
    return ReactDom.createPortal(
      <div className="gray-cover">
        <div className="gray-cover__apply-block">
          <input
            onClick={this.props.closeApply}
            type="image"
            src={Cross}
            className="gray-cover__apply-block__cross-img"
          />
          <span className="gray-cover__apply-block__title">
            <br />
            Aplikuj na stanowisko!
            <br />
          </span>
          <span className="gray-cover__apply-block__description">
            Uzupełnij dane i wyślisz formularz. <br />
            Odezwiemy się!
          </span>
          <div className="d-flex flex-row gray-cover__apply-block__flex-container">
            <form className="gray-cover__apply-block__flex-container__form">
              <span className="gray-cover__apply-block__flex-container__form__title">
                Typ zgłoszenia
              </span>
              <select
                class="form-control2"
                className="gray-cover__apply-block__flex-container__form__text-input"
              >
                <option>Kurier</option>
                <option>Pracownik</option>
                <option>Firma Lojalnościowa</option>
              </select>
            </form>
          </div>
          <div className="d-flex flex-row gray-cover__apply-block__flex-container">
            <form className="gray-cover__apply-block__flex-container__form">
              <span className="gray-cover__apply-block__flex-container__form__title">
                Email
              </span>
              <input
                type="email"
                className="gray-cover__apply-block__flex-container__form__text-input"
                aria-describedby="emailHelp"
                placeholder="Wprowadz email"
              />
            </form>
          </div>
          <div className="d-flex flex-row gray-cover__apply-block__flex-container">
            <form className="gray-cover__apply-block__flex-container__form">
              <span className="gray-cover__apply-block__flex-container__form__title">
                Imię i nazwisko / Nazwa firmy
              </span>
              <input
                type="email"
                className="gray-cover__apply-block__flex-container__form__text-input"
                aria-describedby="emailHelp"
                placeholder="Wprowadz imię i nazwisko lub nazwę firmy"
              />
            </form>
          </div>
          <div className="d-flex flex-row gray-cover__apply-block__flex-container">
            <form className="gray-cover__apply-block__flex-container__form">
              <span className="gray-cover__apply-block__flex-container__form__title">
                Numer telefonu
              </span>
              <input
                type="email"
                className="gray-cover__apply-block__flex-container__form__text-input"
                aria-describedby="emailHelp"
                placeholder="Wprowadz numer telefonu"
              />
            </form>
          </div>
          <button
            className="btn btn-primary"
            className="gray-cover__apply-block__send-button"
            type="submit"
          >
            Wyślij
          </button>
        </div>
      </div>,
      document.getElementById("portal")
    );
  }
}
export default Apply;
