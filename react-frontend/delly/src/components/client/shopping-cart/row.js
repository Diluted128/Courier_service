import React, { Component, useEffect } from "react";
import "../../../stylesheets/client/shopping-cart/ShoppingCart.scss";
import RedButton from "../../../images/svg/removeButton.svg";
import GreenButton from "../../../images/svg/addButton.svg"
import { useDispatch, useSelector } from "react-redux";
import { bindActionCreators } from "redux";
import * as actionCreators from "../../../redux/Shopping/shopping-actions"

function ShoppingCart(props) {

  const dispatch = useDispatch()

  const {adjustQty, removeFromCart} = bindActionCreators(actionCreators, dispatch);
  const state = useSelector((state) => state);

  useEffect(() => {
    state.shop.cart.forEach(element => {
        if(element.qty == 0){
            removeFromCart(element.id);
        }
      })
  })
  
  return (

        <div className="row shopping-cart-block__item-container__row">
          <div className="col-6 shopping-cart-block__item-container__row__title-col">
            {props.cart.name} 
          </div>
          <div className="col-2 shopping-cart-block__item-container__row__title-col">
            {props.cart.price} 
          </div>
          <div className="col-2 shopping-cart-block__item-container__row__title-col">
            {props.cart.qty} 
          </div>
          <div className="col-2 shopping-cart-block__item-container__row__title-col">
            <img onClick = {() => adjustQty(props.cart.id, props.cart.qty - 1)} src={RedButton} className="shopping-cart-block__item-container__row__title-col__button"/>
            <img onClick = {() => adjustQty(props.cart.id, props.cart.qty + 1)} src={GreenButton} className="shopping-cart-block__item-container__row__title-col__button"/>
          </div>
        </div>
  );
}
export default ShoppingCart;