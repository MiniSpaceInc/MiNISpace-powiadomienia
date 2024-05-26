package pl.pw.mini.minispace.powiadomienia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pw.mini.minispace.powiadomienia.dto.NotificationDto;
import pl.pw.mini.minispace.powiadomienia.dto.command.RegisterNotificationCommand;
import pl.pw.mini.minispace.powiadomienia.entity.notification.Notification;

@Mapper(componentModel = "spring", uses = {EmailNotificationInfoMapper.class})
public interface NotificationMapper {

    NotificationDto toDto(Notification notification);

//    @Mapping(source = "infoEmail", target = "emailInfo")
//    Notification fromDto(NotificationDto dto);

    @Mapping(source = "infoEmail", target = "infoEmail")
    @Mapping(source = "uuid", target = "uuid")
    @Mapping(source = "type", target = "type")
    NotificationDto fromRegisterCommand(RegisterNotificationCommand command);
}
