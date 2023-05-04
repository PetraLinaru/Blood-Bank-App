import { useNavigate } from 'react-router-dom';
import * as mui from '@material-ui/core';
import Button from '@material-ui/core/Button';
function Home() {

    const navigate = useNavigate();
    const goToLogin = () => navigate('/login');
    const goToRegister = () => navigate('/register');
    return (
      <div>
      
      <div class="container">
            <div class="row">
                <h2>Home</h2>
             <hr/>
              </div>
              </div>
              <form>
         <Button variant="contained" color="primary" text="Login" onClick={goToLogin}>Login</Button>
         &nbsp;&nbsp;&nbsp;
         <Button variant="contained" color="primary" text="Register" onClick={goToRegister}>Register</Button>
        </form>
      </div>
    );
  }
   
  export default Home;