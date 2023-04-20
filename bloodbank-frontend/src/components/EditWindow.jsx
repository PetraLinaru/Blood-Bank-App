import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios';
import { Button, TextField} from '@material-ui/core';


function EditWindow()
{
    const location=useLocation();
    const oldname=location.state.oldname;
    const oldemail=location.state.oldemail;
    const oldspecialization=location.state.oldspecialization;
    const uuid=location.state.uuid;
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [specialization, setSpecialization] = useState("");

    async function save(event) {
        event.preventDefault();
        try {
            const instance = axios.create();
        
            await instance.post('http://localhost:8080/doctor/updateDoctor',
                {
                    uuid:uuid,
                    name: name,
                    email: email,
                    specialization: specialization
                },
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });


            alert("You have edited the doctor successfully!");
        }
        catch (error) {
            alert(error);
        }
    }
    

    return(
        <div>
            <h1>Edit Window</h1>
            <p>Edit Window page</p>
            <label>Name</label>
            <input type="text" id="name" name="name" placeholder={oldname} value={name} onChange={(event) => {
                setName(event.target.value);
                }}/>
            <label>Email</label>
            <input type="text" id="email" name="email" placeholder={oldemail} value={email} onChange={(event) => {
                setEmail(event.target.value);
                }}/>
            <label>Specialization</label>
            <input type="text" id="specialization" name="specialization" placeholder={oldspecialization}  value={specialization} onChange={(event) => {
                setSpecialization(event.target.value);
                }}/>
            <button type="submit" class="btn btn-primary" onClick={save} >Save</button>

        </div>

    );
} ;

export default EditWindow;
