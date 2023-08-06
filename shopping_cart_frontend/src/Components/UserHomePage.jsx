import { Routes,Route } from "react-router-dom";
import Navbar from "./Navbar";
import UserDashBoard from "./UserDashBoard";
import '../Styles/UserHomePage.css';

// import Button from 'react-bootstrap/Button';
// import Container from 'react-bootstrap/Container';
// import Form from 'react-bootstrap/Form';
// import Nav from 'react-bootstrap/Nav';
// import Navbar from 'react-bootstrap/Navbar';
// import NavDropdown from 'react-bootstrap/NavDropdown';

function UserHomePage() {
  return (
    // <Navbar expand="lg" className="bg-body-tertiary">
    //   <Container fluid>
    //     <Navbar.Brand href="#">ZiP CarT</Navbar.Brand>
    //     <Navbar.Toggle aria-controls="navbarScroll" />
    //     <Navbar.Collapse id="navbarScroll">
    //       <Nav
    //         className="me-auto my-2 my-lg-0"
    //         style={{ maxHeight: '100px' }}
    //         navbarScroll
    //       >
    //         <Nav.Link href="#action1">Home</Nav.Link>
    //         <Nav.Link href="#action2">WishList</Nav.Link>
    //         <NavDropdown title="Profile" id="navbarScrollingDropdown">
    //           <NavDropdown.Item href="#action3">Profile</NavDropdown.Item>
    //           <NavDropdown.Item href="#action4">
    //             Manage Profle
    //           </NavDropdown.Item>
    //           <NavDropdown.Divider />
    //           <NavDropdown.Item href="#action5">
    //             Settings
    //           </NavDropdown.Item>
    //         </NavDropdown>
    //       </Nav>
    //       {/* <Form className="d-flex">
    //         <Form.Control
    //           type="search"
    //           placeholder="Search"
    //           className="me-2"
    //           aria-label="Search"
    //         />
    //         <Button variant="outline-success">Search</Button>
    //       </Form> */}
    //       <div className='d-flex'>
    //         <input type="text" name="" id="" />
    //         <Button variant="outline-success">Search</Button>
    //       </div>
    //     </Navbar.Collapse>
    //   </Container>
    // </Navbar>
    <div className="userhome">
            <Navbar/>
            <Routes>
                <Route path="/" element={<UserDashBoard/>}/>
            </Routes>

        </div>
  );
}

export default UserHomePage;