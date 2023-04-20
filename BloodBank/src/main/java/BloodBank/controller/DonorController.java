package BloodBank.controller;

import BloodBank.model.Doctor;
import BloodBank.model.Donor;
import BloodBank.model.User;
import BloodBank.service.DonorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/donor")
@CrossOrigin(origins="http://localhost:3000")
public class DonorController {
    private final DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping("/register")
    public ResponseEntity<Donor> registerUser(@RequestBody Donor donor)
    {
        Donor registeredDonor = donorService.registerDonor(donor);
        return ResponseEntity.ok(registeredDonor);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email")String email)
    {
        Donor found = donorService.findDonorByEmail(email);
        return ResponseEntity.ok(found);
    }

    @GetMapping("/getByUUID/{uuid}")
    public ResponseEntity<Donor> getDonorByUUID(@PathVariable("uuid") UUID uuid)
    {
        Donor registeredDonor = donorService.getDonorByUuid(uuid);
        return ResponseEntity.ok(registeredDonor);
    }

    @PostMapping("/deleteDonor/{email}")
    public void deleteDonor(@PathVariable("email")String email)
    {
        Donor found = donorService.findDonorByEmail(email);
        if (found!=null)
        {
            donorService.deleteDonor(found);
        }
    }
}
