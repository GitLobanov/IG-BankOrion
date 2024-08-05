package com.backend.service;

import com.backend.model.Card;
import com.backend.model.CardTransaction;
import com.backend.repository.CardRepository;
import com.backend.repository.TransactionRepository;
import com.backend.util.HibernateUtil;

public class TransactionService {

    TransactionRepository transactionRepository;
    CardRepository cardRepository;

    public TransactionService() {
        transactionRepository = new TransactionRepository();
        cardRepository = new CardRepository();
    }

    public void transferMoneyFromTo (Card from, Card to, double amount){

        CardTransaction cardTransaction  = new CardTransaction();
        cardTransaction.setCardFrom(from);
        cardTransaction.setCardTo(to);
        cardTransaction.setAmount(amount);
        cardTransaction.setDate("09/09/2024");

        transactionRepository.save(cardTransaction);

        withdrawMoney(from, amount);
        transferMoney(to, amount);

    }

    private void withdrawMoney (Card card, double amount) {
        card.setAmount(card.getAmount() - amount);

        cardRepository.update(card);

    }

    private void transferMoney (Card card, double amount) {
        card.setAmount(card.getAmount() + amount);

        cardRepository.update(card);

    }


}
