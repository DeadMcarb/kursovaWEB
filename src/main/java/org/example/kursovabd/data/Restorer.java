package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "restorer")
public class Restorer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restorer_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Lob
    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Lob
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Lob
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "restorer")
    private Set<Restoration> restorations = new LinkedHashSet<>();

    public Restorer(String firstName, String secondName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


}