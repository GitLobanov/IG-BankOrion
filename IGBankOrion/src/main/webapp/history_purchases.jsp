<%@ page import="com.backend.repository.UserRepository" %>
<%@ page import="com.backend.model.User" %>
<%@ page import="com.backend.repository.AccountRepository" %>
<%@ page import="com.backend.model.Account" %>
<%@ page import="com.backend.model.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="com.backend.repository.CardRepository" %>
<%@ page import="com.backend.model.CardTransaction" %>
<%@ page import="com.backend.repository.TransactionRepository" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.backend.model.CardTransaction" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Account Page</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="icon.ico" type="image/x-icon">
</head>
<body>

<%
    UserRepository userRepository = (UserRepository) config.getServletContext().getAttribute("userRepository");
    AccountRepository accountRepository  = (AccountRepository) config.getServletContext().getAttribute("accountRepository");
    CardRepository cardRepository = (CardRepository) config.getServletContext().getAttribute("cardRepository");
    TransactionRepository transactionRepository = (TransactionRepository) config.getServletContext().getAttribute("transactionRepository");

    User user = (User) session.getAttribute("currentUser");
    Account account = accountRepository.findByUser(user);

    List<Card> cards = cardRepository.findByAccount(account);
    List<CardTransaction> cardTransactions = new ArrayList<>();

    for (Card card : cards) {
        for (CardTransaction tr : transactionRepository.findByTransferFrom(card)) {
            cardTransactions.add(tr);
        }
    }

%>


<div class="container">
    <header>
        <h1>Bank Account</h1>
    </header>

    <section class="account-info">
        <h2>User Information</h2>
        <p><strong>Name:</strong> <%= user.getFullName()%></p>
        <p><strong>Account: </strong> <%= account.getNumberAccount()%></p>
        <p><strong>All money: </strong> <%= cards.stream().mapToDouble(Card::getAmount).sum() + "₽" %> </p>
    </section>

    <%
        if (!cards.isEmpty()) {
    %>

    <section class="card-selection">
        <h2>Choose Your Card</h2>
        <form>
            <label for="cards">Select Card:</label>
            <select id="cards" name="cards">
                <%if (!cards.isEmpty())
                    for (Card card : cards) {
                        String cardInfo = card.getCardName() + ": " + card.getCardNumber();
                %>
                <option value="<%= card.getCardNumber() + " | " + card.getAmount() + "₽" %>"><%= cardInfo %></option>
                <%
                        }
                %>
            </select>
        </form>
        <div class="card-info">
            <h3>Card Information</h3>
            <p id="card-info-text"></p>
        </div>
    </section>

    <form action="/makeCard" method="post">
        <button type="submit">Make one MORE</button>
    </form>


    <%



        } else {
    %>

    <h2>You don't have card. Maybe we make one for you?</h2>

    <form action="/makeCard" method="post">
        <button type="submit">Make</button>
    </form>

    <%

        }

    %>



    <section class="purchase-history">
        <h2>Purchase History</h2>

        <form action="/transfer" method="get">
            <button type="submit">Transfer my money</button>
        </form>

        <table>
            <thead>
            <tr>
                <th>Date</th>
                <th>To</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody>

            <%

                for (CardTransaction cardTransaction : cardTransactions) {

            %>

            <tr>
                <td> <%= cardTransaction.getDate()%> </td>
                <td> <%= cardTransaction.getCardTo().getAccount().getUser().getFullName() %> </td>
                <td> <%= cardTransaction.getAmount() + "₽ "%> </td>
            </tr>

            <%

                }

            %>


            </tbody>
        </table>
    </section>
</div>
<script src="scripts/history-script.js"></script>
</body>
</html>

