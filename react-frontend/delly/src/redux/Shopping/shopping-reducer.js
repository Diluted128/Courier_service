import * as actionTypes from "./shopping-types";

const INITIAL_STATE = {
    products: [],
    cart: [],
    selectedCompany: 0,
    banner: 0,
}
const shopReducer = (state = INITIAL_STATE, action) => {
    switch(action.type){
        case actionTypes.ADD_TO_CARD:

        const item = state.products.find(prod => prod.id === action.payload.id);

        const inCart = state.cart.find(item => item.id == action.payload.id ? true : false);

        const SameCompany = state.selectedCompany === 0 || state.selectedCompany === item.company_id;

            return {
                ...state,
                cart:  SameCompany ? (inCart ? state.cart.map(item => item.id === action.payload.id ? {...item, qty: item.qty + 1} : item) : [...state.cart, {...item, qty: 1}]) : state.cart,
                selectedCompany: SameCompany ? item.company_id : state.selectedCompany,
                banner: SameCompany ? 0 : 1
            }
        case actionTypes.REMOVE_FROM_CART:
            return {
                ...state,
                cart: state.cart.filter(item => item.id !== action.payload.id),
                selectedCompany: (state.cart.length == 1) ? 0 : state.selectedCompany
            }
        case actionTypes.ADJUST_QTY:
            return {
                ...state,
                cart: state.cart.map((item) => item.id === action.payload.id ? {...item, qty: action.payload.qty} : item
                ),
            }
        case actionTypes.SET_ITEMS:
            return {...state, products: action.payload};  
        default:
            return state;    

    }
}

export default shopReducer;