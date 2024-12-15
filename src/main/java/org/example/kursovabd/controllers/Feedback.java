package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class Feedback {
    @GetMapping("/feedback")
    public String artists(Model model) {
        return "feedback";
    }
}
