package com.backend.util;

import com.backend.factory.AccountFactory;
import com.backend.factory.CardFactory;
import com.backend.factory.TransactionFactory;
import com.backend.factory.UserFactory;
import com.backend.model.Account;
import com.backend.model.Card;
import com.backend.model.CardTransaction;
import com.backend.model.User;
import com.backend.repository.AccountRepository;
import com.backend.repository.CardRepository;
import com.backend.repository.TransactionRepository;
import com.backend.repository.UserRepository;
import com.backend.service.TransactionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionListener;


import java.util.ArrayList;
import java.util.List;

@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {


    UserRepository userRepository = new UserRepository();
    AccountRepository accountRepository = new AccountRepository();
    CardRepository cardRepository = new CardRepository();
    TransactionRepository transactionRepository = new TransactionRepository();


    TransactionService transactionService = new TransactionService();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userRepository", userRepository);
        servletContext.setAttribute("accountRepository", accountRepository);
        servletContext.setAttribute("cardRepository", cardRepository);
        servletContext.setAttribute("transactionRepository", transactionRepository);

        servletContext.setAttribute("transactionService", transactionService);

        loadDemoData(sce);
    }

    private void loadDemoData(ServletContextEvent sce) {


        User u1 = UserFactory.createUser("Иван Иванов", "1234567890", "password1");
        User u2 = UserFactory.createUser("Петр Петров", "0987654321", "password2");
        User u3 = UserFactory.createUser("Сидор Сидоров", "1122334455", "password3");
        User u4 = UserFactory.createUser("Алексей Алексеев", "2233445566", "password4");
        User u5 = UserFactory.createUser("Мария Мариева", "3344556677", "password5");
        User u6 = UserFactory.createUser("Анна Антонова", "4455667788", "password6");
        User u7 = UserFactory.createUser("Дмитрий Дмитриев", "5566778899", "password7");
        User u8 = UserFactory.createUser("Елена Еленина", "6677889900", "password8");
        User u9 = UserFactory.createUser("Светлана Светлова", "7788990011", "password9");
        User u10 = UserFactory.createUser("Николай Николаев", "8899001122", "password10");


        userRepository.saves(List.of(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10));

        Account a1 = AccountFactory.createAccount(u1, "1111 2222 3333 4444");
        Account a2 = AccountFactory.createAccount(u2, "1111 3222 3333 4444");
        Account a3 = AccountFactory.createAccount(u3, "1111 4222 3333 4444");
        Account a4 = AccountFactory.createAccount(u4, "1111 5222 3333 4444");
        Account a5 = AccountFactory.createAccount(u5, "1111 6222 3333 4444");
        Account a6 = AccountFactory.createAccount(u6, "1111 7222 3333 4444");
        Account a7 = AccountFactory.createAccount(u7, "1111 8222 3333 4444");
        Account a8 = AccountFactory.createAccount(u8, "1111 9222 3333 4444");
        Account a9 = AccountFactory.createAccount(u9, "1111 1022 3333 4444");
        Account a10 = AccountFactory.createAccount(u10, "1111 1122 3333 4444");

        accountRepository.saves(List.of(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10));

        Card c1 = CardFactory.createCard(a1, "2222 3333 4444 5555");
        c1.setAmount(2000000);
        Card c2 = CardFactory.createCard(a1, "7989 3333 4444 5555");
        Card c3 = CardFactory.createCard(a2, "1463 3333 4444 5555");
        Card c4 = CardFactory.createCard(a3, "3452 3333 4444 5555");
        Card c5 = CardFactory.createCard(a4, "4362 3333 4444 5555");
        Card c6 = CardFactory.createCard(a5, "4326 3333 4444 5555");
        Card c7 = CardFactory.createCard(a6, "4366 3333 4444 5555");
        Card c8 = CardFactory.createCard(a7, "7126 3333 4444 5555");
        Card c9 = CardFactory.createCard(a8, "2266 3333 4444 5555");
        Card c10 = CardFactory.createCard(a9, "2262 3333 4444 5555");

        cardRepository.saves(List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));

        transactionService.transferMoneyFromTo(c1,c2,1000);
        transactionService.transferMoneyFromTo(c1,c2,2000);
        transactionService.transferMoneyFromTo(c1,c3,3000);
        transactionService.transferMoneyFromTo(c1,c4,40000);
    }

}