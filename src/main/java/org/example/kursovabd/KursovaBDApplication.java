package org.example.kursovabd;

import org.example.kursovabd.data.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KursovaBDApplication {

    public static User currentUser = new User();
    public static void main(String[] args) {
        SpringApplication.run(KursovaBDApplication.class, args);
    }

}
