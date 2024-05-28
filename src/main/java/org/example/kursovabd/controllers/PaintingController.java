package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.Servises.ArtistService;
import org.example.kursovabd.Servises.GenreService;
import org.example.kursovabd.Servises.PaintingService;
import org.example.kursovabd.Servises.StyleService;
import org.example.kursovabd.data.Artist;
import org.example.kursovabd.data.Genre;
import org.example.kursovabd.data.Painting;
import org.example.kursovabd.data.Style;
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
//    private ArtistService as;

    @GetMapping("/paintings")
    public String Paintings(Model model) {
//        model.addAttribute("paintings", ps.getInfo());
        model.addAttribute("paintings", ps.getPaintings());

        model.addAttribute("artists", as.getArtists());
        model.addAttribute("styles", ss.getStyles());
        model.addAttribute("genres", gs.getGenres());

//        ps.getInfo().forEach(c -> System.out.println(c.toString()));
        return "paintings";
    }


    @PostMapping("/add_painting")
    public String addPainting(@RequestParam String name, @RequestParam Integer artistId,
                                         @RequestParam Integer styleId, @RequestParam Integer genreId,
                                         @RequestParam  Integer originaly, @RequestParam Double worth,
                                         @RequestParam Integer roomId, @RequestParam String description) {

//        model.addAttribute("Paintings", as.getPaintings());
//        as.getPaintings().forEach(c -> System.out.println(c.toString()));
        ps.addPainting(name, as.findById(artistId), ss.findById(styleId), gs.findById(genreId),
                originaly, worth, roomId, description);
        return "redirect:/paintings";
    }

    @GetMapping("delete_painting/{id}")
    public String deletePainting(@PathVariable int id){
//        model.addAttribute("Paintings", as.getPaintings());
//        as.getPaintings().forEach(c -> System.out.println(c.toString()));
        ps.deletePainting(id);
        return "redirect:/paintings";
    }


    @GetMapping("/edit_painting")
    public String editPainting(@RequestParam int id, Model model){
        Optional<Painting> Painting = ps.findById(id);
        if(Painting.isPresent()){
            model.addAttribute("Painting", Painting.get());
            return "edit_painting";
        }
        return "redirect:/paintings";
    }

    @PatchMapping("/update_painting")
    public String updatePainting(@RequestParam int Painting_id,
                               @RequestParam String Painting_name){
        ps.updatePainting(Painting_id, Painting_name);
        return "redirect:/paintings";
    }

}