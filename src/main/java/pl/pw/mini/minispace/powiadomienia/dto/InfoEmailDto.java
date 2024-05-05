package pl.pw.mini.minispace.powiadomienia.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InfoEmailDto implements Serializable {
    private String email;
}
