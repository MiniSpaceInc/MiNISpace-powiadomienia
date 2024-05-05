package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Notifications")
public class Notification extends AbstractNotification {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "email_info_id", referencedColumnName = "id")
    private EmailNotificationInfo emailInfo;

}
