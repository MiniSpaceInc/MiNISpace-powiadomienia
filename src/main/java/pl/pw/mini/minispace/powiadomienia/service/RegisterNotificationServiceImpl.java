package pl.pw.mini.minispace.powiadomienia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.powiadomienia.dto.NotificationDto;
import pl.pw.mini.minispace.powiadomienia.dto.RegisterNotificationResponse;
import pl.pw.mini.minispace.powiadomienia.entity.notification.EmailNotificationInfo;
import pl.pw.mini.minispace.powiadomienia.entity.notification.Notification;
import pl.pw.mini.minispace.powiadomienia.mapper.NotificationMapper;
import pl.pw.mini.minispace.powiadomienia.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegisterNotificationServiceImpl implements RegisterNotificationService {

    private static String NOTIFICATION_EXISTS = "Notification with given UUID: %s already exists";
    private static final String SUCCESSFUL_REGISTER = "Successfully registered notification";

    private final NotificationRepository notificationRepository;

    private final NotificationMapper notificationMapper;

    @Override
    public RegisterNotificationResponse registerNotification(NotificationDto notificationDto) {
        RegisterNotificationResponse response = new RegisterNotificationResponse();
        Optional<Notification> notificationOpt = notificationRepository.findByUuid(notificationDto.getUuid());
        if (notificationOpt.isPresent()) {
            response.setMessage(String.format(NOTIFICATION_EXISTS, notificationDto.getUuid()));
            response.setSuccess(Boolean.FALSE);
            return response;
        }

        Notification notification = buildNotification(notificationDto);
        log.info("Saving notification {}", notification);
        notificationRepository.save(notification);

        response.setMessage(SUCCESSFUL_REGISTER);
        response.setSuccess(Boolean.TRUE);
        return response;
    }

    private Notification buildNotification(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setUuid(notificationDto.getUuid());
        notification.setContent(notificationDto.getContent());
        notification.setType(notificationDto.getType());
        notification.setTitle(notificationDto.getTitle());

        List<EmailNotificationInfo> emails = notificationDto.getInfoEmail().getEmail().stream()
                .map(email -> {
                    EmailNotificationInfo emailInfo = new EmailNotificationInfo();
                    emailInfo.setEmail(email);
                    emailInfo.setNotification(notification);
                    return emailInfo;
                }).toList();

        notification.setEmailInfo(emails);
        return notification;
    }
}
