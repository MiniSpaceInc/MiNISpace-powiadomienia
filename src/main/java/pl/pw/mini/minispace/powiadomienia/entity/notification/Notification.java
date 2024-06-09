package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "notifications")
@ToString
public class Notification extends AbstractNotification {

    @ToString.Exclude
    @OneToMany(mappedBy = "notification", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmailNotificationInfo> emailInfo;

}
