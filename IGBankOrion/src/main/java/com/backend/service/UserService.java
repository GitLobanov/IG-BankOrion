package com.backend.service;

import com.backend.model.Account;
import com.backend.model.User;
import com.backend.repository.AccountRepository;
import com.backend.repository.UserRepository;

import java.util.Random;

public class UserService {

    UserRepository userRepository = new UserRepository();
    AccountRepository accountRepository = new AccountRepository();

    public boolean registerUser(User user) {
        try {
            user.setRole("USER");
            userRepository.save(user);

            Account account = new Account();
            account.setNumberAccount(getRandomNumberAccount());
            account.setUser(user);

            accountRepository.save(account);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public User authenticateUser(String numberPhone, String password) {

        User user = userRepository.findByPhoneAndPassword(numberPhone,password);

        return user;
    }

    public String getRandomNumberAccount (){
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
            return getRandomNumberAccount();
        }
    }
}
