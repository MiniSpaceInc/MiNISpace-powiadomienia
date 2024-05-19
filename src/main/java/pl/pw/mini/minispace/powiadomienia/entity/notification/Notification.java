package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "Notifications")
@ToString
public class Notification extends AbstractNotification {

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "email_info_id", referencedColumnName = "id")
    private EmailNotificationInfo emailInfo;

}
