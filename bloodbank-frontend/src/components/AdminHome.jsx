import {  useState, useEffect } from "react";
import axios from "axios";
import * as React from 'react';
import { Button } from "@material-ui/core";
import EditWindow from "./EditWindow";
import { useNavigate } from "react-router-dom";
import Register from "./Register";

 



function AdminHome() {
    
    const [doctors,setDoctors] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
    getDoctors();
    }, []);

      async function deleteDoctors  (email)  {
        const url = 'http://localhost:8080/user/deleteDoc/'+email;
        axios
            .post(url)
            .then((res) => { 
                console.log(res);
                setDoctors(doctors.filter((doctor) => doctor.email !== email));
            })
            .catch((err)=> {
                console.log(err);
            });
        };

       

      async function EditHandler(doctor)
      {
          navigate('/editwindow',{state:{oldname : doctor.name, oldemail :doctor.email, oldspecialization:doctor.specialization, uuid:doctor.uuid}})
      }

      async function RegisterDoctor()
      {
          navigate('/registerdoctor')
      }


      const getDoctors= () => {
        axios
          .get('http://localhost:8080/doctor/findAllDocs')
          .then((res) => {
            console.log(res);
            setDoctors(res.data);
          })
          .catch((err) => {
            console.log(err);
          });
      };
    return (
    <div>
    <h1>Admin Home</h1>
    <p>Admin Home page</p>
    <div className="doctor-container">
        <table className="table table-striped table-bordered">
        {
            
            doctors && doctors.map((doctor) => (
                <div className="doctor-card" key={doctor.id}>
                    <h2>{doctor.name}</h2>
                    <p>{doctor.email}</p>
                    <p>{doctor.specialization}</p>
                    <Button variant="contained"  color="primary" onClick={()=>deleteDoctors(doctor.email)}>Delete</Button>
                    <Button variant="contained" color="primary" onClick={()=>EditHandler(doctor)}>Update</Button>
                </div>
            ))
        }
        </table>
    </div>
    <Button variant="contained" color="primary" onClick={RegisterDoctor}>Add Doctor</Button>
    </div>
    );
}
    export default AdminHome;
