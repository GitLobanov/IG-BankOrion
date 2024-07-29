package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "numberPhone")
    private String numberPhone;

    private String role;
    private String password;

}
