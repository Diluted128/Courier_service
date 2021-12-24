import React, { Component } from "react";
import "../../../stylesheets/client/market/MarketChoice.scss";
import Cross from "../../../images/svg/cross.svg";
import ReactDom from "react-dom";
import { useNavigate } from "react-router-dom";
import MarketBanner from "../../../images/client/biedronka.png"

function MarketChoice(props) {
  
  if (props.openMarket == false) return null;
  return ReactDom.createPortal(
    <div className="gray-cover">
      <div className="gray-cover__market-choice-block">
      <input onClick={props.close} type="image" src={Cross} className="gray-cover__market-choice-block__cross"/>    
      <img src={MarketBanner} alt="kebab" class="gray-cover__market-choice-block__banner"></img>
      </div>
    </div>,
    document.getElementById("portal")
  );
}
export default MarketChoice;