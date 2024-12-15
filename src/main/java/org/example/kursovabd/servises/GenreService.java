package org.example.kursovabd.servises;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Genre;
import org.example.kursovabd.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> findById(int id) {
        return genreRepository.findById(id);
    }
}