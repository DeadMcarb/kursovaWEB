package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "type")
    private Set<Excursion> excursions = new LinkedHashSet<>();

}