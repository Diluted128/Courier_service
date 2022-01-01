import React, { Component, useEffect, useState } from "react";
import "../../../stylesheets/client/shopping-cart/ShoppingCart.scss";
import Cross from "../../../images/svg/white-cross.svg";
import ReactDom from "react-dom";
import Row from "./row.js"
import { useSelector } from "react-redux";
import { motion, AnimatePresence } from "framer-motion";
import {client} from "../../../server/fetch-data";

function ShoppingCart(props) {
  
  const [totalPrice, setTotalPrice] = useState(0);
  const [totalItems, setTotalItems] = useState(0);
  const [errorMessage, setErrorMessage] = useState("");

  const state = useSelector((state) => state);
 
  useEffect( () => {
      let price = 0;
      let items = 0;

      state.shop.cart.forEach(element => {
        items += element.qty;
        price += element.qty * element.price;
      })
      
      setTotalItems(items);
      setTotalPrice(price);
  })

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

  const validate = async () => {
    const [clientResponse] = await Promise.all([client()]);
 
    const clientData = clientResponse.data;

    console.log(clientData)

    if(clientData.firstName === null || clientData.lastName === null || clientData.phoneNumber === null){
       setErrorMessage("Proszę uzupełnić dane osobowe");
    }
    else if(clientData.creditCard === null){
       setErrorMessage("Proszę uzupełnić dane płatnościowe");
    }
    else if(clientData.address === null){
      setErrorMessage("Proszę uzupełnić dane aktualnej lokalizacji");
    }
    else{
      // POOOOOOOOOOOOOOOORTAL
    }
  }

  if (props.openShoppingCart == false) return null;
  return(

    <AnimatePresence exitBeforeEnter>
      {props.openShoppingCart  && (
    <motion.div variants={backdrop} className = "gray-cover" initial="hidden" animate="visible">
    <motion.div variants={modal} initial="hidden" animate="visible">
    <div className="shopping-cart-block">
      <input
        onClick={props.close}
        type="image"
        src={Cross}
        className="shopping-cart-block__cross"
      />
      <h2 className="shopping-cart-block__title">Koszyk</h2>
      <hr className="shopping-cart-block__line"></hr>
      <div className="shopping-cart-block__item-container">
        {state.shop.cart.map((prod) => (
           <Row cart={prod}/>
        ))}
      </div>
      <hr className="shopping-cart-block__line"></hr>
      <h4 className="shopping-cart-block__title">Podsumowanie</h4>
      <div className="shopping-cart-block__sum">Ilość: {totalItems}</div>
      <div className="shopping-cart-block__sum">Suma: {totalPrice} zł</div>
      <button
            className="btn btn-primary shopping-cart-block__button"
            type="submit"
            onClick={() => validate()}
          >Akceptuj</button>
      <span className="shopping-cart-block__error-message">{errorMessage}</span>    
    </div>
    </motion.div>
    </motion.div>
     )}
    </AnimatePresence> 
    
  );
}
export default ShoppingCart;
