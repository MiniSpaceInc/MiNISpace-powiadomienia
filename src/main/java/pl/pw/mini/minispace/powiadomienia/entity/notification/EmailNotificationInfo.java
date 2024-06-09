package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.powiadomienia.entity.BaseEntity;

@Getter
@Setter
@Entity(name = "email_notifications_info")
public class EmailNotificationInfo extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "notification_id", nullable = false)
    private Notification notification;

    @Column
    private String email;
}
