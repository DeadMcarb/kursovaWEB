package org.example.kursovabd.servises;

import lombok.AllArgsConstructor;

import org.example.kursovabd.data.Excursion;
import org.example.kursovabd.repositories.ExcursionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExcursionService {
    private final ExcursionRepository excursionRepository;


    public List<Excursion> getExcursions() {
        return excursionRepository.findAll();
    }
//    public List<ExcursionInfo> getExcursionInfo() {return excursionRepository.getExcursionInfo();};


//    public void addExcursion(String name, Optional<Artist> artist, Optional<Style> style, Optional<Genre> genre, Integer originaly, Double worth, Integer roomId, String description) {
//        if (artist.isPresent()&&style.isPresent()&&genre.isPresent() ) {
//            excursionRepository.save(new Excursion(name, artist.get(), style.get(), genre.get(),
//                    originaly, worth, roomId, description));
//
//        }
//    }


    public void deleteExcursion(int id) {
        excursionRepository.deleteById(id);
    }

    public Optional<Excursion> findById(int id) {
        return excursionRepository.findById(id);
    }

//    public void updateExcursion(int ExcursionId, String name, Optional<Artist> artist, Optional<Style> style, Optional<Genre> genre, Integer originaly, Double worth, Integer roomId, String description) {
//        Optional<Excursion> Excursion = excursionRepository.findById(ExcursionId);
//
//        Excursion.ifPresent(a->{
//            if (artist.isPresent()&&style.isPresent()&&genre.isPresent() ) {
//                a.setName(name);
//                a.setArtist(artist.get());
//                a.setStyle(style.get());
//                a.setGenre(genre.get());
//                a.setOriginaly(originaly);
//                a.setWorth(worth);
//                a.setRoomId(roomId);
//                a.setDescription(description);
//
//                excursionRepository.save(a);
//            }
//        });
//    }

}