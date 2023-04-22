import { createSearchParams, useSearchParams, useNavigate } from 'react-router-dom';
import React, { useState , useEffect} from 'react';
import axios from 'axios';

function EditDonor()
{
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
            setName(user.name);
            setEmail(user.email);
            setPassword(user.password);
            setBloodType(user.blood_type);
            setUuid(user.uuid)
        }
        catch(err)
        {
            alert(err);
        }
        
    }
   
    const uuid=searchparams.get('uuid');
    console.log(uuid);
    getUser(uuid); 
    
   

}, []);

    async function edit()
    {
        const url = 'http://localhost:8080/donor/updateDonor';
        const data = { email:email, password: password, name: name, blood_type: blood_type,  uuid: uuid };
        console.log(data);
        const config = { 'content-type': 'application/json' };
        const res = await axios.post(url, data, config);
        alert("Account edited!");
        navigate({pathname:'/donorhome' , search:createSearchParams({uuid:uuid}).toString()});
    }

    return (
        <div>
            <h1>Edit Donor</h1>
            <p>Edit Window page</p>
            <label>Name</label>
            <input type="text" id="name" name="name" placeholder={name} value={name} onChange={(event) => {
                setName(event.target.value);
                }}/>
            <label>Email</label>
            <input type="text" id="email" name="email" placeholder={email} value={email} onChange={(event) => {
                setEmail(event.target.value);
                }}/>
            <label>Password</label>
            <input type="text" id="password" name="password" placeholder={password} value={password} onChange={(event) => {
                setPassword(event.target.value);
                }}/>
            <label>Blood_Type</label>
            <input type="text" id="blood_type" name="blood_type" placeholder={blood_type}  value={blood_type} onChange={(event) => {
                setBloodType(event.target.value);
                }}/>
            <button type="submit" class="btn btn-primary" onClick={edit} >Save</button>

        </div>
    );
}
export default EditDonor;