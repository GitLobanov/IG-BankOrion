package com.backend.factory;

import com.backend.model.Account;
import com.backend.model.Card;

import java.math.BigDecimal;

public class CardFactory {

    public static Card createCard (Account account, String cardNumber){
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setCardName("Debit");
        card.setAccount(account);
        card.setAmount(100.0);
        return card;
    }
}
