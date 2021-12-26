import * as actionTypes from "./shopping-types";

export const addToCart = (itemID) => {
    return (dispatch) => {
        dispatch({
        type: actionTypes.ADD_TO_CARD,
        payload: {
            id: itemID
        }
        })
    }
}

export const removeFromCart = (itemID) => {
    return (dispatch) => {
        dispatch({
        type: actionTypes.REMOVE_FROM_CART,
        payload: {
            id: itemID
        }
    })
    }
}

export const adjustQty = (itemID, value) => {
    return (dispatch) => {
        dispatch({
        type: actionTypes.ADJUST_QTY,
        payload: {
            id: itemID,
            qty: value,
        }
    })
    }
}

export const setItems = (items) => {
    return (dispatch) => {
        dispatch({
        type: actionTypes.SET_ITEMS,
        payload: items,
    })
  }
}
