package BloodBank.controller;

import BloodBank.model.Doctor;
import BloodBank.model.User;
import BloodBank.service.DoctorService;
import BloodBank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
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
        return ResponseEntity.ok(registeredDoctor);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<Doctor> getDoctorByEmail(@PathVariable("email")String email)
    {
        Doctor registeredDoctor = doctorService.findDoctorByEmail(email);
        return ResponseEntity.ok(registeredDoctor);
    }



}
