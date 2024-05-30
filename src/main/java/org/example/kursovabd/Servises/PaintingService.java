package org.example.kursovabd.Servises;

import lombok.AllArgsConstructor;

import org.example.kursovabd.data.*;
import org.example.kursovabd.data.modelProjection.PaintingInfo;
import org.example.kursovabd.repositories.PaintingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PaintingService {
    private final PaintingRepository paintingRepository;

//    public List<PaintingDto> getInfo() {
//        return paintingRepository.findAllP();
//    }


    public List<Painting> getPaintings() {
        return paintingRepository.findAll();
    }
    public List<PaintingInfo> getPaintingInfo() {return paintingRepository.getPaintingInfo();};


    public void addPainting(String name, Optional<Artist> artist, Optional<Style> style, Optional<Genre> genre, Integer originaly, Double worth, Integer roomId, String description) {
        if (artist.isPresent()&&style.isPresent()&&genre.isPresent() ) {
            paintingRepository.save(new Painting(name, artist.get(), style.get(), genre.get(),
                    originaly, worth, roomId, description));

        }
    }


    public void deletePainting(int id) {
        paintingRepository.deleteById(id);
    }

    public Optional<Painting> findById(int id) {
        return paintingRepository.findById(id);
    }

    public void updatePainting(int paintingId, String name, Optional<Artist> artist, Optional<Style> style, Optional<Genre> genre, Integer originaly, Double worth, Integer roomId, String description) {
        Optional<Painting> Painting = paintingRepository.findById(paintingId);

        Painting.ifPresent(a->{
            if (artist.isPresent()&&style.isPresent()&&genre.isPresent() ) {
                a.setName(name);
                a.setArtist(artist.get());
                a.setStyle(style.get());
                a.setGenre(genre.get());
                a.setOriginaly(originaly);
                a.setWorth(worth);
                a.setRoomId(roomId);
                a.setDescription(description);

                paintingRepository.save(a);
            }
        });
    }

//    public void updateRestorer(int RestorerId, String restorer_first_name,
//                               String restorer_second_name,
//                               String restorer_phone_number, String restorer_email) {
//        Optional<Restorer> Restorer = restorerRepository.findById(RestorerId);
//        Restorer.ifPresent(a->{
//            a.setFirstName(restorer_first_name);
//            a.setSecondName(restorer_second_name);
//            a.setPhoneNumber(restorer_phone_number);
//            a.setEmail(restorer_email);
//            restorerRepository.save(a);
//        });
//    }
}