import React, {useState}from "react";
import "../../../stylesheets/client/pharmacy/PharmacyChoice.scss";
import Cross from "../../../images/svg/cross.svg";
import ReactDom from "react-dom";
import PharmacyBanner from "../../../images/client/apteka.png";
import { motion, AnimatePresence } from "framer-motion";
import Pharmacy from "./pharmacies/Pharmacy.js"

function PharmacyChoice(props) {
  
  const [openPharmacy, setPharmacy] = useState(false);

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
      {props.openPharmacy && (
        <motion.div
          variants={backdrop}
          className="gray-cover"
          initial="hidden"
          animate="visible"
        >
          <motion.div variants={modal} initial="hidden" animate="visible">
              <div className="pharmacy-choice-block">
                <input
                  onClick={props.close}
                  type="image"
                  src={Cross}
                  className="pharmacy-choice-block__cross"
                />
                <img
                  onClick={() => {setPharmacy(true)}}
                  src={PharmacyBanner}
                  alt="kebab"
                  class="pharmacy-choice-block__banner"
                ></img>
              </div>
              <Pharmacy openPharmacy={openPharmacy} close = {() => setPharmacy(false)}/>
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  );
}
export default PharmacyChoice;
