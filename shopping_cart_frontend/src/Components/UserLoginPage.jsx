import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import '../Styles/UserLoginPage.css';

//BootStrap
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const UserLoginPage = () => {
  let [username, setUsername] = useState("");
  let [pwd, setPwd] = useState("");
  let nav = useNavigate();
  let formHandle = () => {
    if (username == "abhi" && pwd == 1234) {
      nav("/userhome");
    } else {
      alert("Entered Data is incorrect");
    }
  };
  return (
    <div id="main-box">
      <div className="userloginpage">
        {/* <form action="">
                UserName: <input type="text" onChange={(d)=>{setUsername(d.target.value)}} value={username} placeholder="Enter your valid username"/>
                Password: <input type="password" onChange={(d)=>{setPwd(d.target.value)}} value={pwd} placeholder="Enter your valid password"/>
                <button onClick={formHandle}>SignIn</button>
                <Link to="/usersignup"><button>SignUp</button></Link>
                <Link to="/resetpwd">Forgot Password?</Link>
                
            </form> */}

        <div className="userloginpage">
          <form action="" className="form-main">
            <img
              src="https://static-00.iconduck.com/assets.00/user-login-icon-487x512-xx4t1c61.png"
              alt="error"
            />
            <FloatingLabel label="Username" className="mb-3">
              <Form.Control
                type="text"
                placeholder="name@example.com"
                onChange={(d)=>{setUsername(d.target.value)}} value={username}
              />
            </FloatingLabel>
            <FloatingLabel label="Password" className="mb-3">
              <Form.Control
                type="password"
                placeholder="Password"
                onChange={(d)=>{setPwd(d.target.value)}} value={pwd}
              />
            </FloatingLabel>
            <Button variant="outline-warning" onClick={formHandle}>
              SignIn
            </Button>{" "}
            <Link to="/usersignup">
              <Button variant="outline-secondary">Signup</Button>{" "}
            </Link>
            <br />
            <Link to="/resetuserpwd">Forgot Password?</Link>
          </form>
        </div>
      </div>
    </div>
  );
};

export default UserLoginPage;
