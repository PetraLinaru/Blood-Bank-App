import { useState } from "react";
import axios from "axios";	
import TextField from '@material-ui/core/TextField';
import { Autocomplete } from "@mui/material";
import React from 'react'
import ReactDOM from 'react-dom'

function RegisterDoctor(){
    const [uuid,setUUID]=useState("");
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [role, setRole] = useState("");
    const [specialization, setSpecialization] = useState("");

    async function save(event){
    event.preventDefault();
        try {
            const instance=axios.create();
            await  instance.post('http://localhost:8080/doctor/register',
             {
            uuid: uuid,
            name : name,
            password :password,
            email :email,
            role :"DOCTOR",
            specialization:specialization},
            {headers: {
                'Content-Type': 'application/json'
                }});
        
        alert ("You have added a doctor successfully!");
        }
        catch (error) {
           alert(error);
        }
    }
    return (
        <div>
            <div class ="container mt-4">
                <div class ="card">
                <h1>Add a new doctor</h1>
                <form>
                    <div class="form-group">
                        <label> Your name </label>
                        <input type="text" class="form-control" id =  "name" placeholder="Enter doctor's name" allign="center"
                            value={name}
                            onChange={(e) => setName(e.target.value)}/>
                    </div>
                    <div class="form-group">
                        <label> Your email </label>
                        <input type="email" class="form-control" id =  "email" placeholder="Enter doctor's email" allign="center"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}/>
                    </div>

                    <div class="form-group">
                        <label> Your password </label>
                        <input type="password" class="form-control" id =  "password" placeholder="Enter doctor's password" allign="center"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}/>
                    </div>
                    <div class="form-group">
                        <label> Your specialization </label>
                        <input type="password" class="form-control" id =  "password" placeholder="Enter doctor's specialization" allign="center"
                            value={specialization}
                            onChange={(e) => setSpecialization(e.target.value)}/>
                    </div>
                    <button type="submit" class="btn btn-primary" onClick={save}>save</button>
                </form>
                </div>
            </div>	
        </div>
    );

}
export default RegisterDoctor;