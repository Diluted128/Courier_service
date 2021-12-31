import React, { Component, useEffect, useState } from "react";
import "../../stylesheets/client/Orders.scss";
import Cross from "../../images/svg/cross.svg";
import { motion, AnimatePresence } from "framer-motion";


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

function Orders(props){
return(

    <AnimatePresence exitBeforeEnter>
    {props.openOrdersData && (
      <motion.div variants={backdrop} className = "gray-cover" initial="hidden" animate="visible">
     <motion.div variants={modal} initial="hidden" animate="visible">
      <div className="orders-block">
        <input
          onClick={props.close}
          type="image"
          src={Cross}
          className="orders-block__cross"
        />
        <span className="orders-block__title">
          ZAMÓWIENIA
          <br />
        </span>
        <hr className="orders-block__line"></hr>
        <div className="orders-block__orders-data-container">
        <div className="row orders-block__orders-data-container__row">
           <div className="col orders-block__orders-data-container__row__col">
             <div className="orders-block__orders-data-container__row__col__text">
                Zamówienie nr 128492
             </div>
           </div>
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
                STATUS: <span style={{"color": "#8EF899"}}>ACTIVE</span>
             </div>
           </div>
        </div>
        <div className="row orders-block__orders-data-container__row">
           <div className="col orders-block__orders-data-container__row__col">
           </div>
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
               Ilość  <span style={{"color": "#FEF074"}}>4</span>
             </div>
           </div>
        </div>
        <div className="row orders-block__orders-data-container__row">
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
                data: 03.12.2021
             </div>
           </div>
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
               Suma <span style={{"color": "#FEF074"}}>94.32 zł</span>
             </div>
           </div>
        </div>
        </div>
        </div>
        </motion.div>
    </motion.div>
     )}
    </AnimatePresence> 
    
)
}
export default Orders;