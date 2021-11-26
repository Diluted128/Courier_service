import '../../stylesheets/map/test.css'
import React,{Component} from "react";
class test extends Component{

    constructor(props){
      super(props)
      this.state = {
        from: "",
        to: ""
      }
      this.sOnClickk = this.OnClickk.bind(this);

    }

    OnClickk = function(){
    
      console.log("dziala")
        // console.log("from: " + this.state.from + " to:" + this.state.to)
    }

    render(){
        return(
          <>
            <div class="jumbotron">
            <div class="containter-fluid">
              <h1>Find the Distance Betweeen Two Places</h1>
              <p>This App Will Help in Calculating Your Travelling Distance</p>
              <form class="form-horizontal">
                <div class="form-group">
  
                     <label for="from" class="col-xs-2-control-label">
                      <i class="fas fa-map-marker-alt icon"></i>                  
                    </label>
                     <div class="col-xs-4">
                       <input type="text" onChange={event => this.state.from = event.target.value}class="form-control" id="from"/>
                     </div>
                    
                     <label for="to" class="col-xs-2-control-label">
                      <i class="fas fa-map-marked-alt icon"></i>
                     </label>
                     <div class="col-xs-4">
                       <input type="text" onChange={event => this.state.to = event.target.value} class="form-control" id="to"/>
                     </div>
                </div>
              </form>
            </div>
            </div>  
            <button onClick={async () => await this.props.drawRoute(this.state.from, this.state.to)}>draw</button>
            </>
        )
    }
} export default test;