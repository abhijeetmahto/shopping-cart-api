import axios from 'axios';
import '../Styles/AddItems.css';
//BootStrap
import { useState } from "react";
import Form from "react-bootstrap/Form";
import InputGroup from 'react-bootstrap/InputGroup';
import Button from 'react-bootstrap/Button';

// import { useParams } from 'react-router-dom';

const AddItems = () => {
  // let a ="one" , b = "two" , c= "three";
  // let params = useParams(`merchanthome/vid`);
  // let merchant_id = params();
  
  let [category,setCategory] = useState(""); 
  let [name,setName] = useState("");
  let [brand,setBrand] = useState("");
  let [cost,setCost] = useState("");
  // let [discount,setDiscount] = useState("");
  let [image,setImage] = useState("");
  let [rating,setRating] = useState("");
  let [description,setDescription] = useState("");
  let [noOfusers,setNoOfUsers] = useState("");
  let mid = localStorage.getItem("merchant").id;

  let formHandle = (e)=>{
    e.preventDefault();
    let merchant=JSON.parse(localStorage.getItem("merchant"))
    let data = {category,name,brand,cost,image,rating,description,noOfusers,mid};
    axios.post(`http://localhost:8080/products/${merchant.id}`,data)
    .then(()=>{
      alert("Data has been added");
      
    })
    .catch(()=>{alert("Invalid Data")})
  }

  return (
    <div className="additems">
      {/* <Form.Select aria-label="Default select example" value={category} onChange={(e)=>{setCategory(e.target.value)}}>
        <option>Open this select menu</option>
        <option>One</option>
        <option>Two</option>
        <option>Three</option>
      </Form.Select> */}
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          Category
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={category} onChange={(e)=>{setCategory(e.target.value)}}/>
      </InputGroup>
      <br />
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          Product Name
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={name} onChange={(e)=>{setName(e.target.value)}}/>
      </InputGroup>
      <br />
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          Brand
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={brand} onChange={(e)=>{setBrand(e.target.value)}}/>
      </InputGroup>
      <br />
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          MRP. Price
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={cost} onChange={(e)=>{setCost(e.target.value)}}/>
      </InputGroup>
      <br />
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          Rating Out of 5
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={rating} onChange={(e)=>{setRating(e.target.value)}}/>
      </InputGroup>
      <br />
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          Thumbnail URL
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={image} onChange={(e)=>{setImage(e.target.value)}}/>
      </InputGroup>
      <br />
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          Descriptions
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={description} onChange={(e)=>{setDescription(e.target.value)}}/>
      </InputGroup>
      <br />
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          No. of Users
        </InputGroup.Text>
        <Form.Control
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          value={noOfusers} onChange={(e)=>{setNoOfUsers(e.target.value)}}/>
      </InputGroup>
      <br />
      <Button variant="outline-info" onClick={formHandle}>Add Items</Button>{' '}
    </div>
  );
};

export default AddItems;
