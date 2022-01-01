import axios from "axios";
import React, { useEffect, useState } from "react";

  export const fetchItems = () => {
    return new Promise((res, rej) => 
       axios
      .get("http://localhost:8081/products")
      .catch(function(error){
        console.log(error);
      })
      .then((result) => {
         res(result);
      }))
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

 export const client = () => {
   console.log("yes")
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/client/" + localStorage.getItem("ID"))
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}

export const sendExtendedPersonalData = (firstName, surname, phonenumber) => {
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/client/refill/" + localStorage.getItem("ID"), {"firstName": firstName, "lastName": surname, "phoneNumber": phonenumber})
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}

export const sendPaymentData = (cardNumber, CVV, expireDate) => {
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/client/" + localStorage.getItem("ID") + "/payment", {"cardNumber": cardNumber, "cvv": CVV, "expired": expireDate})
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
  }

  export const sendLocalizationData = (street, city, postalcode, houseNumber, localNumber, district) => {
    return new Promise((res, rej) => 
      axios
     .post("http://localhost:8081/client/" + localStorage.getItem("ID") + "/localization", {"street": street, "localNumber": localNumber, "postalCode": postalcode, "flatNumber": houseNumber, "town": city, "district": district})
     .catch(function(error){
       console.log(error);
     })
     .then((result) => {
       res(result);
     }))
    }

    export const getAllDistricts = () => {
      return new Promise((res, rej) => 
        axios
       .get("http://localhost:8081/districts")
       .catch(function(error){
         console.log(error);
       })
       .then((result) => {
         res(result);
       }))
      }



