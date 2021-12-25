import React, {useState} from "react";
import "../../../stylesheets/client/restaurant/RestaurantChoice.scss";
import Cross from "../../../images/svg/cross.svg";
import KebabBanner from "../../../images/client/kebab.png"
import PizzaBanner from "../../../images/client/pizza.png"
import MakarunBanner from "../../../images/client/spageti.png"
import McDonaldBanner from "../../../images/client/mcdonald.png"
import Zahir from "../../../components/client/restaurant/restaurants/ZahirKebab.jsx"
import Makarun from "../../../components/client/restaurant/restaurants/Makarun.jsx"
import PizzaHut from "../../../components/client/restaurant/restaurants/PizzaHut.jsx"
import { motion, AnimatePresence } from "framer-motion";

function RestaurantChoice(props) {

  const [kebabPopup, setKebabPopup] = useState(false);
  const [PizzaHutPopup, setPizzaPopup] = useState(false);
  const [MakarunPopup, setMakarunPopup] = useState(false);

  const backdrop = {
      hidden: {
        opacity: 0
      },
      visible: {
        opacity: 1
      }
  }

  const modal = {
    hidden: {
      y: "-100vh",
      opacity: 0
    },
    visible: {
      y: "50vh",
      x: '0px',
      opacity: 1,
      transition: {delay: 0.1}
    }
  }

 
  return(

    <AnimatePresence exitBeforeEnter>
      {props.openRestaurant && (
    <motion.div variants={backdrop} className = "gray-cover" initial="hidden" animate="visible">
    <motion.div variants={modal} initial="hidden" animate="visible">
      <div className="restaurant-choice-block">
        <input onClick={props.close} type="image" src={Cross} className="restaurant-choice-block__cross"/>    
        <div className="container restaurant-choice-block__restaurants-container">
          <div onClick = { () => setKebabPopup(true)} className="row container restaurant-choice-block__restaurants-container__row">
              <img src={KebabBanner} alt="kebab" className="restaurant-choice-block__restaurants-container__row__banner 
              restaurant-choice-block__restaurants-container__row__banner--bright"></img>
          </div>
          <div onClick = { () => setPizzaPopup(true)} className="row container restaurant-choice-block__restaurants-container__row">
              <img  src={PizzaBanner} alt="kebab" className="restaurant-choice-block__restaurants-container__row__banner 
              restaurant-choice-block__restaurants-container__row__banner--bright"></img>
          </div>
          <div onClick = { () => setMakarunPopup(true)} className="row container restaurant-choice-block__restaurants-container__row">
              <img src={MakarunBanner} alt="kebab" className="restaurant-choice-block__restaurants-container__row__banner
              restaurant-choice-block__restaurants-container__row__banner--bright"></img>
          </div>
          <div className="row container restaurant-choice-block__restaurants-container__row">
              <img src={McDonaldBanner} alt="kebab" className="restaurant-choice-block__restaurants-container__row__banner 
              restaurant-choice-block__restaurants-container__row__banner--mcdonald"></img>
          </div>
      </div>
      <Zahir openKebab = {kebabPopup} close = { () => setKebabPopup(false)}/>
      <PizzaHut openPizza = {PizzaHutPopup} close = { () => setPizzaPopup(false)}/>
      <Makarun openMakarun = {MakarunPopup} close = { () => setMakarunPopup(false)}/>
    </div>
    </motion.div>
    </motion.div>
     )}
    </AnimatePresence> 
    
  );
}
export default RestaurantChoice;
