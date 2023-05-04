package BloodBank.service;

import jakarta.mail.MessagingException;

public interface EmailSenderSevice {
    void sendEmail(String toEmail, String subject, String message);
    public void sendReminderEmail(String toEmail);
    public void sendAppointmentReminders() throws MessagingException;
}
