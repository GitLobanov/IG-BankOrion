package com.backend.controller;

import com.backend.model.Account;
import com.backend.model.Card;
import com.backend.model.User;
import com.backend.repository.AccountRepository;
import com.backend.repository.CardRepository;
import com.backend.service.CardService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="MakeCardServlet", urlPatterns = "/makeCard")
public class MakeCardServlet extends HttpServlet {

    AccountRepository accountRepository;
    CardRepository cardRepository;
    CardService cardService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        accountRepository = new AccountRepository();
        cardRepository = new CardRepository();
        cardService = new CardService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("currentUser");


        if (cardService.makeCard(user)) {
            resp.sendRedirect("/purchases");
        } else {
            resp.sendRedirect("/purchases?error=Registration failed");
        }


    }
}
