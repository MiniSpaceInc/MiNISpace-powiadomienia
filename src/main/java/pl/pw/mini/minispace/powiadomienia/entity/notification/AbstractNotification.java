package pl.pw.mini.minispace.powiadomienia.entity.notification;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.powiadomienia.entity.BaseEntity;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractNotification extends BaseEntity {

    @Column
    protected UUID uuid;

    @Column
    protected String title;

    @Column
    protected String content;

    @Column
    protected NotificationType type;
}
