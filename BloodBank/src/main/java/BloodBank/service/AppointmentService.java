package BloodBank.service;

import BloodBank.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    public Appointment createAppointment(Appointment appointment);
    List<Appointment> findAppointmentsOnDate(Date date);

    List<Appointment> findDocAppointmentsOnDate(Date date, UUID uuid);
    Page<Appointment> findDocAppointmentsOnMDate(Date date, UUID uuid, Pageable page);

    public List<Appointment> getAll();
}
