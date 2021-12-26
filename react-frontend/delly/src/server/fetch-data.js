import axios from "axios";
import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { bindActionCreators } from "redux";
import * as actionCreators from "../redux/Shopping/shopping-actions"

const ItemsListing = () => {

    const dispatch = useDispatch();

    const {setItems} = bindActionCreators(actionCreators, dispatch);

  const fetchItems = async () => {
    const response = await axios
      .get("http://localhost:8081/products")
      .catch((err) => {
        console.log("Err", err);
      });
      setItems(response.data);
  };

  useEffect(() => {
    fetchItems();
  }, []);

  return (
  <></>
  );
};

export default ItemsListing;
