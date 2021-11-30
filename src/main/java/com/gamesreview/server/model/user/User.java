package com.gamesreview.server.model.user;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "registerDate", nullable = false)
    private LocalDate registerDate = LocalDate.now();

    @OneToMany
    @ElementCollection(fetch = FetchType.LAZY)
    private List<User> following;

    //TODO añadir foto de usuario
    //TODO añadir lista de juegos y de review

    public void addFollowing(User u){
        if(following == null) following = new ArrayList<>();
        following.add(u);
    }
}
