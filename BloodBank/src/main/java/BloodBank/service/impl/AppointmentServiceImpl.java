package BloodBank.service.impl;

import BloodBank.Repository.AppointmentRepository;
import BloodBank.model.Appointment;
import BloodBank.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment createAppointment(Appointment appointment)
    {
        this.appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public List<Appointment> findAppointmentsOnDate(Date date) {
        List<Appointment> appointments=this.appointmentRepository.findAppointmentsByDate(date);
        return appointments;
    }

    @Override
    public List<Appointment> findDocAppointmentsOnDate(Date date, UUID uuid) {
        return null;
    }

    @Override
    public Page<Appointment> findDocAppointmentsOnMDate(Date date, UUID uuid, Pageable page) {
        Page<Appointment> appointments=this.appointmentRepository.getMonthAppointments(date,date,uuid,page);

//        Iterator<Appointment> iterator=appointments.iterator();
//        int count=0;
//        System.out.println(date+"initial\n");
//        System.out.println(uuid+"initial\n");
//        for(Appointment a:appointments)
//        {
//
//
//            if (a.getDate().compareTo(date)==0&&a.getDocid().equals(uuid))
//            {
//                toReturn.add(a);
//                System.out.println(a.getId());
//            }
//        }
        //System.out.println(appointments);
        return appointments;
    }
    public List<Appointment> getAll()
    {
        List<Appointment> appointmentList=this.appointmentRepository.findAll();
        return appointmentList;
    }


}
