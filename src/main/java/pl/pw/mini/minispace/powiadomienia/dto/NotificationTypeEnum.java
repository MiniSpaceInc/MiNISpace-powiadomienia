package pl.pw.mini.minispace.powiadomienia.dto;

public enum NotificationTypeEnum {
    EVENT_REMINDER("EMAIL_REMINDER"),
    EVENT_SIGNUP("EVENT_SIGNUP"),
    EVENT_INVITATION("EVENT_INVITATION")
    ;

    private String type;

    NotificationTypeEnum(String type) {
        this.type = type;
    }
}
