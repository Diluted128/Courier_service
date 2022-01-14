import React, { useEffect, useState } from "react";
import "../../stylesheets/courier/newOrder.scss";
import { motion, AnimatePresence } from "framer-motion";
import {getOrderForDeliver, deliverOrder, getDeliveredOrdersByDeliver} from "../../server/fetch-data.js"
import Map from "../map/map"

function NewOrder(props){

    const [order, setOrder] = useState();
    const [distance, setDistance] = useState(0);

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

   
    useEffect(async () => {
      const [deliverOrder] = await Promise.all([getOrderForDeliver()]);
  
      if(deliverOrder.data !== null){
        setOrder(deliverOrder.data)
     }
     
    }, []);

    const calculateReward = (distance) => {
      return Math.floor((distance / 1000) * 200) / 100;
    }

     const sendData = () => {
       console.log(typeof(calculateReward(distance)))
       console.log(calculateReward(distance))
        deliverOrder(order.orders.id, distance, calculateReward(distance));
        props.close();
     }

    return(
        <AnimatePresence exitBeforeEnter>
        {props.open && (
          <motion.div variants={backdrop} className = "gray-cover" initial="hidden" animate="visible">
         <motion.div variants={modal} initial="hidden" animate="visible">
          <div className="new-order-block">
            <span className="new-order-block__title">
              Nowe Zamówienie!
              <br />
            </span>
            <hr className="new-order-block__line"></hr>
            <span className='new-order-block__text'>Nadawca</span>
            <div className="new-order-block__address-data-container">
                <div className="row new-order-block__address-data-container__row">
                <div className="col new-order-block__address-data-container__row__col">
                <div className="ew-order-block__address-data-container__row__col__text">
                    Ulica:&nbsp; <span style={{"color": "#8EF899"}}>{order.packAddress.street}</span>
                </div>
            </div>
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                    Miasto:&nbsp; <span style={{"color": "#8EF899"}}>{order.packAddress.town}</span>
                </div>
            </div>
            </div>
            <div className="row new-order-block__address-data-container__row">
            <div className="col new-order-block__address-data-container__row__col">
            Kod-pocztowy:&nbsp; <span style={{"color": "#8EF899"}}>{order.packAddress.postalCode}</span>
            </div>
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                  
                </div>
            </div>
            </div>
            <div className="row new-order-block__address-data-container__row">
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                    Numer Domu:&nbsp; <span style={{"color": "#8EF899"}}>{order.packAddress.flatNumber}</span>
                </div>
            </div>
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                    Numer lokalu:&nbsp; <span style={{"color": "#8EF899"}}>{order.packAddress.localNumber}</span>
                </div>
            </div>
            </div>
            </div>
            <span className='new-order-block__text'>Adresat</span>
            <div className="new-order-block__address-data-container">
                <div className="row new-order-block__address-data-container__row">
                <div className="col new-order-block__address-data-container__row__col">
                <div className="ew-order-block__address-data-container__row__col__text">
                    Ulica:&nbsp; <span style={{"color": "#F7FA73"}}>{order.clientAddress.street}</span>
                </div>
            </div>
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                    Miasto:&nbsp; <span style={{"color": "#F7FA73"}}>{order.clientAddress.town}</span>
                </div>
            </div>
            </div>
            <div className="row new-order-block__address-data-container__row">
            <div className="col new-order-block__address-data-container__row__col">
            Kod-pocztowy:&nbsp; <span style={{"color": "#F7FA73"}}>{order.clientAddress.postalCode}</span>
            </div>
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                  
                </div>
            </div>
            </div>
            <div className="row new-order-block__address-data-container__row">
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                    Numer Domu:&nbsp; <span style={{"color": "#F7FA73"}}>{order.clientAddress.flatNumber}</span>
                </div>
            </div>
            <div className="col new-order-block__address-data-container__row__col">
            <div className="new-order-block__address-data-container__row__col__text">
                    Numer lokalu:&nbsp; <span style={{"color": "#F7FA73"}}>{order.clientAddress.localNumber}</span>
                </div>
            </div>
            </div>
            </div>
                <div className="new-order-block__map">
                <Map setDistance={(distance) => setDistance(distance)} curier={order.courierLocation}
                     pack = {order.packAddress.street + " " + order.packAddress.flatNumber + "/" + order.packAddress.localNumber 
                     + " " + order.packAddress.town + " " + order.packAddress.postalCode}
                     client = {order.clientAddress.street + " " + order.clientAddress.flatNumber + "/" 
                     + order.clientAddress.localNumber + " " + order.clientAddress.town + " " + order.clientAddress.postalCode}/>
                </div>
              
            <button
            className="btn btn-primary new-order-block__button new-order-block__button--red"
            onClick={props.close}
            type="submit"
          >
            Odrzuć
          </button>
          <button
            className="btn btn-primary new-order-block__button new-order-block__button--green"
            onClick={sendData}
            type="submit"
          >
            Dostarcz
          </button>
          </div>
          
        </motion.div>
      </motion.div>
      )}
      </AnimatePresence> 
    );
}
export default NewOrder;
