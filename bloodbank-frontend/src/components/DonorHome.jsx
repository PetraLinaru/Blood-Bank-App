import{useContext, useState, useEffect} from 'react';
import { useLocation, useNavigate, useSearchParams,createSearchParams } from 'react-router-dom';
import axios from 'axios';
import Button from '@material-ui/core/Button';
import { StepContext } from '@mui/material';



function DonorHome(){
const [currentUser,setCurrentUser]=useState("");
const [locations,setLocations]=useState([]);
const [name,setName]=useState("");
const [email,setEmail]=useState("");
const [password,setPassword]=useState("");
const [blood_type,setBloodType]=useState("");
const [uuid,setUuid]=useState("");
const [searchparams] =useSearchParams();
const useruuid=searchparams.get('uuid');

const navigate=useNavigate();
let index=1;


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

    async function getLocations()
    {
        try
        {
            const url = 'http://localhost:8080/location/all';
            const data = { };
            const config = { 'content-type': 'application/json' };
            const res = await axios.get(url, data, config);
            const locations=res.data;
            setLocations(locations);
            console.log(locations);
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

    getLocations();

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

            <h2>
                All our locations:
            </h2>

            <table>
                <tr>
                    <th>Location ID</th>
                    <th>Location Name</th>
                    <th>City</th>
                    <th>Region</th>

                </tr>
                { 
                    locations && locations.map((location) => (
                        
                        <tr>
                            <td>{index++} </td>
                            <td>{location.location_name}</td>
                            <td>{location.city}</td>
                            <td>{location.region}</td>
                            
                        </tr>
                        
                    ))
                }
            </table>

            <h1>Wanna make an appointment?</h1>
            <Button variant="contained" color="primary" text="Make an appointment" onClick={()=>navigate({pathname:'/createappointment', search:createSearchParams({uuid:useruuid}).toString()})}>Make an appointment</Button>


        </div>  

    );
}

export default DonorHome;