package org.example.kursovabd.repositories;


import org.example.kursovabd.data.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PaintingRepository extends JpaRepository<Painting, Integer> {

//    @Query("select new org.example.kursovabd.data.modelProjection.PaintingDto(p.id, p.name, a.name, s.name, g.name, p.originaly, p.worth, p.roomId, p.description) " +
//            "from Painting p " +
//            "join p.artist a " +
//            "join p.style s " +
//            "join p.genre g")
//    List<PaintingDto> findAllP();

    List<Painting> findAll();

}