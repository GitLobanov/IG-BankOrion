package com.backend.factory;

import com.backend.model.User;

public class UserFactory {

    public static User createUser(String fullName, String numberPhone, String password){
        User user = new User();
        user.setFullName(fullName);
        user.setNumberPhone(numberPhone);
        user.setPassword(password);
        user.setRole("USER");

        return user;
    }

    public User creteAdminUser(String fullName, String numberPhone, String password){
        User user = new User();
        user.setFullName(fullName);
        user.setNumberPhone(numberPhone);
        user.setPassword(password);
        user.setRole("ADMIN");

        return user;
    }

}
