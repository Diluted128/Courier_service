import React, { Component } from "react";
import "../../stylesheets/client/MyData.scss";
import Cross from "../../images/svg/cross.svg";
import ReactDom from "react-dom";


function Login(props){

    if (props.openPopup == false) return null;
    return ReactDom.createPortal(
        <div className="my-data-block">
          <input
            onClick={props.closePopup}
            type="image"
            src={Cross}
            className="my-data-block__cross"
          />
          <span className="my-data-block__title">
            DANE PERSONALNE
            <br />
          </span>
          <hr className="my-data-block__line"></hr>
          <div className="my-data-block__personal-data-container-first">
          <div className="row my-data-block__personal-data-container-first__row">
            <span for="validationDefault01" className="my-data-block__personal-data-container-first__row__label">Imie<span style={{color: "#FF7272"}}> *</span></span>
            <input type="text" class="form-control my-data-block__personal-data-container-first__row__input" id="validationDefault01" placeholder="" value="" required/>
          </div>
          <div className="row my-data-block__personal-data-container-first__row">
            <span for="validationDefault01" className="my-data-block__personal-data-container-first__row__label">Nazwisko<span style={{color: "#FF7272"}}> *</span></span>
            <input type="text" class="form-control my-data-block__personal-data-container-first__row__input" id="validationDefault01" placeholder="" value="" required/>
          </div>
          <div className="row my-data-block__personal-data-container-first__row">
            <span for="validationDefault01" className="my-data-block__personal-data-container-first__row__label">Numer Telefonu</span>
            <input type="text" class="form-control my-data-block__personal-data-container-first__row__input" id="validationDefault01" placeholder="" value="" required/>
          </div>
          <div className="row my-data-block__personal-data-container-first__row">
            <button class="btn btn-primary" className="my-data-block__personal-data-container-first__row__button"type="submit">wyślij</button>
          </div>
          </div>
          <span className="my-data-block__title">
            PŁATNOŚĆ
          </span>
          <hr className="my-data-block__line"></hr>
          <div className="my-data-block__personal-data-container-second">
          <div className="row my-data-block__personal-data-container-second__row">
            <span for="validationDefault01" className="my-data-block__personal-data-container-second__row__label">Numer karty<span style={{color: "#FF7272"}}> *</span></span>
            <input type="text" class="form-control my-data-block__personal-data-container-second__row__input" id="validationDefault01" placeholder="" value="" required/>
          </div>
          <div className="row my-data-block__personal-data-container-second__row">
          <div className="col-6 my-data-block__personal-data-container-second__row__col">
            <span for="validationDefault01" className="my-data-block__personal-data-container-second__row__label">Data<span style={{color: "#FF7272"}}> *</span></span>
            <input type="text" class="form-control my-data-block__personal-data-container-second__row__input" id="validationDefault01" placeholder="" value="" required/>
          </div>
          <div className="col-4 my-data-block__personal-data-container-second__row__col">
            <span for="validationDefault01" className="my-data-block__personal-data-container-second__row__label">CVV<span style={{color: "#FF7272"}}> *</span></span>
            <input type="text" class="form-control my-data-block__personal-data-container-second__row__input" id="validationDefault01" placeholder="" value="" required/>
          </div>
          </div>
          <div className="row my-data-block__personal-data-container-second__row">
            <button class="btn btn-primary" className="my-data-block__personal-data-container-second__row__button"type="submit">wyślij</button>
          </div>
          </div>
       
      </div>,
      document.getElementById("portal")
    )
}
export default Login;
