import '../../stylesheets/map/test.css'
import React,{Component, useState} from "react";
class test extends Component{

    constructor(props){
      super(props)
    
      this.state = {
        curierAddress:  "",
        parcelAddress: "",
        clientAddress: "",
        distance: 0
      }
    }

    render(){
        return(
          <>
            <div class="jumbotron">
            <div class="containter-fluid">
              <h1>Calculate Route For Courier</h1>
              <p>This App Will Help in Calculating Travelling Route For Delivery Man</p>
              <form class="form-horizontal">
                <div class="form-group">
  
                     <label for="from" class="col-xs-2-control-label">
                     <i class="fas fa-truck"></i>                 
                    </label>
                     <div class="col-xs-4">
                       <input type="text" onChange={event => this.state.curierAddress= event.target.value}class="form-control" id="from"/>
                     </div>
                    
                     <label for="to" class="col-xs-2-control-label">
                      <i class="fas fa-map-marked-alt icon"></i>
                     </label>
                     <div class="col-xs-4">
                       <input type="text" onChange={event => this.state.parcelAddress = event.target.value} class="form-control" id="to"/>
                     </div>

                     <label for="to" class="col-xs-2-control-label">
                      <i class="fas fa-map-marker-alt icon"></i>   
                     </label>
                     <div class="col-xs-4">
                       <input type="text" onChange={event => this.state.clientAddress = event.target.value} class="form-control" id="curier"/>
                     </div>
                    <p>distance: {this.props.dist}</p>
                    <p>duration: {this.props.duration} minutes</p>

                </div>
              </form>
            </div>
            </div>  
            <button onClick={async () => await this.props.drawRoute(this.state.curierAddress, this.state.parcelAddress, this.state.clientAddress)}>draw</button>
            </>
        )
    }
} export default test;