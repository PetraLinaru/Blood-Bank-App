
import{useContext, useState, useEffect} from 'react';
import { useLocation, useNavigate, useSearchParams,createSearchParams } from 'react-router-dom';
import TextField from '@material-ui/core/TextField';
import { Autocomplete } from "@mui/material";
import axios from 'axios';
import Calendar from 'react-calendar';
import Button from '@material-ui/core/Button';
import moment from 'moment';

import 'react-calendar/dist/Calendar.css';

function CreateAppointment(){

    const [doctors,setDoctors] = useState([]);
    const [locations,setLocations]=useState([]);
    const [currentUser,setCurrentUser]=useState("");
    const [searchparams]=useSearchParams();
    const navigate = useNavigate();
    const [docoptions,setDocOptions]=useState([]);
    const [locationoptions,setLocationOptions]=useState([]);
    const [date,setDate]=useState(new Date());
    const[doctorid,setDoctorId]=useState("");
    const[locationid,setLocationId]=useState("");
    var docoptionslist=[];
    var locationoptionslist=[];
    const[available,setAvailable]=useState("");
    var doc;
    var loc;
    var locationss=[]

    var globalLocId;
    var globalDocId;
    var globalUserUUID;
    const [choosenDoc,setChoosenDoc]=useState("");
    const [choosenLoc,setChoosenLoc]=useState("");

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

        const getDoctors= () => {
            axios
                .get('http://localhost:8080/doctor/findAllDocs')
                .then((res) => {
                    console.log(res);
                    setDoctors(res.data);
                    
                    docHandler()
                    
                
                })
                .catch((err) => {
                    console.log(err);
                });
              };
    
    
    
              const getLocations= () => {
                axios
                    .get('http://localhost:8080/location/all')
                    .then((res) => {
                      
                        setLocations(res.data);
                        locationss=res.data;
                        locationHandler();
                    
                    })
                    .catch((err) => {
                        console.log(err);
                    });
                  };
             
    

    
   
            getDoctors();
            getLocations();
            locationHandler();
            docHandler();
            setLocationId();
            setDoctorId();
            const user_uuid=searchparams.get('uuid');
            globalUserUUID=user_uuid;
            getUser(user_uuid);
    }, [date]);

    useEffect(() => {
        console.log(doctorid);
      }, [doctorid]);
    useEffect(() => {
        console.log(locationid);
      }, [locationid]);



    async function locationHandler() {
        console.log(locationss)
        let index =0;
        for (loc of locationss)
                    {
                        console.log(loc.location_name)
                        console.log(loc.location_name)
                        if(locationoptionslist.includes(loc.location_name) && locationoptionslist.includes(loc.city) && locationoptionslist.includes(loc.region)&&locationoptionslist.includes(loc.location_name+", "+loc.city+", "+loc.region))
                        {
                            break;
                        }
                        else{
                        const locationstring = loc.location_name+", "+loc.city+", "+loc.region;	
                        locationoptionslist.push(locationstring);
                        }
                        console.log(locationoptionslist)
                       
                    }
                    setLocationOptions(locationoptionslist);
                }
  async function docHandler()
    {
        for(doc of doctors)
        {

            console.log(doc.name)
            if(docoptionslist.includes(doc.name))
            {
                continue;
            }
            docoptionslist.push(doc.name);
           
        }
        setDocOptions(docoptionslist);
    }
  async function setDoc(name)
    {
        console.log("Setting doc ID for: "+name)
   
        for (let doc1 of doctors)
        {
            
            if(doc1.name==name)
            {
                console.log(doc1.name+" choosen test")
                console.log(doc1.uuid+" choosen docid test")
                setDoctorId(doc1.uuid);
                globalDocId=doc1.uuid;
                return doc1.uuid;
            }
        }
    }

   async function setLoc(loc)
    {
        const splitted=String(loc).split(',');
        console.log("Setting loc "+loc)
        console.log(splitted[0]+splitted[1]+splitted[2])
       
       
        for (let loc1 of locations)
        {
            
           
            if(loc1.location_name==splitted[0]&&loc1.city==splitted[1].trim()&&loc1.region==splitted[2].trim())
            {
                
                console.log("Location id is :"+loc1.locationid)
                setLocationId(loc1.locationid);
                console.log(locationid)
                globalLocId=loc1.locationid;
                console.log("Global: "+globalLocId)
                
            }
        }
    }

    async function LocHandler(choosenLoc)
    {
        
        
        console.log("Choosen loc is "+choosenLoc)
        setLoc(choosenLoc);
    }

    async function DocHandler(choosenDoc)
    {
       
        console.log("Choosen doc is "+choosenDoc)
        setDoc(choosenDoc);

    }

    async function checkAvailableDate(date)  {
        try
        {       const passeddate=moment(date).format('YYYY-MM-DD');
                const url = 'http://localhost:8080/appointment/fdate/'+passeddate;
                const data = { date: passeddate};
                const config = { 'content-type': 'application/json' };
                const res = await axios.get(url, data, config);
                const appointments=res.data;

                if(appointments.length>5)
                {
                    alert("Sorry, no available appointments on this date, try another date");
                }
                else
                {
                    setDate(date);
                    setAvailable(5-appointments.length)
                    console.log(available)
                }
               
        }
            catch(err)
            {
                alert(err);
            }
        }

    async function createAppointment()  {
       
        console.log(locationid,doctorid,date)
        globalDocId=doctorid;
        globalLocId=locationid;
        globalUserUUID=currentUser.uuid;
        console.log(doctorid,locationid,globalUserUUID,date)
        try
        {
            const instance=axios.create();
           const res= await  instance.post('http://localhost:8080/appointment/add',
             {
                id:globalUserUUID,
                docid:globalDocId,
                locationid:globalLocId,
                donorid:globalUserUUID,
                date:date},
            {headers: {
                'Content-Type': 'application/json'
                }});
                const appointment=res.data;
                console.log(res.data)
                alert("Appointment created successfully!");
                navigate({pathname:'/donorhome' , search:createSearchParams({uuid:currentUser.uuid}).toString()});
 
         }
            catch(err)
            {
                alert(err);
            }
        }

    return(
        <div>
            <card>
            <h1>Hi there!</h1>
            <h2>Make an appointment</h2>

            <form>
                <label for="Pick your doctor">Pick your doctor</label><br/>
                <Autocomplete
                        value={choosenDoc}
                        onChange={(event, choosenDoc) => {
                           setChoosenDoc(choosenDoc)
                           DocHandler(choosenDoc)
                         }}
                        disablePortal
                        id="combo-box-demo"
                        options={docoptions}
                        sx={{ width: 300 }}
                        renderInput={(params) => <TextField {...params} label="List of doctors" />}
                       
        
                        />
            </form>

            <form>
                <label for="Pick your location">Pick your location</label><br/>
                <Autocomplete
                        value={choosenLoc}
                        onChange={(event, choosenLoc) => {
                            setChoosenLoc(choosenLoc)
                            LocHandler(choosenLoc)
                            }}
                            disablePortal
                        id="combo-box-demo"
                        options={locationoptions}
                        attribute="name"
                        sx={{ width: 300 }}
                        renderInput={(params) => <TextField {...params} label="List of locations" />}
                          
                        />
            </form>

            <form>
                <label for="Pick a date">Pick a date</label><br/>
              
                <Calendar
                    onChange={checkAvailableDate}
                    value={date}
                    showNeighboringMonth={false}
                    locale={"en-US"}
                />
            </form>
            <div>
            <h1> Available spots on this date : {available}</h1>
             </div>
            <Button variant="contained" color="primary" text="Create your appointment!" onClick={() =>{createAppointment() }}>Make an appointment</Button>

            </card>
        </div>
    )
}

export default CreateAppointment;