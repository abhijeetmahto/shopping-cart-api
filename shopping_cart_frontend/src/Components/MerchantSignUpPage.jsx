import { useState } from "react";
import axios from "axios";


//Bootstrap
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { useNavigate } from "react-router-dom";

const MerchantSignUpPage = () => {
  let [name, setName] = useState("");
  let [phone, setPhone] = useState("");
  let [email, setEmail] = useState("");
  let [gst, setGst] = useState("");
  let [password, setPassword] = useState("");
  let nav = useNavigate();

  let data = { name, phone, email, gst, password };

  let clickHandle = (e) => {
    e.preventDefault();
     axios.post(`http://localhost:8080/savemerchant`,data)
      .then(() => {
        console.log("Data has been added");
      nav('/merchantslogin');
      })
      .catch(() => {
        console.log("Error");
      });
  };

  return (
    <div id="main-box">
      {/* <form action="">
                <label htmlFor="">Name</label><input type="text" name="" id="" value={name} onChange={(e)=>{setName(e.target.value)}}/>
                <label htmlFor="">Phone</label><input type="tel" pattern="[0-9]{10}" name="" id="" value={phone} onChange={(e)=>{setPhone(e.target.value)}}/>
                <label htmlFor="">Email</label><input type="email" name="" id="" value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
                <label htmlFor="">GSTNo.</label><input type="text" name="" id="" value={gst} onChange={(e)=>{setGst(e.target.value)}}/>
                <label htmlFor="">Password</label><input type="password" name="" id="" value={pwd} onChange={(e)=>{setPassword(e.target.value)}}/>
                <button onClick={clickHandle}>Submit</button>
            </form> */}
      <div className="merchantsignuppage">
        <form action="">
        <img src="https://cdn-icons-png.flaticon.com/512/4633/4633114.png" alt="error" />
          <FloatingLabel label="Full Name" className="mb-3">
            <Form.Control type="text" value={name} onChange={(e)=>{setName(e.target.value)}} placeholder="Enter Your Full Name"/>
          </FloatingLabel>
          <FloatingLabel label="Phone Number" className="mb-3">
            <Form.Control type="tel" pattern="[0-9]{10}" name="" id="" value={phone} onChange={(e)=>{setPhone(e.target.value)}} placeholder="Enter Your Valid Phone Number"/>
          </FloatingLabel>
          <FloatingLabel label="GST Number" className="mb-3">
            <Form.Control type="text" value={gst} onChange={(e)=>{setGst(e.target.value)}} placeholder="Enter GSTNo."/>
          </FloatingLabel>
          <FloatingLabel label="Email address" className="mb-3">
            <Form.Control type="email" placeholder="name@example.com" value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
          </FloatingLabel>
          <FloatingLabel label="Password" className="mb-3">
            <Form.Control type="password" placeholder="Password" value={password} onChange={(e)=>{setPassword(e.target.value)}}/>
          </FloatingLabel>
          <Button variant="outline-success" onClick={clickHandle}>Register</Button>{' '}
        </form>
      </div>
    </div>
  );
};

export default MerchantSignUpPage;
