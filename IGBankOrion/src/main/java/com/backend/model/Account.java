package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idAccount;
    private String numberAccount;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Card> cards;
    @OneToOne
    private User user;

}
