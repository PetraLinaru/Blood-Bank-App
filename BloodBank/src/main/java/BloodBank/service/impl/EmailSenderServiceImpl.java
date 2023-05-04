package BloodBank.service.impl;
/*

import BloodBank.service.EmailSenderSevice;
import it.ozimov.springboot.mail.model.Email;
import jakarta.mail.internet.InternetAddress;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class EmailSenderServiceImpl implements EmailSenderSevice {

    @Autowired
    private EmailService emailService;

    public void sendEmail(String toEmail, String subject, String message) {
        final Email email;
        try {
            email = DefaultEmail.builder()
                    .from(new InternetAddress("petrarozalialuca@gmail.com", "Petra Linaru"))
                    .to(toEmail)
                    .subject(subject)
                    .body(message)
                    .encoding("UTF-8").build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        emailService.send(email);
    }

*/
/*
    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
*//*



*/
/*    @Override
    public void sendEmail(String toEmail, String subject, String message) {
       *//*
*/
/* SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        simpleMailMessage.setFrom("petrarozalialuca@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
*//*
*/
/*
        this.mailSender.send(simpleMailMessage);
    }*//*



}
*/

import BloodBank.model.Appointment;
import BloodBank.model.Donor;
import BloodBank.service.AppointmentService;
import BloodBank.service.DonorService;
import BloodBank.service.EmailSenderSevice;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.io.File;
import java.util.List;

@Service
public class EmailSenderServiceImpl implements EmailSenderSevice {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DonorService donorService;

    public void sendEmail(String toEmail,
                                String subject,
                                String message
    ) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("petrarozalialuca@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(String.valueOf(message));
        mailMessage.setSubject(subject);
        mailSender.send(mailMessage);
        System.out.println("Mail Send...");


    }

    public void sendReminderEmail(String toEmail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("petrarozalialuca@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText("This is a reminder, you have an appointment for tomorrow");
        mailMessage.setSubject(" !! IMPORTANT : REMINDER FOR TOMORROW !!");
        mailSender.send(mailMessage);
        System.out.println("Reminder sent...");

    }


    @Scheduled(cron = "0 6 15 * * *",zone = "Europe/Bucharest") // trimit la 15:06 everyday , am pus asa ca sa testez
    public void sendAppointmentReminders() throws MessagingException {

        List<Appointment> appointments = appointmentService.getAppointmentsForTomorrow();
        System.out.println("apelam");

        for (Appointment appointment:appointments)
        {
            System.out.println(appointment.getDate());
            Donor toSend=donorService.getDonorByUuid(appointment.getDonorid());
            this.sendReminderEmail(toSend.getEmail());
        }
    }






}

