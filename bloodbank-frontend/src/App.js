import Register from './components/Register';
import Login from './components/Login';
import Home from './components/Home';
import AdminHome from './components/AdminHome';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import EditWindow from './components/EditWindow';
import RegisterDoctor from './components/RegisterDoctor';
import DonorHome from './components/DonorHome';
import EditDonor from './components/EditDonor';
import CreateAppointment from './components/CreateAppointment';	
import DoctorHome from './components/DoctorHome';

function App() {
  return (
    <div className="App">
 <BrowserRouter>
            <Routes>
              <Route path="/login" element= { <Login/>} />
              <Route path="/register" element= { <Register/>} />
              <Route path="/adminhome" element= { <AdminHome/>} />
              <Route path="/editwindow" element={ <EditWindow/>}/>
              <Route path="/donorhome" element ={<DonorHome/> }/>
              <Route path ="/doctorhome" element = {<DoctorHome/>} />
              <Route path="/registerdoctor" element={ <RegisterDoctor/>}/>
              <Route path="/createappointment" element={ <CreateAppointment/>}/>
              <Route path="/editdonor" element={ <EditDonor/>}/>
              <Route path="/" element= { <Home/>} />
            </Routes>
  </BrowserRouter>
    </div>
  );
}

export default App;
