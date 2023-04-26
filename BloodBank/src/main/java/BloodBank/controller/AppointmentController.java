package BloodBank.controller;

import BloodBank.model.Appointment;
import BloodBank.service.AppointmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/appointment")
@CrossOrigin(origins="http://localhost:3000")
public class AppointmentController {

    final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment)
    {
        Appointment newAppointment=this.appointmentService.createAppointment(appointment);
        if(newAppointment!=null)
            return ResponseEntity.ok(newAppointment);
        else return (ResponseEntity<Appointment>) ResponseEntity.internalServerError();
    }

    @GetMapping("/fdate/{date}")
    public ResponseEntity<List<Appointment>> getAppointmentsOnDate(@PathVariable Date date)
    {
        List<Appointment> appointmentsList=appointmentService.findAppointmentsOnDate(date);

        return ResponseEntity.ok(appointmentsList);
    }

    //Merge, dar fara paginare, am adaugat paginare nu stiu cumm sa duc la capat : nu afiseaza in table :/
    //Daca dau inspect si printez in consola,reusesc sa vad lista cu programarile, dar nu reusesc sa le pun in
    //table
    @GetMapping("/doc/day/{uuid}/{date}")
    public ResponseEntity<Page<Appointment>> getDocsAppointmentsOnMonthDate(
            @PathVariable("uuid") UUID uuid,
            @PathVariable("date") Date date,
            Pageable pageable) {

        Page<Appointment> appointmentsList = appointmentService.findDocAppointmentsOnMDate(date, uuid, pageable);
        for(Appointment a:appointmentsList) {
            System.out.println(a.getDate());
        }
        return ResponseEntity.ok(appointmentsList);
    }

    @GetMapping ("/all")
    public ResponseEntity<List<Appointment>> getAll()
    {
        List<Appointment> appointmentList=appointmentService.getAll();
        return ResponseEntity.ok(appointmentList);
    }




}
