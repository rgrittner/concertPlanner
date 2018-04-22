package com.reneegrittner.controller;


import com.reneegrittner.entity.User;
import com.reneegrittner.entity.UserRole;
import com.reneegrittner.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ensemble/admin-roles"}
)
public class AdminUserRole extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("role-userName");
        String userRole = req.getParameter("userRole");
        Integer userId = Integer.parseInt(req.getParameter("userId"));


        UserRole userToUpdate = new UserRole();

        userToUpdate.setId(userId);
        userToUpdate.setUserName(userName);
        userToUpdate.setUserRole(userRole);


        GenericDao<UserRole> userGenericDao = new GenericDao<>(UserRole.class);


        userGenericDao.saveOrUpdate(userToUpdate);

        String url = "/concertPlanner/ensemble/admin";

        resp.sendRedirect(url);
    }
}
