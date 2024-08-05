package com.backend.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;

    @ManyToOne
    private Card cardFrom;

    @ManyToOne
    private Card cardTo;

    private double amount;

}
