import React, { Component, useState } from "react";
import "../../stylesheets/Pop'up/Login.scss";
import Cross from "../../images/svg/cross.svg";
import ReactDom from "react-dom";
import {useNavigate} from "react-router-dom"
import {login} from "../../server/fetch-data";

function Login(props){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState("");

    const navigate = useNavigate();

    const validateCredentials = async () => {
      const [response] = await Promise.all([login(email, password)]);

      console.log(response);

      if(response){ 
        localStorage.setItem("ID", response.data.ID)  
        navigate("/client");
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
