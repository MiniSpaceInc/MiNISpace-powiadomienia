package pl.pw.mini.minispace.powiadomienia.dto.command;

import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.powiadomienia.dto.InfoEmailDto;
import pl.pw.mini.minispace.powiadomienia.dto.NotificationTypeEnum;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class RegisterNotificationCommand implements Serializable {
    private UUID uuid;
    private String title;
    private String content;
    private InfoEmailDto infoEmail;
    private NotificationTypeEnum type;
}
