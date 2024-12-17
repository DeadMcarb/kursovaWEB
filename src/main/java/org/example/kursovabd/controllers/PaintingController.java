package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Painting;
import org.example.kursovabd.servises.ArtistService;
import org.example.kursovabd.servises.GenreService;
import org.example.kursovabd.servises.PaintingService;
import org.example.kursovabd.servises.StyleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class PaintingController {
    private PaintingService ps;
    private ArtistService as;
    private GenreService gs;
    private StyleService ss;


    @GetMapping("/paintings")
    public String Paintings(Model model) {
        model.addAttribute("paintings", ps.getPaintingInfo());
        return "paintings";
    }


    @GetMapping("/add_painting")
    public String showBuyExcursionForm(Model model) {
        model.addAttribute("artists", as.getArtists());
        model.addAttribute("styles", ss.getStyles());
        model.addAttribute("genres", gs.getGenres());
        return "add_painting";
    }


    @PostMapping("/add_painting")
    public String addPainting(@RequestParam String name, @RequestParam Integer artistId,
                                         @RequestParam Integer styleId, @RequestParam Integer genreId,
                                         @RequestParam  Integer originaly, @RequestParam Double worth,
                                         @RequestParam Integer roomId, @RequestParam String description) {

        ps.addPainting(name, as.findById(artistId), ss.findById(styleId), gs.findById(genreId),
                originaly, worth, roomId, description);
        return "redirect:/paintings";
    }



    @GetMapping("delete_painting/{id}")
    public String deletePainting(@PathVariable int id){
        ps.deletePainting(id);
        return "redirect:/paintings";
    }


    @GetMapping("/edit_painting")
    public String editPainting(@RequestParam int id, Model model){
        Optional<Painting> painting = ps.findById(id);
        if(painting.isPresent()){
            model.addAttribute("painting", painting.get());

            model.addAttribute("artists", as.getArtists());
            model.addAttribute("styles", ss.getStyles());
            model.addAttribute("genres", gs.getGenres());
            return "edit_painting";
        }
        return "redirect:/paintings";
    }

    @PatchMapping("/update_painting")
    public String updatePainting(@RequestParam int paintingId,@RequestParam String name, @RequestParam Integer artistId,
                                 @RequestParam Integer styleId, @RequestParam Integer genreId,
                                 @RequestParam  Integer originaly, @RequestParam Double worth,
                                 @RequestParam Integer roomId, @RequestParam String description) {
        ps.updatePainting(paintingId, name, as.findById(artistId), ss.findById(styleId), gs.findById(genreId),
                originaly, worth, roomId, description);
        return "redirect:/paintings";
    }

}