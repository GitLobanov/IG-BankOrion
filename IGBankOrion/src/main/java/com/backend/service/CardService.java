package com.backend.service;

import com.backend.model.Account;
import com.backend.model.Card;
import com.backend.model.User;
import com.backend.repository.AccountRepository;
import com.backend.repository.CardRepository;

import java.util.Random;

public class CardService {

    CardRepository cardRepository;
    AccountRepository accountRepository;

    public CardService() {
        cardRepository = new CardRepository();
        accountRepository = new AccountRepository();
    }

    public boolean makeCard(User user) {
        Account account = accountRepository.findByUser(user);

        Card card = new Card();
        card.setAccount(account);
        card.setCardName("Debit");
        card.setCardType("Debit");
        card.setAmount(0);
        card.setExpireDate("09/29");
        card.setCardNumber(getRandomNumberCard());

        return cardRepository.save(card);
    }


    private String getRandomNumberCard (){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int min = 1111;
        int max = 9999;

        stringBuilder.append(random.nextInt(max-min+1) + min).append(" ");
        stringBuilder.append(random.nextInt(max-min+1) + min).append(" ");
        stringBuilder.append(random.nextInt(max-min+1) + min).append(" ");
        stringBuilder.append(random.nextInt(max-min+1) + min);

        if (accountRepository.findByNumber(stringBuilder.toString()) == null) {
            return stringBuilder.toString();
        } else {
            return getRandomNumberCard();
        }
    }

}
