package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.User;
import com.reneegrittner.persistence.GenericDao;

public class AdminLogic {
    private GenericDao<User> userGenericDao = new GenericDao<>(User.class);

    public boolean doesUsernameExist(String userName){
        boolean doesUserExist = true;



        return doesUserExist;
    }

    public User createOrUpdateUserInformation(String userName, String ensembleName, String userPass, String userIdString){
        User user;
        boolean doesUsernameExist;
        if(userIdString == null){
            user = new User();

        } else {
            user = getUserObjectFromDb(Integer.parseInt(userIdString));
        }

        user.setUserName(userName);
        user.setUserPassword(userPass);
        user.setEnsembleName(ensembleName);

        return user;

    }

    private User getUserObjectFromDb(int id) {
        User user = userGenericDao.getById(id);
        return user;
    }
}
