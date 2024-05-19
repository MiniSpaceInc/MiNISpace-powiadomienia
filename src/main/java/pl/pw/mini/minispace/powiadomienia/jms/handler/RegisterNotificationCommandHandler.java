package pl.pw.mini.minispace.powiadomienia.jms.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.pw.mini.minispace.powiadomienia.dto.NotificationDto;
import pl.pw.mini.minispace.powiadomienia.dto.RegisterNotificationResponse;
import pl.pw.mini.minispace.powiadomienia.dto.command.RegisterNotificationCommand;
import pl.pw.mini.minispace.powiadomienia.mapper.NotificationMapper;
import pl.pw.mini.minispace.powiadomienia.service.RegisterNotificationService;

@Slf4j
@RequiredArgsConstructor
@Component
public class RegisterNotificationCommandHandler {

    private final RegisterNotificationService registerNotificationService;
    private final NotificationMapper notificationMapper;

    public RegisterNotificationResponse handleRegisterNotificationCommand(RegisterNotificationCommand cmd) {
        NotificationDto dto = notificationMapper.fromRegisterCommand(cmd);
        return registerNotificationService.registerNotification(dto);
    }
}
