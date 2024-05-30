package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.Servises.ArtistService;
import org.example.kursovabd.Servises.GenreService;
import org.example.kursovabd.Servises.PaintingService;
import org.example.kursovabd.Servises.StyleService;
import org.example.kursovabd.data.Painting;
import org.springframework.security.access.prepost.PreAuthorize;
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
        model.addAttribute("paintings", ps.getPaintingInfo());
//        model.addAttribute("paintings", ps.getPaintings());

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
    @PreAuthorize("hasAuthority('ADMIN')") //доступ только с ролью
    public String deletePainting(@PathVariable int id){
//        model.addAttribute("Paintings", as.getPaintings());
//        as.getPaintings().forEach(c -> System.out.println(c.toString()));
        ps.deletePainting(id);
        return "redirect:/paintings";
    }


    @GetMapping("/edit_painting")
    @PreAuthorize("hasAuthority('ADMIN')") //доступ только с ролью
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
    @PreAuthorize("hasAuthority('ADMIN')") //доступ только с ролью
    public String updatePainting(@RequestParam int paintingId,@RequestParam String name, @RequestParam Integer artistId,
                                 @RequestParam Integer styleId, @RequestParam Integer genreId,
                                 @RequestParam  Integer originaly, @RequestParam Double worth,
                                 @RequestParam Integer roomId, @RequestParam String description) {
        ps.updatePainting(paintingId, name, as.findById(artistId), ss.findById(styleId), gs.findById(genreId),
                originaly, worth, roomId, description);
        return "redirect:/paintings";
    }

}