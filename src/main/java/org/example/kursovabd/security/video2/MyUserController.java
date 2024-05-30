package org.example.kursovabd.security.video2;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MyUserController {
    MyUserService service;


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                          @RequestParam String password,
                          @RequestParam String roles,
                          @RequestParam String email) {
        service.addUser(new MyUser(name, password, roles, email));
        return "user is saved";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
