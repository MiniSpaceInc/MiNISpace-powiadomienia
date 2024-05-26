package pl.pw.mini.minispace.powiadomienia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MiNiSpacePowiadomieniaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiNiSpacePowiadomieniaApplication.class, args);
    }

}
