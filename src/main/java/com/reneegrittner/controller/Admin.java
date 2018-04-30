package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.AdminLogic;
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

@WebServlet(
        urlPatterns = {"/ensemble/admin"}
)
public class Admin extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private AdminLogic adminLogic = new AdminLogic();
    private String errorMessage = "";

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Arrived at the Admin servlet Do Get");
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        req.setAttribute("users", userGenericDao.getAllUsers());

        GenericDao<UserRole> userRoleGenericDao = new GenericDao<>(UserRole.class);
        req.setAttribute("userRoles", userRoleGenericDao.getAllUsers());

        req.setAttribute("errorMessage", errorMessage);

        logger.debug("All Users = " + userGenericDao.getAllUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/admin.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
            Submission types:
                1: Update User Information
                2: Update User Role
                3: Add New User Role
                4: Delete User
                5: Delete user role
         */
        GenericDao<UserRole> userRoleGenericDao = new GenericDao<>(UserRole.class);
        Integer submissionType = Integer.parseInt(req.getParameter("submissionType"));
        String userName;
        String userRole;
        Integer userId;

        boolean doesUserNameExist = adminLogic.doesUsernameExist(req.getParameter("userName"));

        if(doesUserNameExist == false) {


            User userToAddOrUpdate = adminLogic.createOrUpdateUserInformation(
                    req.getParameter("userName")
                    , req.getParameter("ensembleName")
                    , req.getParameter("userPassword")
                    , req.getParameter("userId"));

            switch (submissionType) {
                case 1:

//                userName = req.getParameter("userName");
//                String ensembleName = req.getParameter("ensembleName");
//                userId = Integer.parseInt(req.getParameter("userId"));
//                String userPass = req.getParameter("userPassword");
//
//
//                User userToUpdate = new User();
//
//                userToUpdate.setId(userId);
//                userToUpdate.setUserName(userName);
//                userToUpdate.setEnsembleName(ensembleName);
//                userToUpdate.setUserPassword(userPass);
//
                    GenericDao<User> userGenericDao = new GenericDao<>(User.class);


                    userGenericDao.saveOrUpdate(userToAddOrUpdate);

                    break;
                case 2:
                    userName = req.getParameter("update-role-userName");
                    userRole = req.getParameter("update-role-userRole");
                    userId = Integer.parseInt(req.getParameter("update-role-userRoleId"));

                    UserRole userRoleToUpdate = new UserRole();

                    userRoleToUpdate.setId(userId);
                    userRoleToUpdate.setUserName(userName);
                    userRoleToUpdate.setUserRole(userRole);


                    userRoleGenericDao.saveOrUpdate(userRoleToUpdate);

                    break;
                case 3:
                    userName = req.getParameter("new-role-userName");
                    userRole = req.getParameter("new-role-userRole");

                    UserRole newUserRoleToAdd = new UserRole();

                    newUserRoleToAdd.setUserName(userName);
                    newUserRoleToAdd.setUserRole(userRole);
                    logger.debug(newUserRoleToAdd);
                    userRoleGenericDao.insert(newUserRoleToAdd);

                    break;
            }
        } else {
            errorMessage = "This username already exists";
        }

        String url = "/concertPlanner/ensemble/admin";

        resp.sendRedirect(url);
    }
}
