package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.KursovaBDApplication;
import org.example.kursovabd.data.Excursion;
import org.example.kursovabd.data.User;
import org.example.kursovabd.servises.BuyExcursionService;
import org.example.kursovabd.servises.ExcursionService;

import org.example.kursovabd.servises.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class BuyExcursionController {
    private BuyExcursionService bes;

    private UserService us;
    private ExcursionService es;

    @GetMapping("/boughtExcursions")
    public String boughtExcursions(Model model) {
        model.addAttribute("boughtExcursions", bes.getBoughtExcursionInfo());

        model.addAttribute("users", us.getUsers());
        model.addAttribute("excursions", es.getExcursions());

        return "boughtExcursions";
    }

    @GetMapping("/zvit")
    public String zvit(Model model) {
        model.addAttribute("excursionRevenue", bes.getBoughtExcursionZvit());

        return "zvit";
    }

    @GetMapping("/month_zvit")
    public String monthZvit(Model model) {
        model.addAttribute("excursionRevenue", bes.getBoughtExcursionMonthZvit());

        return "month_zvit";
    }

    @GetMapping("/buyExcursion")
    public String showBuyExcursionForm(Model model) {
        model.addAttribute("users", us.getUsers());
        model.addAttribute("excursions", es.getExcursions());
        return "buyExcursionForm";
    }

    @PostMapping("/buyExcursion")
    public String buyExcursion(@RequestParam String bankCardDetails,
                               @RequestParam Integer numberOfPeopleToExcursion,
                               @RequestParam Integer excursionId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUsername = authentication.getName();
//        Optional<User> currentUser = us.findByName(currentUsername);

//
//        if(currentUser.isPresent()) {
            Excursion e = es.findById(excursionId).get();


///////////////////////////
            User user = KursovaBDApplication.currentUser;
///////////////////////////


            bes.addBoughtExcursion(Instant.now(), bankCardDetails, numberOfPeopleToExcursion, user, e, e.getPrice()*numberOfPeopleToExcursion);
//        }

        return "redirect:/home";
    }



//    @PostMapping("/add_BoughtExcursion")
//    public String addBoughtExcursion(@RequestParam String name, @RequestParam Integer artistId,
//                              @RequestParam Integer styleId, @RequestParam Integer genreId,
//                              @RequestParam  Integer originaly, @RequestParam Double worth,
//                              @RequestParam Integer roomId, @RequestParam String description) {
//
//        bes.addBoughtExcursion(name, us.findById(artistId), ss.findById(styleId), es.findById(genreId),
//                originaly, worth, roomId, description);
//        return "redirect:/BoughtExcursions";
//    }
//
//
//
//    @GetMapping("delete_BoughtExcursion/{id}")
//    @PreAuthorize("hasAuthority('ADMIN')") //доступ только с ролью
//    public String deleteBoughtExcursion(@PathVariable int id){
//        bes.deleteBoughtExcursion(id);
//        return "redirect:/BoughtExcursions";
//    }
//
//
//    @GetMapping("/edit_BoughtExcursion")
//    @PreAuthorize("hasAuthority('ADMIN')") //доступ только с ролью
//    public String editBoughtExcursion(@RequestParam int id, Model model){
//        Optional<BoughtExcursion> BoughtExcursion = bes.findById(id);
//        if(BoughtExcursion.isPresent()){
//            model.addAttribute("BoughtExcursion", BoughtExcursion.get());
//
//            model.addAttribute("artists", us.getArtists());
//            model.addAttribute("styles", ss.getStyles());
//            model.addAttribute("genres", es.getGenres());
//            return "edit_BoughtExcursion";
//        }
//        return "redirect:/BoughtExcursions";
//    }
//
//    @PatchMapping("/update_BoughtExcursion")
//    @PreAuthorize("hasAuthority('ADMIN')") //доступ только с ролью
//    public String updateBoughtExcursion(@RequestParam int BoughtExcursionId,@RequestParam String name, @RequestParam Integer artistId,
//                                 @RequestParam Integer styleId, @RequestParam Integer genreId,
//                                 @RequestParam  Integer originaly, @RequestParam Double worth,
//                                 @RequestParam Integer roomId, @RequestParam String description) {
//        bes.updateBoughtExcursion(BoughtExcursionId, name, us.findById(artistId), ss.findById(styleId), es.findById(genreId),
//                originaly, worth, roomId, description);
//        return "redirect:/BoughtExcursions";
//    }

}