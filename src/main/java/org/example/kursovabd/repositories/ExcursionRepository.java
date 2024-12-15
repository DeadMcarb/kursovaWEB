package org.example.kursovabd.repositories;


import org.example.kursovabd.data.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursionRepository extends JpaRepository<Excursion, Integer> {
}