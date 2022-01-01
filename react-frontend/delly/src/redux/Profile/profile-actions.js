import * as actionTypes from "./profile-types";

export const addToCart = () => {
    return (dispatch) => {
        dispatch({
        type: actionTypes.SET_MY_DATA,
        })
    }
}

export const removeFromCart = () => {
    return (dispatch) => {
        dispatch({
        type: actionTypes.SET_ORDERS,
    })
    }
}

export const adjustQty = () => {
    return (dispatch) => {
        dispatch({
        type: actionTypes.SET_LOCALIZATION,
    })
    }
}