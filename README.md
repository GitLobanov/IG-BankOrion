### Drill-Project: "Financial Assistant"

#### Description of the project
The project is a web application for managing clients' bank accounts. Customers can open accounts, deposit and withdraw money, view transaction history and receive reports on their finances. There are also functions for administrators who can manage accounts and users.

#### Goals
- **Learn Tree Structure**
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

#### Using trees
1. **Binary tree**: for storing and quickly searching information about customer accounts. Each node of the tree represents an account, and the key is a unique account identifier.
2. **AVL tree**: for storing transactions on each account, providing balancing and quick access to the latest transactions.
3. **Segment tree**: to make requests for the amount of transactions for a certain period of time.
4. **Trie (prefix tree)**: to implement customer search by name or other attributes.

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
                /com/bank
                    /model
                        Account.java
                        Transaction.java
                        User.java
                    /service
                        AccountService.java
                        TransactionService.java
                        UserService.java
                    /controller
                        AccountServlet.java
                        TransactionServlet.java
                        UserServlet.java
                    /util
                        TreeUtil.java
                        CacheUtil.java
            /resources
                hibernate.cfg.xml
            /webapp
                /WEB-INF
                    web.xml
                index.jsp
                login.jsp
                account.jsp
                transaction.jsp
```

#### Using Redis
Redis will be used to cache data about user sessions and frequently requested reports. This will reduce the load on the H2 database and speed up data access.

#### Conclusion
The Financial Assistant project provides an opportunity to explore various aspects of Java development, including working with trees, multithreading, using databases and caching. This is a great opportunity to consolidate knowledge and skills in web application development.
