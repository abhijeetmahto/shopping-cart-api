import "../Styles/ErrorPage.css";
import {Link} from 'react-router-dom';
const Error = () => {
  return (
    <>
      <div id="notfound">
        <div class="notfound">
          <div class="notfound-404">
            <img id="img" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwHUGTAYwGUN14kTw9IC_xKwmXNYnu3AvEIg&usqp=CAU" alt="" />
            <h1>Oops!</h1>
          </div>
          <h2>404 - Page not found</h2>
          <p>
            The page you are looking for might have been removed had its name
            changed or is temporarily unavailable.
          </p>
          <Link to='/'>Go To Homepage</Link>
        </div>
      </div>
    </>
  );
};

export default Error;
