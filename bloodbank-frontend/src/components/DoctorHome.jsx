import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import * as mui from '@material-ui/core';
import { Button } from '@material-ui/core';
import { useSearchParams, createSearchParams } from 'react-router-dom';
import { useState } from 'react';
import axios from 'axios';
import moment from 'moment';
import Calendar from 'react-calendar';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@material-ui/core';
import { Pagination } from '@material-ui/lab';
 

function DoctorHome(){
    const [currentUser,setCurrentUser]=useState("");
    const [searchparams]=useSearchParams();
    const [dayDateAppointments,setDayDateAppointments]=useState([]);
    const [monthDateAppointments,setMonthDateAppointments]=useState([]);
    const [yearDateAppointments,setYearDateAppointments]=useState([]);
    const [todayAppointments,setTodayAppointments]=useState([]);
    const [date,setDate]=useState(new Date());

    const [dHandler,setDHandler]=useState(false);
    const [mHandler,setMHandler]=useState(false);
    const [yHandler,setYHandler]=useState(false);
    const doc=require('./doc.jpg');
    var index=0;
    var appointmentList
    const [currentPage, setCurrentPage] = useState(1);
    const [perPage, setPerPage] = useState(10);
    const [totalPages, setTotalPages] = useState(0);
    
  

    const pageable = {
        page: 0,
        size: 10,
        sort: 'date,desc'
      };
      
      const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber);
      };

  
    useEffect(() => {

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
            const user_uuid=searchparams.get('uuid');
            getUser(user_uuid);
    }, []);
    useEffect(() => {
        console.log(date)
        checkAppointmentsOnDate(date);
    }, [date]);
    const dayHandler = () => {	
        setDHandler(true);
    }
 
    const checkAppointmentsOnDate = async (date) => {
        try{
        
          setDate(date)  
          const passeddate=moment(date).format('YYYY-MM-DD');
          const data = {  uuid:currentUser.uuid,date:passeddate,pageable:pageable};
          const url = 'http://localhost:8080/appointment/doc/day/'+currentUser.uuid+"/"+passeddate+"?page="+pageable.page+"&size="+pageable.size+"&sort="+pageable.sort;
              axios
                  .get(url,data)
                  .then((res) => { 
                      console.log(res.data);
                      setDayDateAppointments(res.data.content);
                      setTotalPages(res.data.totalPages);
                      console.log(dayDateAppointments)
                     
                  })
                  .catch((err)=> {
                      console.log(err);
                  });
  
        }
          
          catch (err){
              alert(err);
          }
      }
    
    const checkAppointmentsOnMonth = (month) => {
        try{
            const url = 'http://localhost:8080/appointment/monthdate/'+month;
            const data = { month:month};
            const config = { 'content-type': 'application/json' };
            const res =axios.get(url, data, config);
            const appointments=res.data;
            setMonthDateAppointments(appointments);
        }
        catch (err){
            alert(err);
        }
    }

    const checkAppointmentsOnYear = (year) => {
        try{
            const url = 'http://localhost:8080/appointment/yeardate/'+year;
            const data = { year:year};
            const config = { 'content-type': 'application/json' };
            const res = axios.get(url, data, config);
            const appointments=res.data;
            setYearDateAppointments(appointments);
        }
        catch (err){
            alert(err);
        }
    }
    
        return(
            <div>
               <form>
                <h1>Doctor Home</h1>
                <h2>Welcome {currentUser.name}</h2>
                <img src={doc} alt="Doctor" width="100" height="150"  style={{ alignSelf: 'center' }}/>
                <h3>What do you want to do?</h3>
                <Button variant="contained" color="primary" text="" onClick={() =>dHandler}>I wanna check my appointments for a certain day</Button>
             
                 <Button variant="contained" color="secondary" text="" onClick={() =>mHandler}>I wanna check my appointments for a certain month</Button>
                
                <Button variant="contained" color="tertiary" text="" onClick={() =>yHandler}>I wanna check my appointments for a certain year</Button>
                {dayHandler?
                <div>
                    <h3>Pick a date</h3>
                    <Calendar
                    onChange={checkAppointmentsOnDate}
                    value={date}
                    showNeighboringMonth={false}
                    locale={"en-US"}
                    />
                    

                    <h3>Appointments on month {moment(date).format('MM')}</h3>
                    <table>
                <tr>
                    <th>Appointment ID</th>
                    <th>Donor ID</th>
                    <th>City</th>
                    <th>Region</th>

                </tr>
               
                { 
                   dayDateAppointments&&dayDateAppointments.map(appointment=> {
                       
                        return (
                            <tr>
                                <td>{index++}</td>
                                <td>{appointment.donorid}</td>
                                <td>{appointment.lcity}</td>
                                <td>{appointment.lregion}</td>
                                <td>{appointment.appdate}</td>
                            </tr>

                        )
                    }
                   
                   
               ) }
                
                   
                
            </table>
            <Pagination
            count={totalPages}
            page={currentPage}
            siblingCount={1}
            boundaryCount={1}
            variant="outlined"
            shape="rounded"
            onChange={handlePageChange}
            />
                    
             </div>
                
               :null
                }
                </form>
            </div>
        )
    
}

export default DoctorHome;