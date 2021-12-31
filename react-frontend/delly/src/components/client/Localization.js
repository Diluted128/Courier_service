import React, { Component, useEffect, useState } from "react";
import "../../stylesheets/client/MyData.scss";
import Cross from "../../images/svg/cross.svg";
import ReactDom from "react-dom";
import { motion, AnimatePresence } from "framer-motion";

function Localization(props){

    const [street, setStreet] = useState("");
    const [invalidStreetMessage, setInvalidStreetMessage] = useState("");
    const [redStreetBorder, setRedStreetBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [city, setCity] = useState("");
    const [invalidCityMessage, setInvalidCityMessage] = useState("");
    const [redCityBorder, setRedCityBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [postalcode, setPostalcode] = useState("");
    const [invalidPostalcodeMessage, setInvalidPostalcodeMessage] = useState("");
    const [redPostalCodeBorder, setRedPostalcodeBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [houseNumber, setHouseNumber] = useState("");
    const [invalidHouseNumberMessage, setInvalidHouseNumberMessage] = useState("");
    const [redHouseNumberBorder, setRedHouseNumberBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [localNumber, setLocalNumber] = useState("");
    const [invalidLocalNumberMessage, setInvalidLocalNumberMessage] = useState("");
    const [redLocalNumberBorder, setRedLocalNumberBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [emptyMessage, setEmptyMessage] = useState("");
    const [emptyMessagePath, setEmptyMessagePath] = useState("");

    useEffect(() => {
     
      if(street.length > 0){
      if(street.match(/^[\w'\-,.][^0-9_!¡?÷?\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/))  setInvalidStreetMessage("");
      else if(street.length < 3)  setInvalidStreetMessage("Ulica jest za krótkia");
      else setInvalidStreetMessage("Ulica posiada niedozwolony znak");

      if(invalidStreetMessage.length !== 0)
         setRedStreetBorder("form-control my-data-block__personal-data-container__row__input--red");
      else   
         setRedStreetBorder("form-control my-data-block__personal-data-container__row__input");
    }
 
    },[street])
  
    useEffect(() => {

      if(city.length > 0){
        if(city.match(/^[\w'\-,.][^0-9_!¡?÷?\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/))  setInvalidCityMessage("");
        else if(city.length < 3)  setInvalidCityMessage("Miasto jest za krótkie");
        else setInvalidCityMessage("niedozwolony znak");
  
        if(invalidCityMessage.length !== 0)
           setRedCityBorder("form-control my-data-block__personal-data-container__row__input--red");
        else   
           setRedCityBorder("form-control my-data-block__personal-data-container__row__input");
      }

    },[city])

    useEffect(() => {

      if(postalcode.length > 0){
        if(postalcode.match(/^([0-9]{2})(-[0-9]{3})?$/))  setInvalidPostalcodeMessage("");
        else if(postalcode.length < 5)  setInvalidPostalcodeMessage("Kod jest za krótki");
        else if(postalcode.length > 5)  setInvalidPostalcodeMessage("Kod jest za długi");
        else setInvalidPostalcodeMessage("niedozwolony znak");
  
        if(invalidPostalcodeMessage.length === 0)
           setRedPostalcodeBorder("form-control my-data-block__personal-data-container__row__input--red");
        else   
           setRedPostalcodeBorder("form-control my-data-block__personal-data-container__row__input");
      }

    },[postalcode])

    useEffect(() => {

      if(houseNumber.length > 0){
        if(houseNumber.match(/^[0-9]{1,3}$/))  setInvalidHouseNumberMessage("");
        else if(houseNumber.length > 3)  setInvalidHouseNumberMessage("Numer domu jest za długi");
        else setInvalidHouseNumberMessage("niedozwolony znak");
  
        if(invalidHouseNumberMessage.length !== 0)
          setRedHouseNumberBorder("form-control my-data-block__personal-data-container__row__input--red");
        else   
          setRedHouseNumberBorder("form-control my-data-block__personal-data-container__row__input");
      }

    },[houseNumber])

    useEffect(() => {

      if(localNumber.length > 0){
        if(localNumber.match(/^[0-9]{1,3}([A-Z]{1,2})?$/))  setInvalidLocalNumberMessage("");
        else if(localNumber.length > 5) setInvalidLocalNumberMessage("Numer lokalu jest za długi");
        else setInvalidLocalNumberMessage("niedozwolony znak");
  
        if(invalidLocalNumberMessage.length !== 0) 
          setRedLocalNumberBorder("form-control my-data-block__personal-data-container__row__input--red");
        else   
          setRedLocalNumberBorder("form-control my-data-block__personal-data-container__row__input");
      }

    },[localNumber])


    const validateCreditCardData = () => {
      if(street.length === 0 || city.length === 0 || postalcode.length === 0){
         setEmptyMessagePath("my-data-block__error-message");
         setEmptyMessage("Wymagane pola nie mogą być puste");
      }
      else{
        if(invalidStreetMessage.length === 0 && invalidCityMessage.length === 0 
          && invalidPostalcodeMessage.length === 0 && invalidHouseNumberMessage.length === 0 && invalidLocalNumberMessage.length === 0){
          setEmptyMessagePath("my-data-block__error-message--green")
          setEmptyMessage("Dane wysłane");
        }
        else{
          setEmptyMessagePath("my-data-block__error-message");
          setEmptyMessage("Pola lokalizacji są niepoprawne");
        }
      }
   }

   const backdrop = {
    hidden: {
      opacity: 0
    },
    visible: {
      opacity: 1
    }
}

const modal = {
  hidden: {
    y: "-100vh",
    opacity: 0
  },
  visible: {
    y: "50vh",
    x: '0px',
    opacity: 1,
    transition: {delay: 0.1}
  }
}

    return(
      <AnimatePresence exitBeforeEnter>
      {props.openLocalizationData && (
        <motion.div variants={backdrop} className = "gray-cover" initial="hidden" animate="visible">
       <motion.div variants={modal} initial="hidden" animate="visible">
        <div className="my-data-block">
          <input
            onClick={props.close}
            type="image"
            src={Cross}
            className="my-data-block__cross"
          />
          <span className="my-data-block__title">
            LOKALIZACJA
            <br />
          </span>
          <hr className="my-data-block__line"></hr>
          <div className="my-data-block__personal-data-container">
          <div className="row my-data-block__personal-data-container__row">
            <label className="my-data-block__personal-data-container__row__label">Ulica<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setStreet(e.target.value)} className={redStreetBorder}/>
            <div className="my-data-block__personal-data-container__row__warning-message">{invalidStreetMessage}</div>
          </div>
          <div className="row my-data-block__personal-data-container__row">
            <div className="col-6 my-data-block__personal-data-container__row__col">
               <label className="my-data-block__personal-data-container__row__label">Miasto<span style={{color: "#FF7272"}}> *</span></label>
               <input onInput={e => setCity(e.target.value)} className={redCityBorder}/>
               <div className="my-data-block__personal-data-container__row__warning-message">{invalidCityMessage}</div>
            </div>  
            <div className="col-5 my-data-block__personal-data-container__row__col">
               <label className="my-data-block__personal-data-container__row__label">Kod-pocztowy<span style={{color: "#FF7272"}}> *</span></label>
               <input onInput={e => setPostalcode(e.target.value)} className={redPostalCodeBorder}/>
               <div className="my-data-block__personal-data-container__row__warning-message">{invalidPostalcodeMessage}</div>
            </div>
          </div>
          <div className="row my-data-block__personal-data-container__row">
            <div className="col-5 my-data-block__personal-data-container__row__col">
               <label className="my-data-block__personal-data-container__row__label">Numer domu</label>
               <input onInput={e => setHouseNumber(e.target.value)} className={redHouseNumberBorder}/>
               <div className="my-data-block__personal-data-container__row__warning-message">{invalidHouseNumberMessage}</div>
            </div>  
            <div className="col-5 my-data-block__personal-data-container__row__col">
               <label className="my-data-block__personal-data-container__row__label">Numer lokalu</label>
               <input onInput={e => setLocalNumber(e.target.value)} className={redLocalNumberBorder}/>
               <div className="my-data-block__personal-data-container__row__warning-message">{invalidLocalNumberMessage}</div>
            </div>
          </div>    
          <button onClick={() => validateCreditCardData()} class="btn btn-primary" className="my-data-block__personal-data-container__button" type="submit">wyślij</button>
          <span className={emptyMessagePath}>{emptyMessage}</span>
       
          </div>
      </div>
       </motion.div>
     </motion.div>
     )}
    </AnimatePresence> 
    )
}
export default Localization;
