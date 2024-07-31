package com.backend.factory;

import com.backend.model.Account;
import com.backend.model.User;

public class AccountFactory {

    public static Account createAccount(User user, String numberAccount) {
        Account account = new Account();
        account.setNumberAccount(numberAccount);
        account.setUser(user);
        return account;
    }
}
