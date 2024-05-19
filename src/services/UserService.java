package services;

import daos.UserDao;
import daos.UserDaoImpl;
import models.User;

import java.util.UUID;

public class UserService {
    private final UserDao userDao = new UserDaoImpl();

    public UUID createUser(String name) {
        User user = new User(name);
        System.out.println(user.getId());
        return userDao.insertUser(user);
    }

    public void showUser(UUID userId) {
        User user = userDao.getUser(userId);
        System.out.println(user.toString());
    }

    public void updateUserName(UUID userId, String name) {
        User user = userDao.getUser(userId);
        user.setName(name);
        userDao.updateUser(user);
    }

    public void deleteUser(UUID userId) {
        userDao.deleteUser(userId);
    }
}
