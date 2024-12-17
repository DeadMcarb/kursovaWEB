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
    @JoinColumn(name = "excursion_id", nullable = false, referencedColumnName = "excursion_id")
    private Excursion excursion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "total", nullable = false)
    private Double total;

    public BuyExcursion(Instant date, String bankCardDetails, Integer numberOfPeopleToExcursion, Excursion excursion, User user, Double total) {
        this.date = date;
        this.bankCardDetails = bankCardDetails;
        this.numberOfPeopleToExcursion = numberOfPeopleToExcursion;
        this.excursion = excursion;
        this.user = user;
        this.total = total;
    }
}