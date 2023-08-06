import { Link } from "react-router-dom";
// import 'boxicons';
import "../Styles/LandingPage.css";
const LandingPage = () =>{
    return(
        <div className="landingpage">
            <div className="landing">
                <div className="user">
                    <Link to="/userlogin">
                        <img src="https://static-00.iconduck.com/assets.00/user-login-icon-487x512-xx4t1c61.png" alt="error" />
                        {/* <i class='bx bxs-user-circle bx-flashing' ></i> */}
                        <h2>User Login</h2>
                    </Link>
                </div>
                <div className="merchants">
                    <Link to="/merchantslogin">
                        <img src="https://cdn-icons-png.flaticon.com/512/4633/4633114.png" alt="error" />
                        <h2>Merchants Login</h2>
                    </Link>
                </div>
            </div>
        </div>
    );
}
export default LandingPage;