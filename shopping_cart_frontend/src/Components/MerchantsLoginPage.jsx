import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import '../Styles/MerchantLoginPage.css';
import axios from "axios";
//BootStrap
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const MerchantsLoginPage = () => {
  let [email, setEmail] = useState("");
  let [password, setPassword] = useState("");
  let nav = useNavigate();
  let formHandle = (e) => {
    // if (username == "abhi" && pwd == 1234) {
    //   nav("/merchanthome");
    // } else {
    //   alert("Entered Data is incorrect");
    // }
    // axios.post(`http://localhost:3000/merchant/email=${username}&password=${pwd}`)
    // .then(()=>{nav('/merchanthome')})
    // .catch(()=>{alert("Inavlid User name")});
    e.preventDefault();
    axios.post(`http://localhost:8080/savemerchant/verify?email=${email}&password=${password}`)
    .then((res)=>{
      console.log(res.data.body);
      console.log(res.data.message);

      let vemail = res.data.body.email;
      let vpassword = res.data.body.password;
      let vid = res.data.body.id;
      if(vemail == email && vpassword == password){
        localStorage.setItem("merchant",JSON.stringify(res.data.body));
        nav(`/merchanthome/${vid}`);  
      }else{
        alert("Invalid User Name");
      }
      
      
  })
    // .catch(()=>{alert("Inavlid User name")});
  };
  return (
    <div id="main-box">
      {/* <div className="merchantloginpage">
            <form action="">
                UserName: <input type="text" onChange={(d)=>{setUsername(d.target.value)}} value={username} placeholder="Enter your valid username"/>
                Password: <input type="password" onChange={(d)=>{setPwd(d.target.value)}} value={pwd} placeholder="Enter your valid password"/>
                <button onClick={formHandle}>SignIn</button>
                <Link to="/merchantsignup"><button>SignUp</button></Link>
                <Link to="/resetpwd">Forgot Password?</Link>
                
            </form>
            </div> */}
      <div className="merchantloginpage">
        <form action="" className="form-main">
        <img src="https://cdn-icons-png.flaticon.com/512/4633/4633114.png" alt="error" />
        <FloatingLabel label="Email" className="mb-3">
        <Form.Control type="text" placeholder="name@example.com" value={email} onChange={(d)=>{setEmail(d.target.value)}} />
      </FloatingLabel>
      <FloatingLabel  label="Password" className="mb-3">
        <Form.Control type="password" placeholder="Password" value={password} onChange={(d)=>{setPassword(d.target.value)}} />
      </FloatingLabel>
      <Button variant="outline-warning" onClick={formHandle}>SignIn</Button>{' '}
      <Link to="/merchantsignup"><Button variant="outline-secondary">Signup</Button>{' '}</Link>
      <br/>
      <Link to="/resetmerchantpwd">Forgot Password?</Link>
        </form>
      </div>
    </div>
  );
};
export default MerchantsLoginPage;
