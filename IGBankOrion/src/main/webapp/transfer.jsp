<%@ page import="com.backend.model.Card" %>
<%@ page import="com.backend.repository.UserRepository" %>
<%@ page import="com.backend.repository.AccountRepository" %>
<%@ page import="com.backend.repository.CardRepository" %>
<%@ page import="com.backend.repository.TransactionRepository" %>
<%@ page import="com.backend.model.User" %>
<%@ page import="com.backend.model.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="com.backend.model.CardTransaction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transfer Money</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="icon.ico" type="image/x-icon">
</head>
<body>

<%
    AccountRepository accountRepository  = (AccountRepository) config.getServletContext().getAttribute("accountRepository");

    User user = (User) session.getAttribute("currentUser");
    Account account = accountRepository.findByUser(user);

    List<Card> cards = account.getCards();

%>

<div class="container">
    <header>
        <h1>Transfer Money</h1>
    </header>

    <section class="transfer-form">
        <h2>Transfer Details</h2>
        <form action="" method="post" id="transfer-form">

            <label for="cards">Select Card:</label>
            <select id="cards" name="cardFrom">
                <%
                    for (Card card : cards) {
                        String cardInfo = card.getCardName() + ": " + card.getCardNumber();
                %>
                <option value="<%= card.getCardNumber()%>"><%= cardInfo %></option>
                <%
                    }
                %>
            </select>
            <br>

            <label for="card-number">Recipient Card Number:</label>
            <input type="text" id="card-number" name="cardTo" required pattern="\d{4} \d{4} \d{4} \d{4}" title="Card number should be 16 digits">

            <label for="transfer-amount">Amount to Transfer:</label>
            <input type="number" id="transfer-amount" name="transferAmount" required min="1" step="0.01">

            <button type="submit">Transfer</button>
        </form>
        <div id="message"></div>
    </section>
</div>
</body>
</html>

