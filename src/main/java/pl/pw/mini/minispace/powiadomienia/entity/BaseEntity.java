package pl.pw.mini.minispace.powiadomienia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "date_created", nullable = false, updatable = false)
    protected LocalDateTime dateCreated = LocalDateTime.now();

    @Column(name = "date_modified")
    protected LocalDateTime dateModified;

    @Version
    protected Long version = 0L;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(this.dateCreated)) {
            this.dateCreated = LocalDateTime.now();
        }
    }

    @PostUpdate
    public void onUpdate() {
        this.dateModified = LocalDateTime.now();
        this.version++;
    }
}
