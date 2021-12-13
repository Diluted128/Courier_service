import React,{Component} from "react";
import "../../stylesheets/Pop'up/Registration.scss"
import Cross from "../../images/svg/cross.svg"
import ReactDom from "react-dom";

class Login extends Component{
  
    render(){

        if(this.props.openPopup == false) return null;
        return ReactDom.createPortal(
          <div className="gray-cover">
            <div className="gray-cover__registration-block"> 
              <input onClick={this.props.closePopup} type="image" src={Cross} className="gray-cover__registration-block__cross-img"/>
              <span className="gray-cover__registration-block__title"><br/>Załóż darmowe konto<br/></span>
              <div className="d-flex flex-row gray-cover__registration-block__flex-row">
              <form className="gray-cover__registration-block__flex-row__form">    
               <span className="gray-cover__registration-block__flex-row__form__title">Imie i nazwisko</span> 
               <input type="email" class="gray-cover__registration-block__flex-row__form__input" aria-describedby="emailHelp" placeholder="Wprowadz imie i nazwisko"/>
               </form>
              </div>
             <div className="d-flex flex-row gray-cover__registration-block__flex-row">
               <form className="gray-cover__registration-block__flex-row__form">   
               <span className="gray-cover__registration-block__flex-row__form__title">Email</span> 
               <input type="email" class="gray-cover__registration-block__flex-row__form__input" aria-describedby="emailHelp" placeholder="Wprowadz email"/>
               </form>
             </div>
             <div className="d-flex flex-row gray-cover__registration-block__flex-row">
               <form className="gray-cover__registration-block__flex-row__form">   
               <span className="gray-cover__registration-block__flex-row__form__title">Hasło</span> 
               <input type="email" class="gray-cover__registration-block__flex-row__form__input" aria-describedby="emailHelp" placeholder="Wprowadz hasło"/>
               </form>
             </div>
             <div className="d-flex flex-row gray-cover__registration-block__flex-row">
               <form className="gray-cover__registration-block__flex-row__form">   
               <span className="gray-cover__registration-block__flex-row__form__title">Powtorz hasło</span> 
               <input type="email" class="gray-cover__registration-block__flex-row__form__input" aria-describedby="emailHelp" placeholder="powtórz hasło"/>
               </form>
             </div>
             <button class="btn btn-primary" className="gray-cover__registration-block__registration-button" type="submit">Zarejestruj się</button>
             <span className="gray-cover__registration-block__regulations">Poprzez rejestrację zgadzasz się z <span>warunkami<br/> świadczenia usług i polityką prywatności</span></span>
             <span onClick={this.props.openLogin} className="gray-cover__registration-block__login-text">Masz już konto? <span>Zaloguj się</span>.</span>
             </div>
            </div>,
            document.getElementById('portal')
        )
    }
}
export default Login;