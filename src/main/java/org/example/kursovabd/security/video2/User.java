package org.example.kursovabd.security.video2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.kursovabd.data.BuyExcursion;
import org.example.kursovabd.data.Painting;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @Lob
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<BuyExcursion> buyExcursions = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "painting_id"))
    private Set<Painting> paintings = new LinkedHashSet<>();

}