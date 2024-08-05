package com.backend.controller;

import com.backend.model.Account;
import com.backend.model.Card;
import com.backend.model.User;
import com.backend.repository.CardRepository;
import com.backend.service.TransactionService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TransferServlet", urlPatterns = "/transfer")
public class TransferServlet extends HttpServlet {

    CardRepository cardRepository;
    TransactionService transactionService;

    @Override
    public void init() throws ServletException {
        cardRepository = (CardRepository) getServletContext().getAttribute("cardRepository");
        transactionService = (TransactionService) getServletContext().getAttribute("transactionService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("transfer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double amount = Double.parseDouble(req.getParameter("transferAmount"));
        Card cardTo = cardRepository.findByCardNumber(req.getParameter("cardTo"));
        Card cardFrom = cardRepository.findByCardNumber(req.getParameter("cardFrom"));

        transactionService.transferMoneyFromTo(cardFrom, cardTo, amount);

        resp.sendRedirect("/purchases");
    }
}
