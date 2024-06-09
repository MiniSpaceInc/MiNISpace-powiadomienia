package pl.pw.mini.minispace.powiadomienia.entity.notification;

public enum NotificationType {
    EVENT_REMINDER("EMAIL_REMINDER"),
    EVENT_SIGNUP("EVENT_SIGNUP"),
    EVENT_INVITATION("EVENT_INVITATION")
    ;

    private String type;

    NotificationType(String type) {
        this.type = type;
    }
}
