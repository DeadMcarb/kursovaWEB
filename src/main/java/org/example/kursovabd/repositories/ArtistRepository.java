package org.example.kursovabd.repositories;

import org.example.kursovabd.data.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}