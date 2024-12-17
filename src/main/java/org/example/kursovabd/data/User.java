package org.example.kursovabd.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;
    private String roles;

    @Column(nullable = false)
    private String email;

//    @OneToMany(mappedBy = "user")
//    private Set<BuyExcursion> buyExcursions = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "user")
//    private Set<Favorite> favorites = new LinkedHashSet<>();


    public User(String name, String password, String roles, String email) {
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }
}

