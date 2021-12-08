import React,{Component} from "react";
import "../../stylesheets/Pop'up/Password.css"
import Cross from "../../images/svg/cross.svg"
import ReactDom from "react-dom";

class Login extends Component{

    constructor(props) {
        super(props);
    }
    
    render(){

        if(this.props.openPopup == false) return null;
        return ReactDom.createPortal(
            <div id="gray-cover">
            <div id="login-container"> 
              <input onClick={this.props.closePopup} type="image" src={Cross} id="cross-img"/>
              <span id="welcome-text6"><br/>Zmień hasło<br/></span>
              <div className="d-flex flex-row flex-row6">
              <form id="form6">    
               <span id="email-text6">Email</span> 
               <input type="email" class="form-control6" aria-describedby="emailHelp" placeholder="Wprowadz email"/>
               </form>
              </div>
             <button class="btn-primary" id="login-button6" type="submit">Wyślij</button>
             <span id="info-text">Kolejne kroki będą zawarte w <br/>otrzymanym mailu.</span>
             <span onClick={this.props.openLogin}id="back-to-login-text">Powrót na stronę logowania</span> 
            </div>
            </div>,
            document.getElementById('portal')
        )
    }
}
export default Login;