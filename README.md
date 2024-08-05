### Drill-Project: "Financial Assistant"

#### Description of the project
The project is a web application for managing clients' bank accounts. Customers can open accounts, deposit and withdraw money, view transaction history and receive reports on their finances. There are also functions for administrators who can manage accounts and users.

#### Goals
- **Learn stack and queue**
- **Learn multithreading** ? under question
- **Use redis**
- **Consolidation of knowledge**: JSP, Servlets, Hibernate H2 in memory

#### Subject area
- **Customers**: Users who open accounts and manage their finances.
- **Accounts**: various types of accounts (savings, current, etc.).
- **Transactions**: deposit and withdrawal operations.
- **Administrators**: Users with system management rights.

#### Function requirements
1. **Registration and authentication of clients**.
2. **Create, edit and delete invoices**.
3. **Deposit and withdrawal of funds**.
4. **View transaction history**.
5. **Generating reports on accounts**.
6. **User and account management for administrators**.

#### The technology stack used
- **Java**: the main programming language.
- **Servlets and JSP**: to create a web interface.
- **H2 Database**: for storing customer, account and transaction data.
- **Redis**: for caching data about user sessions and frequently requested reports.
- **Multithreading**: for transaction processing and data security.
- **Trees**: for organizing account and transaction data.

#### Using stack and queue
- **Stack**: to implement the history of operations (deposit/withdrawal of funds). Each operation is placed on the stack, and if necessary, you can cancel the last operation.
- **Queue**: for processing incoming transactions. Each transaction is queued, and a multithreaded handler retrieves and processes them.

#### Example of multithreading
Using threads to process transactions. Each time a client initiates a transaction, a new thread is created that processes that transaction, while ensuring data security through synchronization.

#### Project structure
```
/bank-app
    /src
        /main
            /java
                /com/backend
                    /model
                        Account.java
                        Transaction.java
                        CardTransaction.java
                        User.java
                    /service
                        AccountService.java
                        TransactionService.java
                        UserService.java
                    /repository
                        AccountRepository.java
                        CardRepository.java
                        TransactionRepository.java
                        UserRepository.java
                        CrudRepository.java (interface)
                    /controller
                        HistoryPurchasesServlet.java
                        IndexServlet.java
                        LoginServlet.java
                        MakeCardServlet.java
                        RegisterServlet.java
                        TransferServlet.java
                    /util
                        ContextListener.java
                        ExceptionHandler.java
                        HibernateUtil.java
            /resources
                hibernate.cfg.xml
            /webapp
                /css
                /scripts
                /WEB-INF
                    web.xml
                index.jsp
                login.jsp
                history_purchases.jsp
                transfer.jsp
```

#### Using Redis
Redis will be used to cache data about user sessions and frequently requested reports. This will reduce the load on the H2 database and speed up data access.

#### Conclusion
The Financial Assistant project provides an opportunity to explore various aspects of Java development, including working with trees, multithreading, using databases and caching. This is a great opportunity to consolidate knowledge and skills in web application development.


#### UI interafec

- **History of purchases**

- ![image](https://github.com/user-attachments/assets/2f1da777-79a1-4b43-ac55-f9fc13a313c5)
