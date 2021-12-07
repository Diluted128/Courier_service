import React,{Component} from "react";
import "../../stylesheets/Pop'up/Login.css"
import Cross from "../../images/svg/cross.svg"

class Login extends Component{

    constructor(props) {
        super(props);
    }
    
    render(){

        if(this.props.openPopup == false) return null;
        return(
            <div id="gray-cover">
            <div id="login-container"> 
              <input onClick={this.props.closePopup} type="image" src={Cross} id="cross-img"/>
              <span id="welcome-text1"><br/>Witaj ponownie!<br/></span>
              <span id="welcome-text2">Nie masz konta? <span id="registration-text">Zarejestruj sie</span>.</span>
              <div className="d-flex flex-row flex-row1">
              <form id="form1">    
               <span id="email-text">Email</span> 
               <input type="email" class="form-control" aria-describedby="emailHelp" placeholder="Wprowadz email"/>
               </form>
              </div>
             <div className="d-flex flex-row flex-row1">
               <form id="form1">   
               <span id="email-text">Hasło</span> 
               <input type="email" class="form-control" aria-describedby="emailHelp" placeholder="Wprowadz hasło"/>
               <span id="password-recover-text">Przywróc hasło</span> 
               </form>
             </div>
             <button class="btn btn-primary" id="login-button" type="submit">Zaloguj się</button>
            </div>
            </div>
        )
    }
}
export default Login;