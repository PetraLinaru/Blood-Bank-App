package BloodBank.service.impl;


import BloodBank.Repository.DoctorRepository;
import BloodBank.model.Doctor;
import BloodBank.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    final DoctorRepository doctorRepository;


    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor registerDoctor(Doctor doctor) {
        Doctor newDoctor=(Doctor) doctorRepository.save(doctor);
        return doctor;
    }

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> doctorList=doctorRepository.findAll();
        if(doctorList!=null)
            return doctorList;
        else
            return null;
    }

    @Override
    public Doctor findDoctorByEmail(String email) {
        Doctor found =(Doctor) doctorRepository.findDoctorByEmail(email);
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
        Doctor found =(Doctor) doctorRepository.findDoctorByEmailAndPassword(email,password);
        if (found!=null)
            return found;
        else return null;

    }

    @Override
    public Doctor editDoctor(Doctor newDoctor, UUID oldUUID)
    {
        doctorRepository.updateDoctor(newDoctor.name, newDoctor.email, newDoctor.password, newDoctor.specialization,oldUUID);
        return newDoctor;
    }

    public void deleteDoctor(Doctor doctor)
    {
        doctorRepository.delete(doctor);

    }

    public Doctor findDoctorByUUID(UUID uuid)
    {
        Doctor found =doctorRepository.findDoctorByUuid(uuid);
        return found;
    }

}
