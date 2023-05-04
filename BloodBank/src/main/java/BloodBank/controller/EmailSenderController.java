package BloodBank.controller;

import BloodBank.model.EmailMessage;
import BloodBank.service.EmailSenderSevice;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins="http://localhost:3000")
public class EmailSenderController {
    private final EmailSenderSevice emailSenderSevice;


    public EmailSenderController(EmailSenderSevice emailSenderSevice) throws MessagingException {
        this.emailSenderSevice = emailSenderSevice;
        this.emailSenderSevice.sendAppointmentReminders();
    }

    @PostMapping("/send")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage)  {

        this.emailSenderSevice.sendEmail(emailMessage.getToEmail(), emailMessage.getSubject(),emailMessage.getMessage());
        return ResponseEntity.ok("Email sent successfully!");
    }
}
