package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.kursovabd.security.video2.User;

@Getter
@Setter
@Entity
@Table(name = "favorites")
public class Favorite {
    @EmbeddedId
    private FavoriteId id;

    @MapsId("paintingId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "painting_id", nullable = false)
    private Painting painting;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}