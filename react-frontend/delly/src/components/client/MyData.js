import React, { Component, useEffect, useState } from "react";
import "../../stylesheets/client/MyData.scss";
import Cross from "../../images/svg/cross.svg";
import { motion, AnimatePresence } from "framer-motion";
import {client, sendExtendedPersonalData, sendPaymentData} from "../../server/fetch-data"

function Login(props){

    const [name, setName] = useState("");
    const [invalidNameMessage, setInvalidNameMessage] = useState("");
  
    const [surname, setSurname] = useState("");
    const [invalidSurnameMessage, setInvalidSurnameMessage] = useState("");

    const [phone, setPhone] = useState("");
    const [invalidPhoneMessage, setInvalidPhoneMessage] = useState("");

    const [cardNumber, setCardNumber] = useState("");
    const [invalidCardNumberMessage, setInvalidCardNumberMessage] = useState("");
    const [redCardNumberBorder, setRedCardNumerBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [date, setDate] = useState("");
    const [invalidDateMessage, setInvalidDateMessage] = useState("");
    const [redDateBorder, setRedDateBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [CVV, setCVV] = useState("");
    const [invalidCVVMessage, setInvalidCVVMessage] = useState("");
    const [redCVVBorder, setRedCVVBorder] = useState("form-control my-data-block__personal-data-container__row__input");

    const [emptyMessage, setEmptyMessage] = useState("");
    const [emptyMessagePath, setEmptyMessagePath] = useState("");

    const [clientData, setClientData] = useState("");
    const [payment, setPayment] = useState();
   

    useEffect(() => {
     
      if(name.length > 0){
      if(name.match(/^[\w'\-,.][^0-9_!¡?÷?\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/))  setInvalidNameMessage("");
      else if(name.length < 3)  setInvalidNameMessage("Imię jest za krótkie");
      else setInvalidNameMessage("Imię posiada niedozwolony znak");
    }
 
    },[name])
  
    useEffect(() => {

      if(surname.length > 0){
        if(surname.match(/^[\w'\-,.][^0-9_!¡?÷?\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/))  setInvalidSurnameMessage("");
        else if(surname.length < 3)  setInvalidSurnameMessage("Nazwisko jest za krótkie");
        else setInvalidSurnameMessage("Nazwisko posiada niedozwolony znak");
      }

    },[surname])

    useEffect(() => {

      if(phone.length > 0){
        if(phone.length < 12)  setInvalidPhoneMessage("Numer telefonu jest za krótki format[+[two numbers][phone number]]");
        else if(phone.match(/^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im))  setInvalidPhoneMessage("");
        else setInvalidPhoneMessage("Numer telefonu posiada niedozwolony znak");
      }

    },[phone])

    useEffect(() => {

      if(cardNumber.length > 0){
        if(cardNumber.match(/^(?:4[0-9]{12}(?:[0-9]{3})?)$/))  setInvalidCardNumberMessage("");
        else if(cardNumber.length < 16)  setInvalidCardNumberMessage("Numer karty jest za krótki");
        else setInvalidCardNumberMessage("Numer karty posiada niedozwolony znak");
  
        if(invalidCardNumberMessage.length === 0)
          setRedCardNumerBorder("form-control my-data-block__personal-data-container__row__input--red");
        else   
          setRedCardNumerBorder("form-control my-data-block__personal-data-container__row__input");
      }

    },[cardNumber])

    useEffect(() => {

      if(date.length > 0){
        if(date.match(/^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/))  setInvalidDateMessage("");
        else setInvalidDateMessage("Nieprawidłowy format: [dd/mm/yyyy]");
  
        if(invalidDateMessage.length === 0) 
          setRedDateBorder("form-control my-data-block__personal-data-container__row__input--red");
        else   
          setRedDateBorder("form-control my-data-block__personal-data-container__row__input");
      }

    },[date])

    useEffect(() => {

      if(CVV.length > 0){
        if(CVV.match(/^[0-9]{3}$/))  setInvalidCVVMessage("");
        else if(CVV.length < 3)  setInvalidCVVMessage("CVV jest za krótki");
        else if(CVV.length > 3)  setInvalidCVVMessage("CVV jest za długi");
        else setInvalidCVVMessage("CVV posiada niedozwolony znak");
  
        if(invalidCVVMessage.length === 0) 
          setRedCVVBorder("form-control my-data-block__personal-data-container__row__input--red");
        else   
          setRedCVVBorder("form-control my-data-block__personal-data-container__row__input");
      }

    },[CVV])

    useEffect(async () => {
      const [clientResponse] = await Promise.all([client()]);
      setClientData(clientResponse.data);
      console.log(clientResponse.data);

      if(clientResponse.data.creditCard === null){
        console.log("NIE OK");
        setPayment({cardNumber: "", expired: "", cvv: ""})
      }
      else{
        console.log("OK");
        setPayment({cardNumber: clientResponse.data.creditCard.cardNumber, expired: clientResponse.data.creditCard.expired, cvv: clientResponse.data.creditCard.cvv})
      }
    },[])

    const validatePersonalData = () => {
       if(name.length === 0 || surname.length === 0 || phone.length === 0 ){
        setEmptyMessagePath("my-data-block__error-message");
        setEmptyMessage("Pola danych personalnych mogą być puste");
       }
       else{
       if(invalidNameMessage.length === 0 && invalidSurnameMessage.length === 0 && invalidPhoneMessage.length === 0){
        setEmptyMessagePath("my-data-block__error-message--green")
        sendExtendedPersonalData(name, surname, phone);
        setEmptyMessage("Dane wysłane, proszę czekać");
        window.location.reload();
       }
       else{
        setEmptyMessagePath("my-data-block__error-message");
        setEmptyMessage("Pola danych personalnych są niepoprawne");
       }
      }
    }

    const validateCreditCardData = () => {
      if(cardNumber.length === 0 || date.length === 0 || CVV.length === 0 ){
         setEmptyMessagePath("my-data-block__error-message");
         setEmptyMessage("Pola płatności nie mogą być puste");
      }
      else{
        if(invalidCardNumberMessage.length === 0 && invalidDateMessage.length === 0 && invalidCVVMessage.length === 0){
          setEmptyMessagePath("my-data-block__error-message--green")
          sendPaymentData(cardNumber, CVV, date);
          setEmptyMessage("Dane wysłane");
          window.location.reload();
        }
        else{
          setEmptyMessagePath("my-data-block__error-message");
          setEmptyMessage("Pola płatności są niepoprawne");
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
  setName("");
  setSurname("");
  setPhone("");
  setCardNumber("");
  setDate("");
  setCVV("");
  setInvalidNameMessage("");
  setInvalidSurnameMessage("");
  setInvalidPhoneMessage("");
  setInvalidCardNumberMessage("");
  setInvalidDateMessage("");
  setInvalidCVVMessage("");
  setRedCardNumerBorder("form-control my-data-block__personal-data-container__row__input");
  setRedDateBorder("form-control my-data-block__personal-data-container__row__input");
  setRedCardNumerBorder("form-control my-data-block__personal-data-container__row__input");
  props.close();

}
    return(
      <AnimatePresence exitBeforeEnter>
      {props.openPersonalData && (
        <motion.div variants={backdrop} className = "gray-cover" initial="hidden" animate="visible">
       <motion.div variants={modal} initial="hidden" animate="visible">
        <div className="my-data-block">
          <input
            onClick={() => close()}
            type="image"
            src={Cross}
            className="my-data-block__cross"
          />
          <span className="my-data-block__title">
            DANE PERSONALNE
            <br />
          </span>
          <hr className="my-data-block__line"></hr>
          <div className="my-data-block__personal-data-container">
          <div className="row my-data-block__personal-data-container__row">
            <label className="my-data-block__personal-data-container__row__label">Imie<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setName(e.target.value)} placeholder={clientData.firstName} className="form-control my-data-block__personal-data-container__row__input"/>
            <div className="my-data-block__personal-data-container__row__warning-message">{invalidNameMessage}</div>
          </div>
          <div className="row my-data-block__personal-data-container__row">
            <label className="my-data-block__personal-data-container__row__label">Nazwisko<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setSurname(e.target.value)} placeholder={clientData.lastName} className="form-control my-data-block__personal-data-container__row__input"/>
            <div className="my-data-block__personal-data-container__row__warning-message">{invalidSurnameMessage}</div>
          </div>
          <div className="row my-data-block__personal-data-container__row">
            <label className="my-data-block__personal-data-container__row__label">Telefon<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setPhone(e.target.value)} placeholder={clientData.phoneNumber} className="form-control my-data-block__personal-data-container__row__input"/>
            <div className="my-data-block__personal-data-container__row__warning-message">{invalidPhoneMessage}</div>
          </div>
          <button onClick={() => validatePersonalData()} className="btn btn-primary" className="my-data-block__personal-data-container__button" type="submit">wyślij</button>
       
          </div>
          <span className="my-data-block__title">
            PŁATNOŚĆ
          </span>
          <hr className="my-data-block__line"></hr>
          <div className="my-data-block__personal-data-container">
          <div className="row my-data-block__personal-data-container__row">
            <label className="my-data-block__personal-data-container__row__label">Numer karty<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setCardNumber(e.target.value)}  placeholder={payment.cardNumber} className={redCardNumberBorder}/>
            <div className="my-data-block__personal-data-container__row__warning-message">{invalidCardNumberMessage}</div>
          </div>
          <div className="row my-data-block__personal-data-container__row">
          <div className="col-6 my-data-block__personal-data-container__row__col">
            <label className="my-data-block__personal-data-container__row__label">Data<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setDate(e.target.value)} placeholder={payment.expired} className={redDateBorder}/>
            <div className="my-data-block__personal-data-container__row__warning-message">{invalidDateMessage}</div>
          </div>
          <div className="col-4 my-data-block__personal-data-container__row__col">
            <label className="my-data-block__personal-data-container__row__label">CVV<span style={{color: "#FF7272"}}> *</span></label>
            <input onInput={e => setCVV(e.target.value)} placeholder={payment.cvv} className={redCVVBorder}/>
            <div className="my-data-block__personal-data-container__row__warning-message">{invalidCVVMessage}</div>
          </div>
          </div>
          <button className="btn btn-primary" onClick={() => validateCreditCardData()} className="my-data-block__personal-data-container__button"type="submit">wyślij</button>
          <span className={emptyMessagePath}>{emptyMessage}</span>
          </div>
       
      </div>
      </motion.div>
    </motion.div>
     )}
    </AnimatePresence> 
    )
}
export default Login;
