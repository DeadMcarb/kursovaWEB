package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.kursovabd.Servises.RestorationService;

import org.example.kursovabd.data.Painting;
import org.example.kursovabd.data.Restoration;

import org.example.kursovabd.data.Restorer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class RestorationController {

    private RestorationService rs;
    @GetMapping("/restorations")
    public String restorations(Model model) {
        model.addAttribute("restorations", rs.getRestorations());
        return "restorations";
    }
    @GetMapping("/delete_restoration")
    public String deleteRestoration(@RequestParam int id){
        rs.deleteRestoration(id);
        return "redirect:/restorations";
    }

    @PostMapping("/add_restoration")
    public String addRestoration(@RequestParam Restorer restorer, @RequestParam Painting painting,
                                 @RequestParam Instant startDate, @RequestParam Instant endDate,
                                 @RequestParam Integer status, @RequestParam Double price){
        rs.addRestoration(restorer, painting, startDate, endDate, status, price);
        return "redirect:/restorations";
    }

    @GetMapping("/edit_restoration")
    public String editRestoration(@RequestParam int id, Model model){
        Optional<Restoration> restoration = rs.findById(id);
        if(restoration.isPresent()){
            model.addAttribute("restoration", restoration.get());
            return "edit_restoration";
        }
        return "redirect:/restorations";
    }

    @PostMapping("/edit_restoration")
    public String updateRestoration(@RequestParam int id, @RequestParam Restorer restorer, @RequestParam Painting painting,
                                    @RequestParam Instant startDate, @RequestParam Instant endDate,
                                    @RequestParam Integer status, @RequestParam Double price) {

        rs.updateRestoration(id, restorer, painting, startDate, endDate, status, price);
        return "redirect:/restorations";
    }



}
