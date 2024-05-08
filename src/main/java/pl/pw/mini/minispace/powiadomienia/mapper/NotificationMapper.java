package pl.pw.mini.minispace.powiadomienia.mapper;

import org.mapstruct.Mapper;
import pl.pw.mini.minispace.powiadomienia.dto.NotificationDto;
import pl.pw.mini.minispace.powiadomienia.entity.notification.Notification;

@Mapper(componentModel = "spring", uses = {EmailNotificationInfoMapper.class})
public interface NotificationMapper {

    NotificationDto toDto(Notification notification);

    Notification fromDto(NotificationDto dto);
}
