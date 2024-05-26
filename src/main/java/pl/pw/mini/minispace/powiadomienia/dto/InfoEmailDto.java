package pl.pw.mini.minispace.powiadomienia.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class InfoEmailDto implements Serializable {
    private List<String> email;
}
