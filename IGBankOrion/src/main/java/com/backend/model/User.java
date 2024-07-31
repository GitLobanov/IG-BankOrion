package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String fullName;
    private String numberPhone;
    private String role;
    private String password;
    @OneToOne
    private Account account;

}
