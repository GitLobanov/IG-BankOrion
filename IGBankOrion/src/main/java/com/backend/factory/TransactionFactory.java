package com.backend.factory;

import com.backend.model.Card;
import com.backend.model.CardTransaction;

public class TransactionFactory {

    public static CardTransaction createTransaction(Card cardFrom, Card cardTo, double amountPaid, String date) {
        CardTransaction cardTransaction = new CardTransaction();
        cardTransaction.setAmount(amountPaid);
        cardTransaction.setDate(date);
        cardTransaction.setCardTo(cardTo);
        cardTransaction.setCardFrom(cardFrom);

        return cardTransaction;
    }

}
