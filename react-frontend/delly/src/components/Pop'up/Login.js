import React, { Component, useState } from "react";
import "../../stylesheets/Pop'up/Login.scss";
import Cross from "../../images/svg/cross.svg";
import ReactDom from "react-dom";
import {useNavigate} from "react-router-dom"
import {login, loginCourier} from "../../server/fetch-data";

function Login(props){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState("");

    const navigate = useNavigate();

    const validateCredentials = async () => {
      const [responseClient] = await Promise.all([login(email, password)]);
      const [responseCurier] = await Promise.all([loginCourier(email, password)]);
 
      console.log(responseClient);
      console.log(responseCurier)
      
      if(responseClient){ 
        localStorage.setItem("ID", responseClient.data.ID)  
        navigate("/client");
      }
      else if(responseCurier){
        localStorage.setItem("ID", responseCurier.data.ID)  
        navigate("/courier");
      }
      else
        setErrorMessage("Dane są nieprawidłowe");
      
    }

    if (props.openPopup == false) return null;
    return ReactDom.createPortal(
      <div className="gray-cover">
        <div className="gray-cover__login-block">
          <input
            onClick={props.closePopup}
            type="image"
            src={Cross}
            className="gray-cover__login-block__cross"h
          />
          <span className="gray-cover__login-block__title">
            <br />
            Witaj ponownie!
            <br />
          </span>
          <span className="gray-cover__login-block__description">
            Nie masz konta? 
            <span
              onClick={props.openRegistry}
              className="gray-cover__login-block__description__registration-text"
            >
               Zarejestruj się
            </span>
          </span>
          <div className="d-flex flex-row gray-cover__login-block__flex-row">
            <form className="gray-cover__login-block__flex-row__form">
              <span className="gray-cover__login-block__flex-row__form__title">
                Email
              </span>
              <input
                type="email"
                className="gray-cover__login-block__flex-row__form__input"
                onInput={e => setEmail(e.target.value)}
              />
            </form>
          </div>
          <div className="d-flex flex-row gray-cover__login-block__flex-row">
            <form className="gray-cover__login-block__flex-row__form">
              <span className="gray-cover__login-block__flex-row__form__title">
                Hasło
              </span>
              <input
                type="password"
                className="gray-cover__login-block__flex-row__form__input"
                onInput={e => setPassword(e.target.value)}
              />
            </form>
          </div>
          <span className="gray-cover__login-block__error-message" style={{"color": "#f84949"}}>{errorMessage}</span>
          <span 
            onClick={props.openPassword}
            className="gray-cover__login-block__password-recover"
          >
            Przywróć hasło
          </span>
          <button
            className="btn btn-primary gray-cover__login-block__login-button"
            onClick={() => {validateCredentials()}}
            type="submit"
          >
            Zaloguj się
          </button>
        </div>
      </div>,
      document.getElementById("portal")
    )
}
export default Login;
