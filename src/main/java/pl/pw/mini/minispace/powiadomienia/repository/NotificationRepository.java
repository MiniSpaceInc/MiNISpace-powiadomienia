package pl.pw.mini.minispace.powiadomienia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pw.mini.minispace.powiadomienia.entity.notification.Notification;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findByUuid(UUID uuid);

    @Query(value = "SELECT TOP 1 * FROM Notifications n WHERE n.sent IS NULL ORDER BY ID", nativeQuery = true)
    Notification findNotificationToBeSent();
}
