import '../../stylesheets/map/test.css'
import React,{Component} from "react";

class test extends Component{

    render(){
        return(
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
                       <input type="text" class="form-control" id="from" placeholder="Origin"/>
                     </div>
                    
                     <label for="to" class="col-xs-2-control-label">
                      <i class="fas fa-map-marked-alt icon"></i>
                     </label>
                     <div class="col-xs-4">
                       <input type="text" class="form-control" id="to" placeholder="Desination"/>
                     </div>
                </div>
              </form>
              <div class="col-xs-offset-2 col-xs-10">
                  
              </div>
            </div>
            <div class="contrainter-fluif">
              <div id="map">
              </div>

              <div id="output"></div>
              </div>
            </div>
        )
    }
} export default test;