package org.example.kursovabd.Servises;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Artist;
import org.example.kursovabd.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public void addArtist(String artistName) {
        artistRepository.save(new Artist(artistName));
    }

    public void deleteArtist(int id) {
        artistRepository.deleteById(id);
    }

    public Optional<Artist> findById(int id) {
        return artistRepository.findById(id);
    }

    public void updateArtist(int artistId, String artistName) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        artist.ifPresent(a->{
            a.setName(artistName);
            artistRepository.save(a);
        });
    }
}
