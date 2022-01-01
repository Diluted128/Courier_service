import React, {Component, useEffect, useState} from "react";
import "../../stylesheets/Pop'up/Registration.scss"
import Cross from "../../images/svg/cross.svg"
import ReactDom from "react-dom";
import {register} from "../../server/fetch-data";

function Registration(props){

  const [email, setEmail] = useState("");
  const [invalidEmailMessage, setInvalidEmailMessage] = useState("");

  const [password, setPassword] = useState("");
  const [invalidPasswordMessage, setInvalidPasswordMessage] = useState("");

  const [secondPassword, setSecondPassword] = useState("");

  const [emptyMessage, setEmptyMessage] = useState("");
  const [emptyMessagePath, setEmptyMessagePath] = useState("");

  useEffect(() => {
     
    if(email.length > 0){
    if(email.match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/))  setInvalidEmailMessage("");
    else if(email.length < 7)  setInvalidEmailMessage("Email jest za krótki");
    else setInvalidEmailMessage("Nieprawidłowy adres email");

  }

  },[email])

  useEffect(() => {
     
    if(password.length > 0){
    if(password.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/))  setInvalidPasswordMessage("");
    else if(password.length < 8) setInvalidPasswordMessage("Hasło jest za krótkie");
    else setInvalidPasswordMessage("Niepoprawny format, hasło powinno zwierać conajmniej 8 znaków w tym jedną dużą literę, liczbę oraz znak specjalny");

  }

  },[password])

  const validateData = async () => {
    if(email.length === 0 || password.length === 0 || secondPassword.length === 0){
      setEmptyMessage("Pola nie mogą być puste");
      setEmptyMessagePath("gray-cover__registration-block__error-message");
    }
    else if(password !== secondPassword){
      setEmptyMessage("Hasła nie są zgodne");
      setEmptyMessagePath("gray-cover__registration-block__error-message");
    }
    else{
      if(invalidEmailMessage.length !== 0 || invalidPasswordMessage.length !== 0){
      setEmptyMessage("Dane są niepoprawne");
      setEmptyMessagePath("gray-cover__registration-block__error-message");
      }
      else{
         const [response] = await Promise.all([register(email, password)]);

         console.log(response);

        if(response){   
        setEmptyMessage(response.data.response);
        setEmptyMessagePath("gray-cover__registration-block__error-message--green");
        }
        else{
        setEmptyMessage("Istnieje już użytkownik o podanym mailu");
        setEmptyMessagePath("gray-cover__registration-block__error-message");
        }
      }
    }
  }

        if(props.openPopup == false) return null;
        return ReactDom.createPortal(
          <div className="gray-cover">
            <div className="gray-cover__registration-block"> 
              <input onClick={props.closePopup} type="image" src={Cross} className="gray-cover__registration-block__cross-img"/>
              <span className="gray-cover__registration-block__title"><br/>Załóż darmowe konto<br/></span>
              <hr className="gray-cover__registration-block__line"></hr>
             <div className="row gray-cover__registration-block__row">
              <label className="gray-cover__registration-block__row__title">Email<span style={{color: "#FF7272"}}> *</span></label>
              <input onInput={e => setEmail(e.target.value)} className="gray-cover__registration-block__row__input"/>
              <div className="gray-cover__registration-block__row__warning-message">{invalidEmailMessage}</div>
             </div>
             <div className="row gray-cover__registration-block__row">
              <label className="gray-cover__registration-block__row__title">Hasło<span style={{color: "#FF7272"}}> *</span></label>
              <input onInput={e => setPassword(e.target.value)} type="password" className="gray-cover__registration-block__row__input"/>
              <div className="gray-cover__registration-block__row__warning-message">{invalidPasswordMessage}</div>
             </div>
             <div className="row gray-cover__registration-block__row">
              <label className="gray-cover__registration-block__row__title">Powtórz hasło<span style={{color: "#FF7272"}}> *</span></label>
              <input onInput={e => setSecondPassword(e.target.value)} type="password" className="gray-cover__registration-block__row__input"/>
             </div>
             <span className={emptyMessagePath}>{emptyMessage}</span>
             <button onClick={validateData} className="btn btn-primary gray-cover__registration-block__registration-button" type="submit">Zarejestruj się</button>
             <span className="gray-cover__registration-block__regulations">Poprzez rejestrację zgadzasz się z <span>warunkami<br/> świadczenia usług i polityką prywatności</span></span>
             <span onClick={props.openLogin} className="gray-cover__registration-block__login-text">Masz już konto? <span>Zaloguj się</span>.</span>
             </div>
            </div>,
            document.getElementById('portal')
        )
    
}
export default Registration;