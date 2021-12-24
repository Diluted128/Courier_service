import React, { Component } from "react";
import "../../../stylesheets/client/restaurant/RestaurantChoice.scss";
import Cross from "../../../images/svg/cross.svg";
import ReactDom from "react-dom";
import { useNavigate } from "react-router-dom";
import KebabBanner from "../../../images/client/kebab.png"
import PizzaBanner from "../../../images/client/pizza.png"
import MakarunBanner from "../../../images/client/spageti.png"
import McDonaldBanner from "../../../images/client/mcdonald.png"

function RestaurantChoice(props) {

  if (props.openRestaurant == false) return null;
  return ReactDom.createPortal(
    <div className="gray-cover">
      <div className="gray-cover__restaurant-choice-block">
        <input onClick={props.close}type="image" src={Cross} className="gray-cover__restaurant-choice-block__cross"/>    
        <div class="container gray-cover__restaurant-choice-block__restaurants-container">
          <div class="row container gray-cover__restaurant-choice-block__restaurants-container__row">
              <img src={KebabBanner} alt="kebab" class="gray-cover__restaurant-choice-block__restaurants-container__row__banner"></img>
          </div>
          <div class="row container gray-cover__restaurant-choice-block__restaurants-container__row">
              <img src={PizzaBanner} alt="kebab" class="gray-cover__restaurant-choice-block__restaurants-container__row__banner"></img>
          </div>
          <div class="row container gray-cover__restaurant-choice-block__restaurants-container__row">
              <img src={MakarunBanner} alt="kebab" class="gray-cover__restaurant-choice-block__restaurants-container__row__banner"></img>
          </div>
          <div class="row container gray-cover__restaurant-choice-block__restaurants-container__row">
              <img src={McDonaldBanner} alt="kebab" class="gray-cover__restaurant-choice-block__restaurants-container__row__banner"></img>
          </div>
        </div>
      </div>
    </div>,
    document.getElementById("portal")
  );
}
export default RestaurantChoice;
