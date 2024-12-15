package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "restoration")
public class Restoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restoration_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restorer_id", nullable = false)
    private Restorer restorer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "painting_id", nullable = false)
    private Painting painting;

    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "price", nullable = false)
    private Double price;

    public Restoration(Restorer restorer, Painting painting, Instant startDate, Instant endDate, Integer status, Double price) {
        this.restorer = restorer;
        this.painting = painting;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.price = price;
    }
}