package services;

import daos.*;
import exceptions.UserNotMemberOfBoardException;
import models.Board;
import models.Card;
import models.TList;
import models.User;

import java.util.UUID;

public class CardService {
    private final BoardDao boardDao = new BoardDaoImpl();
    private final TListDao tListDao = new TDaoListImpl();
    private final CardDao cardDao = new CardDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public UUID createCard(UUID tListId, String name) {
        Card card = new Card(name);
        TList tList =tListDao.getTList(tListId);
        tList.getCards().add(card);
        tListDao.updateTList(tList);
        card.settList(tList);
        cardDao.insertCard(card);
        System.out.println(card.getId());
        return card.getId();
    }

    public void showCard(UUID cardId) {
        System.out.println(cardDao.getCard(cardId).toString());
    }

    public void updateCardName(UUID cardId, String name) {
        Card card = cardDao.getCard(cardId);
        card.setName(name);
        cardDao.updateCard(card);
    }

    public void updateCardDescription(UUID cardId, String description) {
        Card card = cardDao.getCard(cardId);
        card.setDescription(description);
        cardDao.updateCard(card);
    }

    public void assignCard(UUID cardId, UUID userId) {
        Card card = cardDao.getCard(cardId);
        User user = userDao.getUser(userId);
        boolean isUserMemberOfBoard = card.gettList().getBoard().getMembers().stream().anyMatch(u -> u.getId() == user.getId());
        if (!isUserMemberOfBoard) {throw new UserNotMemberOfBoardException();}
        card.setAssignedUser(user);
        cardDao.updateCard(card);
    }

    public void unassignCard(UUID cardId) {
        Card card = cardDao.getCard(cardId);
        card.setAssignedUser(null);
        cardDao.updateCard(card);
    }

    public void moveCard(UUID cardId, UUID tListId) {
        Card card = cardDao.getCard(cardId);
        TList tList = card.gettList();
        tList.getCards().remove(card);
        TList newTList = tListDao.getTList(tListId);
        newTList.getCards().add(card);
        card.settList(newTList);
        tListDao.updateTList(newTList);
    }

    public void deleteCard(UUID cardId) {
        Card card = cardDao.getCard(cardId);
        TList tList = card.gettList();
        tList.getCards().remove(card);
        cardDao.deleteCard(cardId);
    }
}
