import React,{Component} from "react";
import "../../stylesheets/Pop'up/Registration.css"
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
              <span id="welcome-text5"><br/>Załóż darmowe konto<br/></span>
              <div className="d-flex flex-row flex-row3">
              <form id="form3">    
               <span id="email-text3">Imie i nazwisko</span> 
               <input type="email" class="form-control3" aria-describedby="emailHelp" placeholder="Wprowadz imie i nazwisko"/>
               </form>
              </div>
             <div className="d-flex flex-row flex-row3">
               <form id="form3">   
               <span id="email-text3">Email</span> 
               <input type="email" class="form-control3" aria-describedby="emailHelp" placeholder="Wprowadz email"/>
               </form>
             </div>
             <div className="d-flex flex-row flex-row3">
               <form id="form3">   
               <span id="email-text3">Hasło</span> 
               <input type="email" class="form-control3" aria-describedby="emailHelp" placeholder="Wprowadz hasło"/>
               </form>
             </div>
             <div className="d-flex flex-row flex-row3">
               <form id="form3">   
               <span id="email-text3">Powtorz hasło</span> 
               <input type="email" class="form-control3" aria-describedby="emailHelp" placeholder="powtórz hasło"/>
               </form>
             </div>
             <button class="btn btn-primary" id="login-button3" type="submit">Zarejestruj się</button>
             <span id="regulations">Poprzez rejestrację zgadzasz się z <span>warunkami<br/> świadczenia usług i polityką prywatności</span></span>
             <span onClick={this.props.openLogin} id="login-text">Masz już konto? <span>Zaloguj się</span>.</span>
            </div>
            </div>,
            document.getElementById('portal')
        )
    }
}
export default Login;