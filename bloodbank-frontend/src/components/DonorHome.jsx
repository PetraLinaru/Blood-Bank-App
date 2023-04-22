import{useContext, useState, useEffect} from 'react';
import { useLocation, useNavigate, useSearchParams,createSearchParams } from 'react-router-dom';
import axios from 'axios';
import Button from '@material-ui/core/Button';
import { StepContext } from '@mui/material';



function DonorHome(){
const [currentUser,setCurrentUser]=useState("");
const [name,setName]=useState("");
const [email,setEmail]=useState("");
const [password,setPassword]=useState("");
const [blood_type,setBloodType]=useState("");
const [uuid,setUuid]=useState("");
const [searchparams] =useSearchParams();
const useruuid=searchparams.get('uuid');

const navigate=useNavigate();


useEffect( () => {
    async function getUser (uuid){
        try
        {
            const url = 'http://localhost:8080/user/findUUID/'+uuid;
            const data = { uuid:uuid};
            const config = { 'content-type': 'application/json' };
            const res = await axios.get(url, data, config);
            const user=res.data;
           
            setCurrentUser(user);
        }
        catch(err)
        {
            alert(err);
        }
    }
   
    const uuid1=searchparams.get('uuid');
   console.log(uuid1)
    getUser(uuid1);   
    setCurrentUser(currentUser);
    setName(currentUser.name);
    setEmail(currentUser.email);
    setPassword(currentUser.password);
    setBloodType(currentUser.blood_type);
    setUuid(currentUser.uuid);

}, []);



async function deleteAccount()
{
    const url = 'http://localhost:8080/user/deleteUser/'+currentUser.email;
    const data = { email: email };
    const config = { 'content-type': 'application/json' };
    const res = await axios.post(url,data, config);

        
        alert("Account deleted!");
        navigate('/');
        

}

async function edit()
{
    

    navigate({pathname:'/editdonor' , search:createSearchParams({uuid:useruuid}).toString()});

}

    return (
        <div>
            <h1>
                
                Welcome !
                
            </h1>
            <Button variant="contained" color="primary" text="Edit" onClick={edit}>Edit Account</Button>
            <Button variant="contained" color="secondary" text="Delete" onClick={deleteAccount}>Delete Account</Button>
        </div>

    );
}

export default DonorHome;