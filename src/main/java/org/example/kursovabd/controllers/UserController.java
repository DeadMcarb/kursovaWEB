package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Excursion;
import org.example.kursovabd.data.User;

import org.example.kursovabd.servises.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {
    UserService service;


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                          @RequestParam String password,
                          @RequestParam String roles,
                          @RequestParam String email) {
        service.addUser(name, password, roles, email);
        return "redirect:/login";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/login")
    public String registerUser(@RequestParam String name,
                               @RequestParam String password) {
        Optional<User> optionalUserser = service.findByName(name);
        if(optionalUserser.isPresent()) {
            User user = optionalUserser.get();
            System.out.println(user.getName());
            System.out.println(user.getPassword());
            if (!user.getPassword().equals(password)) {
                return "redirect:/login";
            } else {
                if (user.getRoles().equals("ADMIN") ) return "/admin_panel";
                return "/home";
            }

        } else return "redirect:/login";

    }

    @GetMapping("/admin_panel")
    String adminPanel() {
        return "/admin_panel";
    }


    @GetMapping("/home")
    public String Paintings(Model model) {
//        model.addAttribute("paintings", ps.getPaintingInfo());
////        model.addAttribute("paintings", ps.getPaintings());
//
//        model.addAttribute("artists", as.getArtists());
//        model.addAttribute("styles", ss.getStyles());
//        model.addAttribute("genres", gs.getGenres());
//
////        ps.getInfo().forEach(c -> System.out.println(c.toString()));
        return "home";
    }
}
