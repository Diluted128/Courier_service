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
     .post("http://localhost:8081/login/client", {"email": email, "password": password})
     .catch(function(error){
       console.log(error);
     })
     .then((result) => {
       res(result);
     }))
 }

 export const loginCourier = (email, password) => {
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/login/courier", {"email": email, "password": password})
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}

 export const client = () => {
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
     .post("http://localhost:8081/client/" + localStorage.getItem("ID") + "/localization/" + district, {"street": street, "localNumber": localNumber, "postalCode": postalcode, "flatNumber": houseNumber, "town": city})
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

    export const sendOrder = (cart, selectedCompany, tip, totalPrice) => {
        return new Promise((res, rej) => 
          axios
         .post("http://localhost:8081/client/" + localStorage.getItem("ID") + "/company/" + selectedCompany + "/orders", {"items": cart, "tip": tip, "total_price": totalPrice})
         .catch(function(error){
           console.log(error);
         })
         .then((result) => {
           res(result);
         }))
     }

     export const getAllOrders = () => {
      return new Promise((res, rej) => 
        axios
       .get("http://localhost:8081/client/" + localStorage.getItem("ID") + "/orders")
       .catch(function(error){
         console.log(error);
       })
       .then((result) => {
         res(result);
       }))
   }
    
   export const getOrderForDeliver= () => {
    return new Promise((res, rej) => 
      axios
     .get("http://localhost:8081/order/deliver/" + localStorage.getItem("ID"))
     .catch(function(error){
       console.log(error);
     })
     .then((result) => {
       res(result);
     }))
 }

 export const deliverOrder = (orderID, distance, reward, deliverID) => {
   console.log(orderID)
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/order/" + orderID + "/distance/" + parseInt(distance) + "/reward/" + reward + "/deliver/" + deliverID)
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}

export const getDeliveredOrdersByDeliver = () => {
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/orders/deliver/" +  localStorage.getItem("ID") + "/delivered")
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}

export const getDeliverInfo = () => {
  return new Promise((res, rej) => 
    axios
   .get("http://localhost:8081/deliver/" +  localStorage.getItem("ID"))
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}

export const saveClientPercel = (street, city, postalcode, houseNumber, localNumber, price, district) => {
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/client/" +  localStorage.getItem("ID") + "/parcel/district/" + district + "/price/" + price, {"street": street, "localNumber": localNumber, "postalCode": postalcode, "flatNumber": houseNumber, "town": city})
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}

export const withdrawDeliverMoney = () => {
  return new Promise((res, rej) => 
    axios
   .post("http://localhost:8081/deliver/" +  localStorage.getItem("ID") + "/withdrawal")
   .catch(function(error){
     console.log(error);
   })
   .then((result) => {
     res(result);
   }))
}


