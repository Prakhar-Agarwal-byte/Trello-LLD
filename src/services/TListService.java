package services;

import daos.BoardDao;
import daos.BoardDaoImpl;
import daos.TDaoListImpl;
import daos.TListDao;
import models.Board;
import models.TList;

import java.util.UUID;

public class TListService {
    private final BoardDao boardDao = new BoardDaoImpl();
    private final TListDao tListDao = new TDaoListImpl();

    public UUID createList(UUID boardId, String name) {
        Board board = boardDao.getBoard(boardId);
        TList tList = new TList(board, name);
        board.getLists().add(tList);
        boardDao.updateBoard(board);
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
        tListDao.updateTList(tList);
    }

    public void deleteTList(UUID listId) {
        TList tList = tListDao.getTList(listId);
        Board board = tList.getBoard();
        board.getLists().remove(tList);
        tListDao.deleteTList(listId);
    }

}
