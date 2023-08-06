import {Link} from 'react-router-dom';
import '../Styles/Navbar.css';
import '../Styles/MerchantNavbar.css';
import { useState } from 'react';

const MerchantNavbar = () => {
    let[sub,setSub]=useState(false);
    return( 
            <div className="navbar">
                <div className="nav">
                    <div className="logo">
                    <h6>360 <sup>Shopping</sup></h6>
                    <img src="https://media.istockphoto.com/id/1184670036/vector/shopping-cart-line-icon-fast-buy-vector-logo.jpg?s=612x612&w=0&k=20&c=zyExmQoKgH4UZTwMa41Zo9x1TzQYcQy_5zQcHaEL0SQ=" alt="No Internet" />
                    
                    </div>
                    <div className="options">
                        <div className="wishlist">
                            <Link to="/products"><h3>Products</h3></Link>
                            <Link to="/merchanthome/additems"><h3>AddItems</h3></Link>
                        </div>
                        <div className="search">
                            <input type="text" placeholder='Search for Products,Brands and More'/>
                            <button>Search</button>
                        </div>
                        <div onClick={()=>{setSub(!sub)}} className="profile">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMI6LMRvk8ksEv3aF7-_UUDAHPIhpmiVEp4Q&usqp=CAU" alt="No Internet" />
                            {sub &&  <div className="sub1">
                                <Link to='' id='l1'>Edit Profile</Link>
                                <Link to='' id='l2'>Check Order</Link>
                                <Link to='' id='l3'>Update Address</Link>
                                <Link to='' id='l4'>Logout</Link>
                             </div>}
                        </div>
                    </div>
                    {/* <div className="hambarger">
    
                    </div> */}
                </div>
            </div>
        );
}
 
export default MerchantNavbar;