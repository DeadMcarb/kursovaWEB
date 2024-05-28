package org.example.kursovabd.repositories;

import org.example.kursovabd.data.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}