package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "paintings")
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "painting_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "style_id", nullable = false)
    private Style style;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Column(name = "originaly", nullable = false)
    private Integer originaly;

    @Column(name = "worth", nullable = false)
    private Double worth;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(name = "favorites",
            joinColumns = @JoinColumn(name = "picture_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Client> clients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "painting")
    private Set<Restoration> restorations = new LinkedHashSet<>();


    public Painting(String name, Artist artist, Style style, Genre genre, Integer originaly, Double worth, Integer roomId, String description) {
        this.name = name;
        this.artist = artist;
        this.style = style;
        this.genre = genre;
        this.originaly = originaly;
        this.worth = worth;
        this.roomId = roomId;
        this.description = description;
    }
}






