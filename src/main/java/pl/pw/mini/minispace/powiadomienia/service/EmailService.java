package pl.pw.mini.minispace.powiadomienia.service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(String destination, String subject, String content) throws MessagingException;
}
