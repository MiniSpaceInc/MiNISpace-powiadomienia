package pl.pw.mini.minispace.powiadomienia.dto;

public enum NotificationTypeEnum {
    EMAIL("EMAIL"),
    APPLICATION("APPLICATION");

    private String type;

    NotificationTypeEnum(String type) {
        this.type = type;
    }
}
