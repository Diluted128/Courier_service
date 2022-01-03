import "../../stylesheets/client/MainPage.scss";
import WhiteLogo from "../../images/homePage/box-logo-white.png";
import { useNavigate } from "react-router-dom";
import background1 from "../../images/mainPage/background.svg";
import Lock from "../../images/homePage/lock.png";
import { useEffect, useState } from "react";
import {fetchItems} from "../../server/fetch-data";
import * as actionCreators from "../../redux/Shopping/shopping-actions"
import { bindActionCreators } from "redux";
import { useDispatch, useSelector } from "react-redux";

function MainPage() {

  const state = useSelector((state) => state);

  const dispatch = useDispatch();

  const {setItems} = bindActionCreators(actionCreators, dispatch);

  useEffect(() => {
    
  }, []);

//   const navigate = useNavigate();
 
//   const close = () => {
//      localStorage.clear();
//      navigate("/")
//   }

  return (
    <div className="client-side">
      <img src={background1} className="client-side__background-svg" />
      <div className="container-fluid client-side__fluid-container">
        <div className="col client-side__fluid-container__first_row">
          <div className="d-flex flex-row client-side__fluid-container__first_row__row">
            <div className="client-side__fluid-container__first_row__row__item">
              <img
                src={WhiteLogo}
                className="client-side__fluid-container__first_row__row__item__logo-img"
                alt="Box logo"
              />
              <span className="client-side__fluid-container__first_row__row__item__logo_text">
                Delly
              </span>
            </div>
            <div className="client-side__fluid-container__first_row__row__item">
              <a
                href="#Oferta"
                className="client-side__fluid-container__first_row__row__item__text"
          
              >
                Moje Dane
              </a>
            </div>
            <div className="client-side__fluid-container__first_row__row__item">
              <a
                href="#Wspolpraca"
                className="client-side__fluid-container__first_row__row__item__text"
      
              >
                Zamówienia
              </a>
            </div>
            <div className="client-side__fluid-container__first_row__row__item">
              <a
                href="#Lokalizacja"
                className="client-side__fluid-container__first_row__row__item__text"
             
              >
                Lokalizacja
              </a>
            </div>
            <div className="p-3 ml-auto p-2 client-side__fluid-container__first_row__row__item">

              <input
                
                type="image"
                src={Lock}
                className="client-side__fluid-container__first_row__row__item__lock-svg"
              />
            </div>
          </div>
        </div>
        </div>
    </div>
  );
}
export default MainPage;
