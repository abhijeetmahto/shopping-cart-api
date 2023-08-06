import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import LandingPage from './Components/LandingPage';
import UserLoginPage from './Components/UserLoginPage';
import MerchantsLoginPage from './Components/MerchantsLoginPage';
import MerchantHomePage from './Components/MerchantHomePage';
import MerchantSignUpPage from './Components/MerchantSignUpPage';
import UserHomePage from './Components/UserHomePage';
import UserSignUpPage from './Components/UserSignUpPage';
import Error from './Components/Error';
import MerchantForgotPassword from './Components/MerchantForgotPassword';
import UserForgotPassword from './Components/UserForgotPassword';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
      {/* <LandingPage/> */}
      <Routes>
        <Route path='/' element={<LandingPage/>}/>
        <Route path='/userlogin' element={<UserLoginPage/>}/>
        <Route path ='/userhome/*' element={<UserHomePage/>}/>
        <Route path='/usersignup' element={<UserSignUpPage/>}/>
        <Route path='/merchantslogin' element={<MerchantsLoginPage/>}/>
        <Route path ='/merchanthome/*' element={<MerchantHomePage/>}/>
        <Route path='/merchantsignup' element={<MerchantSignUpPage/>}/>
        <Route path='/resetmerchantpwd' element={<MerchantForgotPassword/>}/>
        <Route path='/resetuserpwd' element={<UserForgotPassword/>}/>
        <Route path='*' element={<Error/>}/>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
