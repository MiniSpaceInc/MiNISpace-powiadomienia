package pl.pw.mini.minispace.powiadomienia.service;

import pl.pw.mini.minispace.powiadomienia.dto.NotificationDto;
import pl.pw.mini.minispace.powiadomienia.dto.RegisterNotificationResponse;

public interface RegisterNotificationService {
    RegisterNotificationResponse registerNotification(NotificationDto notificationDto);
}
