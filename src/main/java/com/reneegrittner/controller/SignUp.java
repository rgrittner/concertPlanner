package com.reneegrittner.controller;


import com.reneegrittner.entity.User;
import com.reneegrittner.entity.UserRole;
import com.reneegrittner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        urlPatterns = {"/signUp"}
)
public class SignUp extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);


        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String ensembleName = req.getParameter("ensembleName");

        User setUpNewUser = new User();
        UserRole userRole = new UserRole();

        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        GenericDao<UserRole> userRoleGenericDao = new GenericDao<>(UserRole.class);

        // Check to make sure user name is not already in use
        Integer anyUsersWithThisName = userGenericDao.getUser("userName", userName).size();
        if (anyUsersWithThisName != 0){
            messages.put("userName", " is already in use, please select a different user name");

        } else {
            setUpNewUser.setUserName(userName);
        }

        // Check to make sure passwords matched
        if(password.equals(password2)){
            setUpNewUser.setUserPassword(password);
        } else {
            messages.put("password", "Passwords did not match");
        }

        // Check to make sure Ensemble is not already signed up.
        Integer ensembleSignedUpAlready = userGenericDao.getUser("ensembleName", ensembleName).size();
        if (ensembleSignedUpAlready != 0){
            messages.put("ensembleName", ensembleName + " is already in use, please contact your members for the username and password");
        } else {
            setUpNewUser.setEnsembleName(ensembleName);
        }

        if (messages.isEmpty()) {
            messages.put("success", "Form successfully submitted!");
            userGenericDao.insert(setUpNewUser);

            userRole.setUserName(userName);
            userRole.setUserRole("ensemble");
            userRoleGenericDao.insert(userRole);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(req, resp);








    }


}
//https://www.youtube.com/watch?v=xg9A3q-fRyo