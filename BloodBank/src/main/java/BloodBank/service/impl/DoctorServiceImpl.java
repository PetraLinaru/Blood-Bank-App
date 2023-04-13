package BloodBank.service.impl;


import BloodBank.Repository.DoctorRepository;
import BloodBank.model.Doctor;
import BloodBank.model.Role;
import BloodBank.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    final DoctorRepository doctorRepository;


    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor registerDoctor(Doctor doctor) {
        Doctor newDoctor= doctorRepository.save(doctor);
        return doctor;
    }

    @Override
    public Doctor getDoctor(String verification) {
        return null;
    }

    @Override
    public Doctor findDoctorByEmail(String email) {
        Doctor found = doctorRepository.findDoctorByEmail(email);
        if (found!=null)
            return found;
        else return null;
    }

    @Override
    public Doctor findMaybeExistingDoctor(String firstName, String lastName, String email)
    {
//      User found=userRepository.findUserByEmailAndFirstNameAndLastName(email,firstName,lastName);
//      if (found!=null)
//         return found;
//      else return null;
        return null;
    }



    @Override
    public Doctor loginDoctor(String password, String email) {
        Doctor found = doctorRepository.findDoctorByEmailAndPassword(email,password);
        if (found!=null)
            return found;
        else return null;

    }

    @Override
    public Doctor editDoctor(Doctor newDoctor)
    {
       Doctor renewed= doctorRepository.save(newDoctor);
        return renewed;
    }




}
