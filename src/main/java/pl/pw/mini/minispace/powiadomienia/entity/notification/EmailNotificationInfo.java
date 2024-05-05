package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.powiadomienia.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "EmailNotificationsInfo")
public class EmailNotificationInfo extends BaseEntity {

    @OneToOne(mappedBy = "emailInfo")
    private Notification notification;

    @Column
    private String email;
}
