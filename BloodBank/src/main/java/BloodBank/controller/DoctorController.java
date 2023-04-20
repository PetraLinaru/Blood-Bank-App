package BloodBank.controller;

import BloodBank.model.Doctor;
import BloodBank.model.User;
import BloodBank.service.DoctorService;
import BloodBank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins="http://localhost:3000")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService)
    {
        this.doctorService=doctorService;
    }


    @PostMapping("/register")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor)
    {
       Doctor registeredDoctor = doctorService.registerDoctor(doctor);
        if (registeredDoctor != null)
        {
            return ResponseEntity.ok(registeredDoctor);
        }
        else
            return (ResponseEntity<Doctor>) ResponseEntity.notFound();
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<Doctor> getDoctorByEmail(@PathVariable("email")String email)
    {
        Doctor registeredDoctor = doctorService.findDoctorByEmail(email);
        return ResponseEntity.ok(registeredDoctor);
    }

    @GetMapping("/findAllDocs")
    public ResponseEntity< List<Doctor>> getAllDoctors()
    {
        List<Doctor> doctorList=doctorService.getDoctors();
        System.out.println(doctorList);
        return ResponseEntity.ok(doctorList);
    }

    @PostMapping("/updateDoctor")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor)
    {
        Doctor foundDoctor=doctorService.findDoctorByUUID(doctor.uuid);
        if (foundDoctor!=null)
        {
            Doctor renewed =doctorService.editDoctor(doctor,doctor.uuid );

            return ResponseEntity.ok(renewed);
        }
        return (ResponseEntity<Doctor>)ResponseEntity.internalServerError();

    }




}
