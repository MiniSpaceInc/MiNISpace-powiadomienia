package pl.pw.mini.minispace.powiadomienia.entity.notification;

public enum NotificationType {
    EMAIL("EMAIL"),
    APPLICATION("APPLICATION");

    private String type;

    NotificationType(String type) {
        this.type = type;
    }
}
