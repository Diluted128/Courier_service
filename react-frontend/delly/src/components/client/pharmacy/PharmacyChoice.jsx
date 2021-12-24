import React, { Component } from "react";
import "../../../stylesheets/client/pharmacy/PharmacyChoice.scss";
import Cross from "../../../images/svg/cross.svg";
import ReactDom from "react-dom";
import { useNavigate } from "react-router-dom";
import PharmacyBanner from "../../../images/client/apteka.png"

function PharmacyChoice(props) {

  if (props.openPharmacy == false) return null;
  return ReactDom.createPortal(
    <div className="gray-cover">
      <div className="gray-cover__pharmacy-choice-block">
      <input onClick={props.close} type="image" src={Cross} className="gray-cover__pharmacy-choice-block__cross"/>    
      <img src={PharmacyBanner} alt="kebab" class="gray-cover__pharmacy-choice-block__banner"></img>
      </div>
    </div>,
    document.getElementById("portal")
  );
}
export default PharmacyChoice;