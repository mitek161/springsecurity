package com.example.SpringSecurityThird.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserSecurity")
@Getter
@Setter
@NoArgsConstructor
public class UserSecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public UserSecurity(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
