package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "language", nullable = false)
    private String language;

    @OneToMany(mappedBy = "language")
    private Set<Excursion> excursions = new LinkedHashSet<>();

}