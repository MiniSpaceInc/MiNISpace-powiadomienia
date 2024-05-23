package pl.pw.mini.minispace.powiadomienia.scheduler;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.pw.mini.minispace.powiadomienia.entity.notification.Notification;
import pl.pw.mini.minispace.powiadomienia.repository.NotificationRepository;
import pl.pw.mini.minispace.powiadomienia.service.EmailService;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class EmailNotificationScheduler {

    private final NotificationRepository notificationRepository;

    private final EmailService emailService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Scheduled(cron = "${application.scheduler.notifications}")
    public void sendEmailNotifications() {
        log.info("sendEmailNotifications scheduler");
        Notification notification = notificationRepository.findNotificationToBeSent();
        if (Objects.isNull(notification)) {
            return;
        }

        notification.getEmailInfo().forEach(info -> {
            try {
                emailService.sendSimpleMessage(info.getEmail(), notification.getTitle(), notification.getContent());
            } catch (MessagingException e) {
                log.error("Error when sending email {}", e.getMessage());
                throw new RuntimeException(e);
            }
        });
        notification.setSent(Boolean.TRUE);
        notificationRepository.save(notification);
    }
}
