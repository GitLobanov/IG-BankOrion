package com.backend.controller;

import com.backend.model.User;
import com.backend.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService(); // Assume you have a UserService class for user operations
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberPhone = request.getParameter("numberPhone");
        String password = request.getParameter("password");

        User user = userService.authenticateUser(numberPhone, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("/purchases");
        } else {
            response.sendRedirect("login.jsp?error=Invalid phone number or password");
        }
    }

}

