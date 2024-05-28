package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.Servises.ArtistService;
import org.example.kursovabd.data.Artist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ArtistController {
    private ArtistService as;
    @GetMapping("/artists")
    public String artists(Model model) {
        model.addAttribute("artists", as.getArtists());
        as.getArtists().forEach(c -> System.out.println(c.toString()));
        return "artists";
    }

    @PostMapping("/add_artist")
    public String addArtist(@RequestParam String artist_name){
//        model.addAttribute("artists", as.getArtists());
//        as.getArtists().forEach(c -> System.out.println(c.toString()));
        as.addArtist(artist_name);
        return "redirect:/artists";
    }

    @GetMapping("delete_artist/{id}")
    public String deleteArtist(@PathVariable int id){
//        model.addAttribute("artists", as.getArtists());
//        as.getArtists().forEach(c -> System.out.println(c.toString()));
        as.deleteArtist(id);
        return "redirect:/artists";
    }


    @GetMapping("/edit_artist")
    public String editArtist(@RequestParam int id, Model model){
        Optional<Artist> artist = as.findById(id);
        if(artist.isPresent()){
            model.addAttribute("artist", artist.get());
            return "edit_artist";
        }
        return "redirect:/artists";
    }

    @PatchMapping("/update_artist")
    public String updateArtist(@RequestParam int artist_id,
                               @RequestParam String artist_name){
        as.updateArtist(artist_id, artist_name);
        return "redirect:/artists";
    }

    @GetMapping("/show_paintings_by_artist/{id}")
    public String showPaintingsByArtist(@PathVariable int id, Model model){
        Optional<Artist> artist = as.findById(id);
        if(artist.isPresent()){
            model.addAttribute("artist", artist.get());
            return "paintings_by_artist";
        }
        return "redirect:/artists";
    }

}
