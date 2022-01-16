import React, { Component, useEffect, useState } from "react";
import "../../stylesheets/client/Percel.scss";
import Cross from "../../images/svg/cross.svg";
import ReactDom from "react-dom";
import { motion, AnimatePresence } from "framer-motion";
import {getAllDistricts, saveClientPercel} from "../../server/fetch-data.js";

function Localization(props){

    const [street, setStreet] = useState("");
    const [invalidStreetMessage, setInvalidStreetMessage] = useState("");
    const [redStreetBorder, setRedStreetBorder] = useState("form-control dispatch-block__personal-data-container__row__input");

    const [city, setCity] = useState("");
    const [invalidCityMessage, setInvalidCityMessage] = useState("");
    const [redCityBorder, setRedCityBorder] = useState("form-control dispatch-block__personal-data-container__row__input");

    const [postalcode, setPostalcode] = useState("");
    const [invalidPostalcodeMessage, setInvalidPostalcodeMessage] = useState("");
    const [redPostalCodeBorder, setRedPostalcodeBorder] = useState("form-control dispatch-block__personal-data-container__row__input");

    const [houseNumber, setHouseNumber] = useState("");
    const [invalidHouseNumberMessage, setInvalidHouseNumberMessage] = useState("");
    const [redHouseNumberBorder, setRedHouseNumberBorder] = useState("form-control dispatch-block__personal-data-container__row__input");

    const [localNumber, setLocalNumber] = useState("");
    const [invalidLocalNumberMessage, setInvalidLocalNumberMessage] = useState("");
    const [redLocalNumberBorder, setRedLocalNumberBorder] = useState("form-control dispatch-block__personal-data-container__row__input");

    const [district, setDistrict] = useState("Stare Miasto");
    
    const [dimension, setDimension] = useState(0);
    
    const [emptyMessage, setEmptyMessage] = useState("");
    const [emptyMessagePath, setEmptyMessagePath] = useState("");

    const [districts, setDistricts] = useState("");

    const [clientData, setClientData] = useState("");

    useEffect(() => {
     
      if(street.length > 0){
      if(street.match(/^[\w'\-,.][^0-9_!¡?÷?\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/))  setInvalidStreetMessage("");
      else if(street.length < 3)  setInvalidStreetMessage("Ulica jest za krótkia");
      else setInvalidStreetMessage("Ulica posiada niedozwolony znak");

      if(invalidStreetMessage.length !== 0)
         setRedStreetBorder("form-control dispatch-block__personal-data-container__row__input--red");
      else   
         setRedStreetBorder("form-control dispatch-block__personal-data-container__row__input");
    }
 
    },[street])
  
    useEffect(() => {

      if(city.length > 0){
        if(city.match(/^[\w'\-,.][^0-9_!¡?÷?\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/))  setInvalidCityMessage("");
        else if(city.length < 3)  setInvalidCityMessage("Miasto jest za krótkie");
        else setInvalidCityMessage("niedozwolony znak");
  
        if(invalidCityMessage.length !== 0)
           setRedCityBorder("form-control dispatch-block__personal-data-container__row__input--red");
        else   
           setRedCityBorder("form-control dispatch-block__personal-data-container__row__input");
      }

    },[city])

    useEffect(() => {

      if(postalcode.length > 0){
        if(postalcode.match(/^([0-9]{2})(-[0-9]{3})?$/))  setInvalidPostalcodeMessage("");
        else if(postalcode.length < 5)  setInvalidPostalcodeMessage("Kod jest za krótki");
        else if(postalcode.length > 5)  setInvalidPostalcodeMessage("Kod jest za długi");
        else setInvalidPostalcodeMessage("niedozwolony znak");
  
        if(invalidPostalcodeMessage.length === 0)
           setRedPostalcodeBorder("form-control dispatch-block__personal-data-container__row__input--red");
        else   
           setRedPostalcodeBorder("form-control dispatch-block__personal-data-container__row__input");
      }

    },[postalcode])

    useEffect(() => {

      if(houseNumber.length > 0){
        if(houseNumber.match(/^[0-9]{1,3}$|^-$/))  setInvalidHouseNumberMessage("");
        else if(houseNumber.length > 3)  setInvalidHouseNumberMessage("Numer domu jest za długi");
        else setInvalidHouseNumberMessage("niedozwolony znak");
  
        if(invalidHouseNumberMessage.length !== 0)
          setRedHouseNumberBorder("form-control dispatch-block__personal-data-container__row__input--red");
        else   
          setRedHouseNumberBorder("form-control dispatch-block__personal-data-container__row__input");
      }

    },[houseNumber])

    useEffect(() => {

      if(localNumber.length > 0){
        if(localNumber.match(/^[0-9]{1,3}([A-Z]{1,2})?$|^-$/))  setInvalidLocalNumberMessage("");
        else if(localNumber.length > 5) setInvalidLocalNumberMessage("Numer lokalu jest za długi");
        else setInvalidLocalNumberMessage("niedozwolony znak");
  
        if(invalidLocalNumberMessage.length !== 0) 
          setRedLocalNumberBorder("form-control dispatch-block__personal-data-container__row__input--red");
        else   
          setRedLocalNumberBorder("form-control dispatch-block__personal-data-container__row__input");
      }

    },[localNumber])

    useEffect(async () => {
        const [districts] = await Promise.all([getAllDistricts()])
        setDistricts(districts.data);
        console.log(districts.data);
      },[])

    const validateLocationData = () => {
      if(street.length === 0 || city.length === 0 || postalcode.length === 0 || dimension === 0){
         setEmptyMessagePath("dispatch-block__error-message");
         setEmptyMessage("Wymagane pola nie mogą być puste");
      }
      else{
        if(invalidStreetMessage.length === 0 && invalidCityMessage.length === 0 
          && invalidPostalcodeMessage.length === 0 && invalidHouseNumberMessage.length === 0 && invalidLocalNumberMessage.length === 0){
          setEmptyMessagePath("dispatch-block__error-message--green");
          const element = districts.find(element => 
             element.name == district
          );
          saveClientPercel(street, city, postalcode, houseNumber, localNumber, dimension + 5, element.id);
          setEmptyMessage("Dane wysłane");
          window.location.reload();
        }
        else{
          setEmptyMessagePath("dispatch-block__error-message");
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
const close = () => {
  setStreet("");
  setCity("");
  setPostalcode("");
  setLocalNumber("");
  setHouseNumber("");
  setInvalidStreetMessage("");
  setInvalidCityMessage("");
  setInvalidPostalcodeMessage("");
  setInvalidPostalcodeMessage("");
  setInvalidLocalNumberMessage("");
  setInvalidHouseNumberMessage("");
  setRedStreetBorder("form-control dispatch-block__personal-data-container__row__input");
  setRedCityBorder("form-control dispatch-block__personal-data-container__row__input");
  setRedPostalcodeBorder("form-control dispatch-block__personal-data-container__row__input");
  setRedLocalNumberBorder("form-control dispatch-block__personal-data-container__row__input");
  setRedHouseNumberBorder("form-control dispatch-block__personal-data-container__row__input");
  props.close();

}

    return(
      <AnimatePresence exitBeforeEnter>
      {props.open && (
        <motion.div variants={backdrop} className = "gray-cover" initial="hidden" animate="visible">
       <motion.div variants={modal} initial="hidden" animate="visible">
        <div className="dispatch-block">
          <input
            onClick={() => close()}
            type="image"
            src={Cross}
            className="dispatch-block__cross"
          />
          <span className="dispatch-block__title">
            NADAJ PACZKE
            <br />
          </span>
          <hr className="dispatch-block__line"></hr>
          <div className="dispatch-block__personal-data-container">
          <div className="row dispatch-block__personal-data-container__row">
            <label className="dispatch-block__personal-data-container__row__label">Ulica<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setStreet(e.target.value)} placeholder={clientData.street} className={redStreetBorder}/>
            <div className="dispatch-block__personal-data-container__row__warning-message">{invalidStreetMessage}</div>
          </div>
          <div className="row dispatch-block__personal-data-container__row">
            <div className="col-6 dispatch-block__personal-data-container__row__col">
               <label className="dispatch-block__personal-data-container__row__label">Miasto<span style={{color: "#FF7272"}}> *</span></label>
               <input onInput={e => setCity(e.target.value)} placeholder={clientData.town} className={redCityBorder}/>
               <div className="dispatch-block__personal-data-container__row__warning-message">{invalidCityMessage}</div>
            </div>  
            <div className="col-5 dispatch-block__personal-data-container__row__col">
               <label className="dispatch-block__personal-data-container__row__label">Kod-pocztowy<span style={{color: "#FF7272"}}> *</span></label>
               <input onInput={e => setPostalcode(e.target.value)} placeholder={clientData.postalCode} className={redPostalCodeBorder}/>
               <div className="dispatch-block__personal-data-container__row__warning-message">{invalidPostalcodeMessage}</div>
            </div>
          </div>
          <div className="row dispatch-block__personal-data-container__row">
            <div className="col-5 dispatch-block__personal-data-container__row__col">
               <label className="dispatch-block__personal-data-container__row__label">Numer domu</label>
               <input onInput={e => setHouseNumber(e.target.value)} placeholder={clientData.flatNumber} className={redHouseNumberBorder}/>
               <div className="dispatch-block__personal-data-container__row__warning-message">{invalidHouseNumberMessage}</div>
            </div>  
            <div className="col-5 dispatch-block__personal-data-container__row__col">
               <label className="dispatch-block__personal-data-container__row__label">Numer lokalu</label>
               <input onInput={e => setLocalNumber(e.target.value)} placeholder={clientData.localNumber} className={redLocalNumberBorder}/>
               <div className="dispatch-block__personal-data-container__row__warning-message">{invalidLocalNumberMessage}</div>
            </div>
          </div>    
          <div className="row dispatch-block__personal-data-container__row">
          <label className="dispatch-block__personal-data-container__row__label">Dzielnica</label>
          <select onChange={e => setDistrict(e.target.value)} className="form-control form-control dispatch-block__personal-data-container__row__input">
           <option>Stare Miasto</option>
           <option>Krowodrza</option>
           <option>Zwierzyniec</option>
           <option>Dębniki</option>
           <option>Podgórze</option>
           <option>Grzegórzki</option>
           </select>
          </div>
          <div class="dispatch-block__form-check">
          <input onClick={() => setDimension(5)}type="radio" name="gridRadios" id="gridRadios1" className = "form-check-input dispatch-block__form-check__input"/>
          <label for="gridRadios1" className="form-check-label dispatch-block__form-check__label">
            Gabaryt <span style={{"color": "#9EE17F"}}>A</span> - 8 x 38 x 64 cm, <br/>maksymalna waga <span style={{"color": "#F27070"}}>5 kg</span>
          </label>
          <input onClick={() => setDimension(8)} type="radio" name="gridRadios" id="gridRadios1" className = "form-check-input dispatch-block__form-check__input"/>
          <label for="gridRadios1" className="form-check-label dispatch-block__form-check__label">
            Gabaryt <span style={{"color": "yellow"}}>B</span> - 19 x 38 x 64 cm,<br/>maksymalna waga <span style={{"color": "#F27070"}}>5 kg</span>
          </label>
        </div>
        <hr className="dispatch-block__line-two"></hr>
        <h4 className="shopping-cart-block__title">Podsumowanie</h4>
        <div className="shopping-cart-block__sum">Dostawa: 5 zł</div>
        <div className="shopping-cart-block__sum">Gabaryt: {dimension}zł</div>
        <div className="shopping-cart-block__sum">Suma:  {dimension + 5}zł</div>
        <span className={emptyMessagePath}>{emptyMessage}</span>
        <button onClick={validateLocationData} className= "dispatch-block__button" type="submit">wyślij</button>
        
       
          </div>
      </div>
       </motion.div>
     </motion.div>
     )}
    </AnimatePresence> 
    )
}
export default Localization;
