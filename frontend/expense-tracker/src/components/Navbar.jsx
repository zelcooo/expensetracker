import './Navbar.css'
import photo from "../assets/Z.png";
export default function Navbar(){

    return(
        <div className="navbar">
            <img src={photo} alt="Logo"/>
            <div className="navbar-text"> Zledger </div>
        </div>

        
    )
}
