package pl.pw.mini.minispace.powiadomienia.dto.command;

import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.powiadomienia.dto.InfoEmailDto;

import java.io.Serializable;

@Getter
@Setter
public class RegisterNotificationCommand implements Serializable {
    private String title;
    private String content;
    private InfoEmailDto emailInfo;
}
