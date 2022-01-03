import React, { Component } from "react";
import "../../stylesheets/client/Orders.scss";


const backdrop = {
    hidden: {
      opacity: 0
    },
    visible: {
      opacity: 1
    }
}

function OrderRow(props){

return(

        <div className="orders-block__orders-data-container">
        <div className="row orders-block__orders-data-container__row">
           <div className="col orders-block__orders-data-container__row__col">
             <div className="orders-block__orders-data-container__row__col__text">
                Zamówienie nr {props.order.id}
             </div>
           </div>
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
                STATUS: <span style={{"color": "#8EF899"}}>{props.order.status}</span>
             </div>
           </div>
        </div>
        <div className="row orders-block__orders-data-container__row">
           <div className="col orders-block__orders-data-container__row__col">
           </div>
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
             
             </div>
           </div>
        </div>
        <div className="row orders-block__orders-data-container__row">
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
                data: {props.order.date}
             </div>
           </div>
           <div className="col orders-block__orders-data-container__row__col">
           <div className="orders-block__orders-data-container__row__col__text">
               Suma <span style={{"color": "#FEF074"}}>{props.order.total_price} zł</span>
             </div>
           </div>
        </div>
        </div>
)
}
export default OrderRow;