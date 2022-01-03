import React, { Component, useEffect, useState } from "react";
import "../../stylesheets/client/Orders.scss";
import Cross from "../../images/svg/cross.svg";
import { motion, AnimatePresence } from "framer-motion";
import {getAllOrders} from "../../server/fetch-data"
import OrderRow from "./OrderRow";

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

  const [orders, setOrders] = useState();

  useEffect(async () => {
    const [orders] = await Promise.all([getAllOrders()]);
    console.log(orders.data);
    setOrders(orders.data);
  },[])

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
        {orders.map((order) => (
           <OrderRow order={order}/>
        ))}
        </div>
        </motion.div>
    </motion.div>
     )}
    </AnimatePresence> 
    
)
}
export default Orders;