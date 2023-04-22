import {  useState, useContext } from "react";
import { useNavigate, createSearchParams } from 'react-router-dom';
import axios from "axios";
 
 
function Login() {
  
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [user, setUser] = useState("");
    const [uuid, setUuid] = useState("");
    const navigate = useNavigate();

    
 
 
    async function login(event) {
        event.preventDefault();
        try {
        const url = 'http://localhost:8080/user/login';
	      const data = { email:email, password:password };
	      const config = { 'content-type': 'application/json' };
        const res = await axios.post(url, data, config);

             console.log(res);
             const myUser=res.data;
            
             setUser(myUser);
             setUuid(myUser.uuid);
           
 
              if(myUser.role == "DONOR")
             {
                alert("ur a donor")
                navigate({pathname:'/donorhome' , search:createSearchParams({uuid:myUser.uuid}).toString()});
                console.log(myUser.uuid);
             }
              if(myUser.role == "ADMIN")
              {
                navigate('/adminhome');
                alert("ur an admin")
              }
              if(myUser.role=="DOCTOR")
              {
                navigate('/doctorhome');
                alert("ur a doc");
             }
          }
 
        catch (err)
        {
        alert(err);
        }
      
    }
  
  
   
  
  
  
    return (
       <div>
            <div class="container">
            <div class="row">
                <h2>Login</h2>
             <hr/>
             </div>
 
             <div class="row">
             <div class="col-sm-6">
            <form>
        <div class="form-group">
          <label>Email</label>
          <input type="email"  class="form-control" id="email" placeholder="Enter Name"
          
          value={email}
          onChange={(event) => {
            setEmail(event.target.value);
          }}
          
          />
 
        </div>
 
        <div class="form-group">
            <label>password</label>
            <input type="password"  class="form-control" id="password" placeholder="Enter Fee"
            
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            
            />
          </div>
                  <button type="submit" class="btn btn-primary" onClick={login} >Login</button>
              </form>
 
            </div>
            </div>
            </div>
 
     </div>
    );
  }
  
  export default Login;