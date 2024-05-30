package org.example.kursovabd.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FavoriteId implements Serializable {
    private static final long serialVersionUID = 4736729649059703537L;
    @Column(name = "painting_id", nullable = false)
    private Integer paintingId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FavoriteId entity = (FavoriteId) o;
        return Objects.equals(this.paintingId, entity.paintingId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, userId);
    }

}