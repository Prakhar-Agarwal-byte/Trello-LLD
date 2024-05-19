package services;

import daos.BoardDao;
import daos.BoardDaoImpl;
import daos.TDaoListImpl;
import daos.TListDao;
import models.Board;
import models.Card;
import models.TList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TListService {
    private final BoardDao boardDao = new BoardDaoImpl();
    private final TListDao tListDao = new TDaoListImpl();

    public UUID createList(UUID boardId, String name) {
        Board board = boardDao.getBoard(boardId);
        TList tList = new TList(board, name);
        board.getLists().add(tList);
        tListDao.insertTList(tList);
        System.out.println(tList.getId());
        return tList.getId();
    }

    public void showList(UUID listId) {
        System.out.println(tListDao.getTList(listId).toString());
    }

    public void updateTListName(UUID listId, String name) {
        TList tList = tListDao.getTList(listId);
        tList.setName(name);
    }

    public void deleteTList(UUID listId) {
        TList tList = tListDao.getTList(listId);
        Board board = tList.getBoard();
        board.getLists().remove(tList);
        tListDao.deleteTList(listId);
    }

    public UUID cloneTList(UUID listId) {
        TList tList = tListDao.getTList(listId);
        TList clonedTList = new TList(tList.getBoard(), tList.getName());
        Board board = tList.getBoard();
        List<Card> cards = tList.getCards();
        List<Card> clonedCards = cards.stream().map(c -> {
            Card cc = new Card(c.getName());
            cc.setDescription(c.getDescription());
            cc.setAssignedUser(c.getAssignedUser());
            cc.settList(clonedTList);
            return cc;
        }).collect(Collectors.toList());
        clonedTList.setCards(clonedCards);
        board.getLists().add(clonedTList);
        tListDao.insertTList(clonedTList);
        System.out.println(clonedTList.getId());
        return clonedTList.getId();
    }

    public void deleteAllCards(UUID listId) {
        TList tList = tListDao.getTList(listId);
        List<Card> cards = tList.getCards();
        cards.removeAll(cards);
        for (Card card : cards) {
            card.settList(null);
        }
    }
}
