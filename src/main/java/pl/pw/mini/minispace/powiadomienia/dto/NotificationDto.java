package pl.pw.mini.minispace.powiadomienia.dto;

import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.powiadomienia.entity.notification.NotificationType;

import java.util.UUID;

@Getter
@Setter
public class NotificationDto {

    private UUID uuid;
    private String content;
    private String title;
    private NotificationType type;
    private InfoEmailDto infoEmail;

}
