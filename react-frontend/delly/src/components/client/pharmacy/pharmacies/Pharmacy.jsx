import React, { Component } from "react";
import "../../../../stylesheets/client/pharmacy/pharmacies/Pharmacy.scss";
import Cross from "../../../../images/svg/white-cross.svg";
import KebabBanner from "../../../../images/svg/kebabBanner.svg";
import ReactDom from "react-dom";
import Kebab1 from "../../../../images/client/kebab1-circle.png";
import Kebab2 from "../../../../images/client/kebab2-circle.png";
import Kebab3 from "../../../../images/client/kebab3-circle.png";
import PharmacyBanner from "../../../../images/svg/pharmacyBanner.svg"
import { useDispatch } from "react-redux";
import { bindActionCreators } from "redux";
import * as actionCreators from "../../../../redux/Shopping/shopping-actions"

function ZahirKebab(props) {

  const dispatch = useDispatch()

  const {addToCart} = bindActionCreators(actionCreators, dispatch);

  if (props.openPharmacy == false) return null;
  return ReactDom.createPortal(

    <div className="pharmacy-block">
      <input
        onClick={props.close}
        type="image"
        src={Cross}
        className="pharmacy-block__cross"
      />
      <img
        src={PharmacyBanner}
        className="pharmacy-block__banner"
        alt="section2__wave-svg"
      />
      <h4 className="pharmacy-block__title">Leki</h4>
      <hr className="pharmacy-block__line"></hr>
      <div className="pharmacy-block__item-container">
        <div onClick = {() => addToCart(26)} className="row pharmacy-block__item-container__row">
          <div className="col-6 pharmacy-block__item-container__row__title-col">
            Ibuprom 50szt    
          </div>
          <div className="col pharmacy-block__item-container__row__title-col"></div>
          <div className="col-2 pharmacy-block__item-container__row__price-col">
            15.99
          </div>
        </div>
        <div onClick = {() => addToCart(27)} className="row pharmacy-block__item-container__row">
          <div className="col-6 pharmacy-block__item-container__row__title-col">
            Gripex 12szt 
          </div>
          <div className="col pharmacy-block__item-container__row__title-col"></div>
          <div className="col-2 pharmacy-block__item-container__row__price-col">
            18.99
          </div>
        </div>
        <div onClick = {() => addToCart(28)} className="row pharmacy-block__item-container__row">
          <div className="col-6 pharmacy-block__item-container__row__title-col">
            Flegamina 40szt   
          </div>
          <div className="col pharmacy-block__item-container__row__title-col"></div>
          <div className="col-2 pharmacy-block__item-container__row__price-col">
            17.99
          </div>
        </div>
        <div onClick = {() => addToCart(29)} className="row pharmacy-block__item-container__row">
          <div className="col-6 pharmacy-block__item-container__row__title-col">
            Termometr elektryczny     
          </div>
          <div className="col pharmacy-block__item-container__row__title-col"></div>
          <div className="col-2 pharmacy-block__item-container__row__price-col">
            12.99
          </div>
        </div>
      </div>
    </div>,
    document.getElementById("portal")
  );
}
export default ZahirKebab;
