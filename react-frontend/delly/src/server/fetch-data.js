import axios from "axios";
import React, { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { bindActionCreators } from "redux";
import * as actionCreators from "../redux/Shopping/shopping-actions"
import Registration from "../components/Pop'up/Registration";
  

  // const {setItems} = bindActionCreators(actionCreators, dispatch);

  // const dispatch = useDispatch();

  export const fetchItems = async () => {
    const response = await axios
      .get("http://localhost:8081/products")
      .catch((err) => {
        console.log("Err", err);
      });
      // setItems(response.data);
  };

  export const register = (email, password) => {
     return new Promise((res, rej) => 
       axios
      .post("http://localhost:8081/register", {"email": email, "password": password})
      .catch(function(error){
        console.log(error);
      })
      .then((result) => {
        res(result);
      }))
  }

  export const login = (email, password) => {
    return new Promise((res, rej) => 
      axios
     .post("http://localhost:8081/login", {"email": email, "password": password})
     .catch(function(error){
       console.log(error);
     })
     .then((result) => {
       res(result);
     }))
 }



