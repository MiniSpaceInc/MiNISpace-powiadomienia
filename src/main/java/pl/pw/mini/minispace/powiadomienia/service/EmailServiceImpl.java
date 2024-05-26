package pl.pw.mini.minispace.powiadomienia.service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${application.smtp.mail}")
    private String mail;

    private final JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMessage(String destination, String subject, String content) throws MessagingException {
        log.info("Sending email to: {}", destination);

        MimeMessage message = javaMailSender.createMimeMessage();
        message.setFrom(new InternetAddress(mail));
        message.setRecipients(Message.RecipientType.TO, destination);
        message.setSubject(subject);
        message.setContent(content, "text/html; charset=utf-8");

        javaMailSender.send(message);
    }
}
