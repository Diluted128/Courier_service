import React, { Component } from "react";
import "../../../../stylesheets/client/market/markets/Market.scss";
import Cross from "../../../../images/svg/white-cross.svg";
import MarketBanner from "../../../../images/svg/marketBanner.svg";
import ReactDom from "react-dom";
import PharmacyBanner from "../../../../images/svg/pharmacyBanner.svg"

function ZahirKebab(props) {

  if (props.openMarket == false) return null;
  return ReactDom.createPortal(
    <div className="market-block">
      <input
        onClick={props.close}
        type="image"
        src={Cross}
        className="market-block__cross"
      />
      <img
        src={MarketBanner}
        className="market-block__banner"
        alt="section2__wave-svg"
      />
      <h4 className="market-block__title">Leki</h4>
      <hr className="market-block__line"></hr>
      <div className="market-block__item-container">
        <div className="row market-block__item-container__row">
          <div className="col-6 market-block__item-container__row__title-col">
            Jaja 10 sztuk   
          </div>
          <div className="col market-block__item-container__row__title-col"></div>
          <div className="col-2 market-block__item-container__row__price-col">
            6.48
          </div>
        </div>
        <div className="row market-block__item-container__row">
          <div className="col-6 market-block__item-container__row__title-col">
            Masło  200g 
          </div>
          <div className="col market-block__item-container__row__title-col"></div>
          <div className="col-2 market-block__item-container__row__price-col">
            6.49
          </div>
        </div>
        <div className="row market-block__item-container__row">
          <div className="col-6 market-block__item-container__row__title-col">
           Mąka Żytnia 1kg    
          </div>
          <div className="col market-block__item-container__row__title-col"></div>
          <div className="col-2 market-block__item-container__row__price-col">
           3.99
          </div>
        </div>
        <div className="row market-block__item-container__row">
          <div className="col-6 market-block__item-container__row__title-col">
           Makaron     
          </div>
          <div className="col market-block__item-container__row__title-col"></div>
          <div className="col-2 market-block__item-container__row__price-col">
            5.29
          </div>
        </div>
        <div className="row market-block__item-container__row">
          <div className="col-6 market-block__item-container__row__title-col">
           Chleb Żytni      
          </div>
          <div className="col market-block__item-container__row__title-col"></div>
          <div className="col-2 market-block__item-container__row__price-col">
            5.23
          </div>
        </div>
        <div className="row market-block__item-container__row">
          <div className="col-6 market-block__item-container__row__title-col">
           Parówki Berlinki   
          </div>
          <div className="col market-block__item-container__row__title-col"></div>
          <div className="col-2 market-block__item-container__row__price-col">
           4.48
          </div>
        </div>
      </div>
    </div>,
    document.getElementById("portal")
  );
}
export default ZahirKebab;
