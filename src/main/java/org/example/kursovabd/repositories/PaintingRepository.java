package org.example.kursovabd.repositories;


import org.example.kursovabd.data.Painting;
import org.example.kursovabd.data.modelProjection.PaintingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PaintingRepository extends JpaRepository<Painting, Integer> {

//    @Query("select new org.example.kursovabd.data.modelProjection.PaintingDto(p.id, p.name, a.name, s.name, g.name, p.originaly, p.worth, p.roomId, p.description) " +
//            "from Painting p " +
//            "join p.artist a " +
//            "join p.style s " +
//            "join p.genre g")
//    List<PaintingDto> findAllP();

    List<Painting> findAll();




    @Query(value = """ 
SELECT
    p.painting_id AS id,
    p.name AS name,
    a.name AS artist,
    s.name AS style,
    g.name AS genre,
    p.originaly AS originaly,
    p.worth AS worth,
    p.room_id AS roomId,
    p.description AS description,
    COUNT(f.user_id) AS favourite
FROM paintings p
JOIN artists a ON p.artist_id = a.artist_id
JOIN styles s ON p.style_id = s.style_id
JOIN genres g ON p.genre_id = g.genres_id
LEFT JOIN favorites f ON p.painting_id = f.painting_id
GROUP BY
    p.painting_id,
    p.name,
    a.name,
    s.name,
    g.name;
""", nativeQuery = true)
    List<PaintingInfo> getPaintingInfo();

}