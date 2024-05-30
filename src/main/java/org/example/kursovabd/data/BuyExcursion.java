package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.kursovabd.security.video2.User;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "buy_excursion")
public class BuyExcursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Lob
    @Column(name = "`bank card details`", nullable = false)
    private String bankCardDetails;

    @Column(name = "`number of people to excursion`", nullable = false)
    private Integer numberOfPeopleToExcursion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "excursion_id", nullable = false)
    private Excursion excursion;

}