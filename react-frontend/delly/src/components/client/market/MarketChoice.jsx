import React, { Component, useState } from "react";
import "../../../stylesheets/client/market/MarketChoice.scss";
import Cross from "../../../images/svg/cross.svg";
import ReactDom from "react-dom";
import { useNavigate } from "react-router-dom";
import MarketBanner from "../../../images/client/biedronka.png";
import { motion, AnimatePresence } from "framer-motion";
import Markets from "./markets/Markets.jsx"

function MarketChoice(props) {

  const [openMarket, setMarket] = useState(false);

  const backdrop = {
    hidden: {
      opacity: 0,
    },
    visible: {
      opacity: 1,
    },
  };

  const modal = {
    hidden: {
      y: "-100vh",
      opacity: 0,
    },
    visible: {
      y: "50vh",
      x: "0px",
      opacity: 1,
      transition: { delay: 0.1 },
    },
  };

  return (
    <AnimatePresence exitBeforeEnter>
      {props.openMarket && (
        <motion.div
          variants={backdrop}
          className="gray-cover"
          initial="hidden"
          animate="visible"
        >
          <motion.div variants={modal} initial="hidden" animate="visible">
              <div className="market-choice-block">
                <input
                  onClick={props.close}
                  type="image"
                  src={Cross}
                  className="market-choice-block__cross"
                />
                <img
                  onClick={() => {setMarket(true)}}
                  src={MarketBanner}
                  alt="kebab"
                  class="market-choice-block__banner"
                ></img>
                <Markets openMarket = {openMarket} close = {() => setMarket(false)}/>
              </div>
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  );
}
export default MarketChoice;
