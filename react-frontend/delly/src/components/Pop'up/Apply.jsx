import React,{Component} from "react";
import ReactDom from "react-dom";
import "../../stylesheets/Pop'up/Apply.css"
import Cross from "../../images/svg/cross.svg"
import reactDom from "react-dom";

class Apply extends Component{

    constructor(props) {
        super(props);
    }
    
    render(){

        if(this.props.openPopup == false) return null;
        return ReactDom.createPortal(
            <div id="gray-cover">
            <div id="login-container-2"> 
              <input onClick={this.props.closeApply} type="image" src={Cross} id="cross-img-2"/>
              <span id="welcome-text3"><br/>Aplikuj na stanowisko!<br/></span>
              <span id="welcome-text4">Uzupełnij dane i wyślisz formularz. <br/>Odezwiemy się!</span>
              <div className="d-flex flex-row flex-row2">
              <form id="form2"> 
               <span id="email-text-2">Typ zgłoszenia</span>
                  <select class="form-control2" id="select-menu">
                   <option>Kurier</option>
                   <option>Pracownik</option>
                   <option>Firma Lojalnościowa</option>
                </select>
                </form>
             </div>
              <div className="d-flex flex-row flex-row2">
              <form id="form2">    
               <span id="email-text-2">Imię i nazwisko</span> 
               <input type="email" className="form-control2" aria-describedby="emailHelp" placeholder="Wprowadz imię i nazwisko"/>
               </form>
              </div>
             <div className="d-flex flex-row flex-row2">
               <form id="form2">   
               <span id="email-text-2">Numer telefonu</span> 
               <input type="email" className="form-control2" aria-describedby="emailHelp" placeholder="Wprowadz numer telefonu"/>
               </form>
             </div>
             <button className="btn btn-primary" id="login-button-2" type="submit">Wyślij</button>
            </div>
            </div>,
            document.getElementById('portal')
        )
    }
}
export default Apply;