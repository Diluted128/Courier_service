import * as actionTypes from "./profile-types";

const INITIAL_STATE = {
    myData: false,
    orders: false,
    localization: false,
}

const profileReducer = (state = INITIAL_STATE, action) => {
    switch(action.type){
        case actionTypes.SET_MY_DATA:
            return {
                ...state,
                myData: true
            }
        case actionTypes.SET_ORDERS:
            return {
                ...state,
                orders: true
            }
        case actionTypes.SET_LOCALIZATION:
            return {
                ...state,
                location: true
            }
        default:
            return state;    

    }
}

export default profileReducer;