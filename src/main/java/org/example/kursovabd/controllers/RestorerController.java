package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Restorer;
import org.example.kursovabd.servises.RestorerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class RestorerController {

    private RestorerService rs;
    @GetMapping("/restorers")
    public String restorers(Model model) {
        model.addAttribute("restorers", rs.getRestorers());
        rs.getRestorers().forEach(c -> System.out.println(c.toString()));
        return "restorers";
    }

    @GetMapping("/add_restorer")
    public String showRestorerForm(Model model) {
        return "add_restorer";
    }

    @PostMapping("/add_restorer")
    public String addRestorer(@RequestParam String restorer_first_name,
                              @RequestParam String restorer_second_name,
                              @RequestParam String restorer_phone_number,
                              @RequestParam String restorer_email){
        rs.addRestorer(restorer_first_name,
                restorer_second_name, restorer_phone_number, restorer_email);
        return "redirect:/restorers";
    }

    @GetMapping("/delete_restorer")
    public String deleteRestorer(@RequestParam int id){
        rs.deleteRestorer(id);
        return "redirect:/restorers";
    }


    @GetMapping("/edit_restorer")
    public String editRestorer(@RequestParam int id, Model model){
        Optional<Restorer> restorer = rs.findById(id);
        if(restorer.isPresent()){
            model.addAttribute("restorer", restorer.get());
            return "edit_restorer";
        }
        return "redirect:/restorers";
    }

    @PostMapping("/edit_restorer")
    public String updateRestorer(@RequestParam int restorer_id,
                                 @RequestParam String restorer_first_name,
                                 @RequestParam String restorer_second_name,
                                 @RequestParam String restorer_phone_number,
                                 @RequestParam String restorer_email){
        rs.updateRestorer(restorer_id, restorer_first_name,
                restorer_second_name, restorer_phone_number, restorer_email);
        return "redirect:/restorers";
    }



}