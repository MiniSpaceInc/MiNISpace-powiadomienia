package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailNotification extends AbstractNotification {

    @Column
    private String email;
}
