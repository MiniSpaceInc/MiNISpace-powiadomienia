package pl.pw.mini.minispace.powiadomienia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterNotificationResponse {
    private Boolean success;
    private String message;
}
