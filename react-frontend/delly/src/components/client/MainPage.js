import "../../stylesheets/client/MainPage.scss";
import WhiteLogo from "../../images/homePage/box-logo-white.png";
import { useNavigate } from "react-router-dom";
import background1 from "../../images/mainPage/background.svg";
import Lock from "../../images/homePage/lock.png";
import FastFood from "../../images/mainPage/fast-food.png";
import Food from "../../images/mainPage/food.png";
import Medicine from "../../images/mainPage/medicines.png";
import Percel from "../../images/mainPage/percel.png";
import { useEffect, useState } from "react";
import RestaurantChoice from "./restaurant/RestaurantChoice.js";
import ShoppingCart from "./shopping-cart/ShoppingCart.js";
import MarketChoice from "./market/MarketChoice.js";
import PharmacyChoice from "./pharmacy/PharmacyChoice.js";
import Server from "../../server/fetch-data";
import ShoppingCartSVG from "../../images/svg/shopping-cart.svg";
import { useSelector } from "react-redux";
import WarningBanner from "./WarningBanner"

function MainPage() {
  const [market, setMarket] = useState(false);
  const [pharmacy, setPharmacy] = useState(false);
  const [percel, setPercel] = useState(false);
  const [restaurant, setRestaurant] = useState(false);
  const [counter, setCounter] = useState(0);
  const [openShoppingCart, setShoppingCart] = useState(false);
  const [openWarningBanner, setWarningBanner] = useState(false);

  const state = useSelector((state) => state);

  useEffect(() => {
    let count = 0;
    state.shop.cart.forEach((item) => {
      count += item.qty;
    });
    setCounter(count);
  }, [state.shop.cart]);

  useEffect(() => {

      // if(state.shop.banner === 1)
      // setWarningBanner(true);
      // else
      // setWarningBanner(false);

      if(state.shop.banner === 1){
      setWarningBanner(true);
      setTimeout(() => setWarningBanner(false), 8000)
      }

  }, [state.shop.banner])

  const navigate = useNavigate();

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
              <img
                onClick={() => setShoppingCart(true)}
                type="image"
                src={ShoppingCartSVG}
                className="client-side__fluid-container__first_row__row__item__shopping-cart-svg"
              />

              <div className="client-side__fluid-container__first_row__row__item__counter">
                {counter}
              </div>
              <input
                onClick={() => {
                  navigate("/");
                }}
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
            <div
              onClick={() => {
                setMarket(true);
              }}
              className="client-side__fluid-container__circles-container__second-row__item"
            >
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
            <div
              onClick={() => setPharmacy(true)}
              className="client-side__fluid-container__circles-container__second-row__item"
            >
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
            <div
              onClick={() => setRestaurant(true)}
              className="client-side__fluid-container__circles-container__second-row__item"
            >
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
            <MarketChoice openMarket={market} close={() => setMarket(false)} />
            <PharmacyChoice
              openPharmacy={pharmacy}
              close={() => setPharmacy(false)}
            />
            <RestaurantChoice
              openRestaurant={restaurant}
              close={() => setRestaurant(false)}
            />
            <ShoppingCart
              openShoppingCart={openShoppingCart}
              close={() => setShoppingCart(false)}
            />
            
            <Server />
          </div>
        </div>
        <WarningBanner openWarningBanner={openWarningBanner}/>
      </div>
    </div>
  );
}
export default MainPage;