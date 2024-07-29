package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idAccount")
    private long id;

    private String numberAccount;

    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToMany (mappedBy = "account")
    private List<Card> cards;

}
