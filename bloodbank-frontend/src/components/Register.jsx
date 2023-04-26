import { useState } from "react";
import axios from "axios";	
import TextField from '@material-ui/core/TextField';
import { Autocomplete } from "@mui/material";
import React from 'react'
import ReactDOM from 'react-dom'

function Register(){
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [role, setRole] = useState("");
    const [blood_type, setBloodType] = useState('blood_type');
    const options =["A", "B", "AB", "O"];

    async function save(event){
    event.preventDefault();
        try {
            const instance=axios.create();
            await  instance.post('http://localhost:8080/donor/register',
             {name : name,
            password :password,
            email :email,
            role :"DONOR",
            blood_type:blood_type},
            {headers: {
                'Content-Type': 'application/json'
                }});
        
        alert ("You have been registered successfully!");
        }
        catch (error) {
           alert(error);
        }
    }
    return (
        <div>
            <div class ="container mt-4">
                <div class ="card">
                <h1>Welcome to the BloodBank</h1>
                <h2>Register now!</h2>
                <form>
                    <div class="form-group">
                        <label> Your name </label>
                        <input type="text" class="form-control" id =  "name" placeholder="Enter your name"
                            value={name}
                            onChange={(e) => setName(e.target.value)}/>
                    </div>

                    <div class="form-group">
                        <label> Your email </label>
                        <input type="email" class="form-control" id =  "email" placeholder="Enter your email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}/>
                    </div>

                    <div class="form-group">
                        <label> Your password </label>
                        <input type="password" class="form-control" id =  "password" placeholder="Enter your password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}/>
                    </div>
                    <div class="form-group">
                        <label> Your blood type </label>
                        <Autocomplete
                        value={blood_type}
                        onChange={(event, blood_type) => {
                          setBloodType(blood_type)
                        }}
                            disablePortal
                        id="combo-box-demo"
                        options={options}

                        sx={{ width: 300 }}
                        renderInput={(params) => <TextField {...params} label="Your Blood Type" />}
                       
                        />
                    </div>
                    <button type="submit" class="btn btn-primary" onClick={save}>save</button>
                </form>
                </div>
            </div>	
        </div>
    );

}
export default Register;