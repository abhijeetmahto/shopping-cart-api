import { Route, Routes } from "react-router-dom";

import MerchantDashBoard from "./MerchantDashBoard";
import MerchantNavbar from "./MerchantNavbar";
import AddItems from "./AddItems";

const MerchantHomePage = () => {
    
    return (  
        <div className="merchanthomepage">
            <MerchantNavbar/>
            <Routes>
                <Route path="/" element={<MerchantDashBoard/>}/>
                <Route path="/additems" element={<AddItems/>}/>
            </Routes>
        </div>
    );
}
 
export default MerchantHomePage;
