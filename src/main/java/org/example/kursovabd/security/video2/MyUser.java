package org.example.kursovabd.security.video2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kursovabd.data.BuyExcursion;
import org.example.kursovabd.data.Painting;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="users")
public class MyUser {
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

    public MyUser(String name, String password, String roles, String email) {
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }
}
