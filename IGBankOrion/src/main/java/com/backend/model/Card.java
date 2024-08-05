package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCard;

    @Column(unique = true)
    private String cardNumber;
    private String cardName;
    private String cardType;
    private String expireDate;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "idAccount")
    private Account account;


    @OneToMany(mappedBy = "cardFrom")
    private List<CardTransaction> cardTransactionsFrom;

    @OneToMany(mappedBy = "cardTo")
    private List<CardTransaction> cardTransactionsTo;

}
