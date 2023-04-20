import{useContext, useState, useEffect} from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import Button from '@material-ui/core/Button';
import { StepContext } from '@mui/material';



function DonorHome(){
const [currentUser,setCurrentUser]=useState("");
const [name,setName]=useState("");
const [email,setEmail]=useState("");
const [password,setPassword]=useState("");
const [blood_type,setBloodType]=useState("");
const location=useLocation();
const navigate=useNavigate();
const uuid=location.state.uuid;



async function deleteAccount(email)
{
    const url = `http://localhost:8080/donor/deleteDonor/email=${email}}`;
    const data = { email: email };
    const config = { 'content-type': 'application/json' };
    const res = await axios.post(url, config);

        
        alert("Account deleted!");
        navigate('/');
        

}

async function edit()
{

}
async function getCurrentUser()
{   
     
        try {
        const url = 'http://localhost:8080/donor/getByUUID';
	    const data = { uuid: uuid };
	    const config = { 'content-type': 'application/json' };
        const res = await axios.get(url, data, config);
        const currentUser=res.data;
        console.log(currentUser.email);
        setCurrentUser(currentUser);
        }
        catch(err)
        {
            alert(err);
        }
}
    return (
        <div>
            <h1>
                
                Welcome !
                
            </h1>
            <Button variant="contained" color="primary" text="Edit" onClick={edit}>Edit Account</Button>
            <Button variant="contained" color="secondary" text="Delete" onClick={()=>deleteAccount(currentUser.email)}>Delete Account</Button>
        </div>

    );
}

export default DonorHome;