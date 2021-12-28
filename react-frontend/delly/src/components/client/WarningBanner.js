import WarningBannerPNG from "../../images/WarningBanner.png"
const WarningBanner = (props) => {

    if(props.openWarningBanner == false) return null;
    return(
        <img src={WarningBannerPNG} className="warning-banner" alt="warning-banner"></img>
    )
} 
export default WarningBanner;