import React, { Component } from "react";
import "../../../../stylesheets/client/restaurant/resturants/Restaurants.scss";
import Cross from "../../../../images/svg/white-cross.svg";
import KebabBanner from "../../../../images/svg/sphagetiiBanner.svg";
import ReactDom from "react-dom";
import Sphagetii1 from "../../../../images/client/spaghetii1-circle.png";
import Sphagetii2 from "../../../../images/client/spaghetii2-circle.png";
import Sphagetii3 from "../../../../images/client/spaghetii3-circle.png";

function Makarun(props) {
  if (props.openMakarun == false) return null;
  return ReactDom.createPortal(
    <div className="restaurant-block">
      <input
        onClick={props.close}
        type="image"
        src={Cross}
        className="restaurant-block__cross"
      />
      <img
        src={KebabBanner}
        className="restaurant-block__banner"
        alt="section2__wave-svg"
      />
      <h4 className="restaurant-block__title">GŁÓWNE DANIA</h4>
      <hr className="restaurant-block__line"></hr>
      <div className="restaurant-block__dishes-container">
        <div className="row restaurant-block__dishes-container__row">
          <div className="col-3 restaurant-block__dishes-container__row__circle-col">
            <img
              src={Sphagetii1}
              alt="kebab1"
              className="restaurant-block__dishes-container__row__circle-col__image"
            ></img>
          </div>
          <div className="col restaurant-block__dishes-container__row__title-col">
            Rollo Kebab same mięso
          </div>
          <div className="col-2 restaurant-block__dishes-container__row__price-col">
            24.00
          </div>
        </div>
        <div className="row restaurant-block__dishes-container__row">
          <div className="col-3 restaurant-block__dishes-container__row__circle-col">
            <img
              src={Sphagetii2}
              alt="kebab1"
              className="restaurant-block__dishes-container__row__circle-col__image"
            ></img>
          </div>
          <div className="col restaurant-block__dishes-container__row__title-col">
            Rolo Kebab Amerykański
          </div>
          <div className="col-2 restaurant-block__dishes-container__row__price-col">
            21.00
          </div>
        </div>
        <div className="row restaurant-block__dishes-container__row">
          <div className="col-3 restaurant-block__dishes-container__row__circle-col">
            <img
              src={Sphagetii3}
              alt="kebab1"
              className="restaurant-block__dishes-container__row__circle-col__image"
            ></img>
          </div>
          <div className="col restaurant-block__dishes-container__row__title-col">
            Rolo Kebab Amerykański
          </div>
          <div className="col-2 restaurant-block__dishes-container__row__price-col">
            21.00
          </div>
        </div>
      </div>
      <hr className="restaurant-block__line"></hr>
      <h4 className="restaurant-block__title">NAPOJE</h4>
      <div className="restaurant-block__drink-container">
        <div className="row restaurant-block__drink-container__row">
          <div className="col-6 restaurant-block__drink-container__row__title-col">
            Coca Cola 0.5L
          </div>
          <div className="col restaurant-block__drink-container__row__title-col"></div>
          <div className="col-2 restaurant-block__drink-container__row__price-col">
            5.99
          </div>
        </div>
        <div className="row restaurant-block__drink-container__row">
          <div className="col-6 restaurant-block__drink-container__row__title-col">
            Mirinda 0,85L
          </div>
          <div className="col restaurant-block__drink-container__row__title-col"></div>
          <div className="col-2 restaurant-block__drink-container__row__price-col">
            9.99
          </div>
        </div>
        <div className="row restaurant-block__drink-container__row">
          <div className="col-6 restaurant-block__drink-container__row__title-col">
            7UP 0,85L
          </div>
          <div className="col restaurant-block__drink-container__row__title-col"></div>
          <div className="col-2 restaurant-block__drink-container__row__price-col">
            9.99
          </div>
        </div>
      </div>
    </div>,
    document.getElementById("portal")
  );
}
export default Makarun;
