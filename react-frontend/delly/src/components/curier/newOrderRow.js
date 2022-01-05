import React, { useEffect, useState } from "react";

function NewOrderRow(props){

    const [deliverCost, setDeliverCost] = useState(0)

    useEffect(() => {
       setDeliverCost(props.deliveredOrders.total_price - props.deliveredOrders.tip)
    }, [])

    return(
        <div className="client-side__fluid-container__panel__orders-col__orders__order-block">
        <div className="row client-side__fluid-container__panel__orders-col__orders__order-block__row">
        <div className="col-6 client-side__fluid-container__panel__orders-col__orders__order-block__row__col">
            <div className="client-side__fluid-container__panel__orders-col__orders__order-block__row__col__text">
              Zamówienie nr {props.deliveredOrders.id}
            </div>
        </div>
        <div className="col client-side__fluid-container__panel__orders-col__orders__order-block__row__col">
            <div className="client-side__fluid-container__panel__orders-col__orders__order-block__row__col__text">
                   Napiwek<span style={{"color": "#F7FA73"}}>+<span style={{"color": "#99F18B"}}>{props.deliveredOrders.tip}</span></span>
                </div>
            </div>
        </div>
        <div className="row client-side__fluid-container__panel__orders-col__orders__order-block__row">
        <div className="col-6 client-side__fluid-container__panel__orders-col__orders__order-block__row__col">
        </div>
        <div className="col client-side__fluid-container__panel__orders-col__orders__order-block__row__col">
        <div className="client-side__fluid-container__panel__orders-col__orders__order-block__row__col__text">
            </div>
        </div>
        </div>
        <div className="row client-side__fluid-container__panel__orders-col__orders__order-block__row">
        <div className="col-6 client-side__fluid-container__panel__orders-col__orders__order-block__row__col">
        <div className="client-side__fluid-container__panel__orders-col__orders__order-block__row__col__text">
                data: {props.deliveredOrders.date}
            </div>
        </div>
        <div className="col client-side__fluid-container__panel__orders-col__orders__order-block__row__col">
        <div className="client-side__fluid-container__panel__orders-col__orders__order-block__row__col__text">
             
            </div>
        </div>
        </div>
    </div>
    )

} export default NewOrderRow;