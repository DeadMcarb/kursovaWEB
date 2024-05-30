package org.example.kursovabd.security.video2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {


    Optional<MyUser> findByName(String name);
}