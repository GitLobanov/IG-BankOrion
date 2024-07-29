package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCard;

    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "idAccount")
    private Account account;

}
