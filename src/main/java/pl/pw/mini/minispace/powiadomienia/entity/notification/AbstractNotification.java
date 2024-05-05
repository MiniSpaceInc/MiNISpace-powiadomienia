package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.powiadomienia.entity.BaseEntity;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractNotification extends BaseEntity {

    @Column
    protected String title;

    @Column
    protected String content;

    @Column
    protected NotificationType type;
}
