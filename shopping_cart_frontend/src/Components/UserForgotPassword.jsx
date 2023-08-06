import { useState } from "react";
import axios from 'axios';
//Bootstrap
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const UserForgotPassword = () => {
    let[email,setEmail]= useState("");
    let handleClick = ()=>{
      axios.post(`http://localhost:8080/user/verify`)
      .then(()=>{
        alert('OTP has been sent to your ',email);
      })
      .catch(()=>{
        alert('Please enter valid email');
      })
    }
    return (  
        <>
          <div className="merchantforgot">
          <Form>
          <FloatingLabel label="Email address" className="mb-3">
            <Form.Control type="email" placeholder="name@example.com" value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
          </FloatingLabel>
          <Button variant="outline-success" onClick={handleClick}>
            Register
          </Button>{" "}
          </Form>
          </div>
        </>
    );
}
 
export default UserForgotPassword;