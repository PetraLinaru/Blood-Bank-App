import { useNavigate } from 'react-router-dom';
import * as mui from '@material-ui/core';
import Button from '@material-ui/core/Button';
function Home() {

    const navigate = useNavigate();
    const goToLogin = () => navigate('/login');
    const goToRegister = () => navigate('/register');
    return (
      <div>
   
       <h1>Home</h1>
         <p>Home page</p>
         <Button variant="contained" color="primary" text="Login" onClick={goToLogin}>Login</Button>
         <Button variant="contained" color="primary" text="Register" onClick={goToRegister}>Register</Button>
        
      </div>
    );
  }
   
  export default Home;