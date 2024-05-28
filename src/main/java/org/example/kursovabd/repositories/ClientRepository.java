package org.example.kursovabd.repositories;

import org.example.kursovabd.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}