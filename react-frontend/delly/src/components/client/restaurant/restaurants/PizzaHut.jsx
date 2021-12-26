import React, { Component } from "react";
import "../../../../stylesheets/client/restaurant/resturants/Restaurants.scss";
import Cross from "../../../../images/svg/white-cross.svg";
import PizzaBanner from "../../../../images/svg/pizzaBanner.svg";
import ReactDom from "react-dom";
import Pizza1 from "../../../../images/client/pizza1-circle.png";
import Pizza2 from "../../../../images/client/pizza2-circle.png";
import Pizza3 from "../../../../images/client/pizza3-circle.png";
import { useDispatch } from "react-redux";
import { bindActionCreators } from "redux";
import * as actionCreators from "../../../../redux/Shopping/shopping-actions"

function PizzaHut(props) {

  const dispatch = useDispatch()

  const {addToCart} = bindActionCreators(actionCreators, dispatch);

  if (props.openPizza == false) return null;
  return ReactDom.createPortal(
    <div className="restaurant-block">
      <input
        onClick={props.close}
        type="image"
        src={Cross}
        className="restaurant-block__cross"
      />
      <img
        src={PizzaBanner}
        className="restaurant-block__banner"
        alt="section2__wave-svg"
      />
      <h4 className="restaurant-block__title">GŁÓWNE DANIA</h4>
      <hr className="restaurant-block__line"></hr>
      <div className="restaurant-block__dishes-container">
        <div onClick = {() => addToCart(16)} className="row restaurant-block__dishes-container__row">
          <div className="col-3 restaurant-block__dishes-container__row__circle-col">
            <img
              src={Pizza1}
              alt="kebab1"
              className="restaurant-block__dishes-container__row__circle-col__image"
            ></img>
          </div>
          <div className="col restaurant-block__dishes-container__row__title-col">
            Pizza Supreme
          </div>
          <div className="col-2 restaurant-block__dishes-container__row__price-col">
            24.00
          </div>
        </div>
        <div onClick = {() => addToCart(15)} className="row restaurant-block__dishes-container__row">
          <div className="col-3 restaurant-block__dishes-container__row__circle-col">
            <img
              src={Pizza2}
              alt="kebab1"
              className="restaurant-block__dishes-container__row__circle-col__image"
            ></img>
          </div>
          <div className="col restaurant-block__dishes-container__row__title-col">
            Pizza Peperoni
          </div>
          <div className="col-2 restaurant-block__dishes-container__row__price-col">
            21.00
          </div>
        </div>
        <div onClick = {() => addToCart(14)} className="row restaurant-block__dishes-container__row">
          <div className="col-3 restaurant-block__dishes-container__row__circle-col">
            <img
              src={Pizza3}
              alt="kebab1"
              className="restaurant-block__dishes-container__row__circle-col__image"
            ></img>
          </div>
          <div className="col restaurant-block__dishes-container__row__title-col">
            Pizza Texas
          </div>
          <div className="col-2 restaurant-block__dishes-container__row__price-col">
            21.00
          </div>
        </div>
      </div>
      <hr className="restaurant-block__line"></hr>
      <h4 className="restaurant-block__title">NAPOJE</h4>
      <div className="restaurant-block__drink-container">
        <div onClick = {() => addToCart(5)} className="row restaurant-block__drink-container__row">
          <div className="col-6 restaurant-block__drink-container__row__title-col">
            Coca Cola 0.5L
          </div>
          <div className="col restaurant-block__drink-container__row__title-col"></div>
          <div className="col-2 restaurant-block__drink-container__row__price-col">
            5.99
          </div>
        </div>
        <div onClick = {() => addToCart(18)} className="row restaurant-block__drink-container__row">
          <div className="col-6 restaurant-block__drink-container__row__title-col">
            Mirinda 0,85L
          </div>
          <div className="col restaurant-block__drink-container__row__title-col"></div>
          <div className="col-2 restaurant-block__drink-container__row__price-col">
            9.99
          </div>
        </div>
        <div onClick = {() => addToCart(19)} className="row restaurant-block__drink-container__row">
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
export default PizzaHut;
