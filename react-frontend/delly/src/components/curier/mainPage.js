import "../../stylesheets/courier/mainPage.scss";
import WhiteLogo from "../../images/homePage/box-logo-white.png";
import { useNavigate } from "react-router-dom";
import background1 from "../../images/mainPage/background.svg";
import Lock from "../../images/homePage/lock.png";
import { useEffect, useState } from "react";
import {getOrderForDeliver, getDeliveredOrdersByDeliver, getDeliverInfo, withdrawDeliverMoney} from "../../server/fetch-data.js"
import Order from "./newOrder"
import NewOrderRow from "./newOrderRow"
import WarningBanner from "../../images/curierWarning.png"

function MainPage() {

  const [dane, setDane] = useState(null);
  const [deliverInfo, setDeliverInfo] = useState(null);
  const [orders, setOrders] = useState(null);
  const [open, setOpen] = useState(false);
  const [openBanner, setOpenBanner] = useState(false);

  useEffect(async () => {

    const [deliverInfo] = await Promise.all([getDeliverInfo()]);
    setDeliverInfo(deliverInfo);

    const [deliveredOrder] = await Promise.all([getDeliveredOrdersByDeliver()]);
    setDane(deliveredOrder);

    const [deliverOrder] = await Promise.all([getOrderForDeliver()]);
    console.log(deliverOrder)

    if(deliverOrder.data.length === 0){
       setOrders(null);
       setOpen(false);
    }
    else{
    setOrders(deliverOrder);
    setOpen(true);
    }

  }, []);

  const navigate = useNavigate();
 
  const withdrawal = () => {
    withdrawDeliverMoney();
    window.location.reload();
  }
  const close = () => {
     localStorage.clear();
     navigate("/")
  }

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
            <div className="p-3 ml-auto p-2 client-side__fluid-container__first_row__row__item">
              <input
                type="image"
                src={Lock}
                className="client-side__fluid-container__first_row__row__item__lock-svg"
                onClick={() => close()}
              />
            </div>
          </div>
        </div>
        <div className="row client-side__fluid-container__panel">   
        <div className="col-6 client-side__fluid-container__panel__orders-col">
            <div className="client-side__fluid-container__panel__orders-col__orders">
                <span className="client-side__fluid-container__panel__orders-col__orders__title"> ZAROBKI<br/></span>
                <hr className="client-side__fluid-container__panel__orders-col__orders__line"></hr>
                 {dane !== null ? dane.data.map((element) => 
                   <NewOrderRow deliveredOrders={element}/>
                 ) : null}
            </div>
           
        </div>
        <div className="col client-side__fluid-container__panel__statstics-col">
        {deliverInfo !== null ? 
            <div className="row client-side__fluid-container__panel__statstics-col__balance">
              
               <div className="row client-side__fluid-container__panel__statstics-col__balance__row client-side__fluid-container__panel__statstics-col__balance__row--big-size">
                    Saldo: <span style={{"color": "#99F18B"}}>&nbsp;&nbsp;{Math.floor(deliverInfo.data.cash * 100) / 100}</span>&nbsp; zł
               </div>
               <div onClick={() => withdrawal()} className="btn client-side__fluid-container__panel__statstics-col__balance__withdraw-button">wypłać</div>
                <div className="row client-side__fluid-container__panel__statstics-col__balance__row">
                    Ilość przebytej trasy: <span style={{"color": "#F7FA73"}}>&nbsp;&nbsp;{deliverInfo.data.distance}</span>&nbsp; km
               </div>
            </div>
           : null }
        </div>
        </div>
        </div>
        {openBanner ? 
        <img src={WarningBanner} className="client-side__banner"/>
         : null}
        {orders !== null ? orders.data.map((element) => 
          <Order clientAddress={element.clientAddress} packAddress={element.packAddress} courierLocation = {element.courierLocation} 
          id={element.orders.id} open={open} close={() => setOpen(false)} openBanner={() => setOpenBanner(true)}/>
        ) : console.log("Nie OK")}
            
      
    </div>
  );
}
export default MainPage;