package org.example.kursovabd.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        service.addUser(new User(name, password, roles, email));
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
