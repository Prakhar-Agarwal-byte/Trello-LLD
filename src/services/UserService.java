package services;

import daos.CardDao;
import daos.CardDaoImpl;
import daos.UserDao;
import daos.UserDaoImpl;
import models.Card;
import models.User;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {
    private final UserDao userDao = new UserDaoImpl();
    private final CardDao cardDao = new CardDaoImpl();

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
    }

    public void deleteUser(UUID userId) {
        userDao.deleteUser(userId);
    }

    public List<Card> findAllAssignedCards(UUID userId) {
        User user = userDao.getUser(userId);
        return cardDao.getAllCards().stream().filter(c -> c.getAssignedUser().getId() == user.getId()).collect(Collectors.toList());
    }
}
