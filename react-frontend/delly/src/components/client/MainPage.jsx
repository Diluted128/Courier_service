
import "../../stylesheets/client/MainPage.scss";
import WhiteLogo from "../../images/homePage/box-logo-white.png";
import {useNavigate} from "react-router-dom"
import background1 from "../../images/mainPage/background.svg";
import Lock from "../../images/homePage/lock.png";
import FastFood from "../../images/mainPage/fast-food.png";
import Food from "../../images/mainPage/food.png";
import Medicine from "../../images/mainPage/medicines.png";
import Percel from "../../images/mainPage/percel.png";
import { useState } from "react";
import RestaurantChoice from "../../components/client/restaurant/RestaurantChoice.jsx"
import MarketChoice from "../../components/client/market/MarketChoice.jsx"
import PharmacyChoice from "../../components/client/pharmacy/PharmacyChoice.jsx"
import Server from "../../server/fetch-data"
function MainPage() {

  const navigate = useNavigate();
  
  const [market, setMarket] = useState(false);
  const [pharmacy, setPharmacy] = useState(false);
  const [percel, setPercel] = useState(false);
  const [restaurant, setRestaurant] = useState(false);

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
                onClick={() => {navigate("/")}}
                type="image"
                src={Lock}
                className="client-side__fluid-container__first_row__row__item__lock-svg"
              />
            </div>
          </div>
        </div>
        <div className="container-fluid client-side__fluid-container__circles-container">
          <span className="client-side__fluid-container__circles-container__main-text">
            Co dzisiaj zamawiamy?
          </span>
          <div className="d-flex client-side__fluid-container__circles-container__second-row">
            <div onClick={() => {setMarket(true)}} className="client-side__fluid-container__circles-container__second-row__item">
              <span className="client-side__fluid-container__circles-container__second-row__item__circle client-side__fluid-container__circles-container__second-row__item__circle--green">
                <img
                  src={Food}
                  className="client-side__fluid-container__circles-container__second-row__item__circle__img"
                />
                <span className="client-side__fluid-container__circles-container__second-row__item__circle__text">
                  Artykuły <br />
                  Spożywcze
                </span>
              </span>
            </div>
            <div onClick={() => setPharmacy(true)} className="client-side__fluid-container__circles-container__second-row__item">
              <span className="client-side__fluid-container__circles-container__second-row__item__circle client-side__fluid-container__circles-container__second-row__item__circle--blue">
                <img
                  src={Medicine}
                  className="client-side__fluid-container__circles-container__second-row__item__circle__img"
                />
                <span className="client-side__fluid-container__circles-container__second-row__item__circle__text">
                  Apteka
                </span>
              </span>
            </div>
            <div className="client-side__fluid-container__circles-container__second-row__item">
              <span className="client-side__fluid-container__circles-container__second-row__item__circle client-side__fluid-container__circles-container__second-row__item__circle--purple">
                <img
                  src={Percel}
                  className="client-side__fluid-container__circles-container__second-row__item__circle__img"
                />
                <span className="client-side__fluid-container__circles-container__second-row__item__circle__text">
                  Kurier
                </span>
              </span>
            </div>
            <div onClick={() => setRestaurant(true)} className="client-side__fluid-container__circles-container__second-row__item">
              <span className="client-side__fluid-container__circles-container__second-row__item__circle client-side__fluid-container__circles-container__second-row__item__circle--orange">
                <img
                  src={FastFood}
                  className="client-side__fluid-container__circles-container__second-row__item__circle__img"
                />
                <span className="client-side__fluid-container__circles-container__second-row__item__circle__text">
                  Jedzenie
                </span>
              </span>
            </div>
            <MarketChoice openMarket={market} close={ () => setMarket(false)}/>
            <PharmacyChoice openPharmacy={pharmacy} close={ () => setPharmacy(false)}/>
            <RestaurantChoice openRestaurant={restaurant} close={ () => setRestaurant(false)}/>
            <Server/>
          </div>
        </div>
      </div>
    </div>
  );
}
export default MainPage;
