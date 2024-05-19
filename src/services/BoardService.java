package services;

import daos.BoardDao;
import daos.BoardDaoImpl;
import daos.UserDao;
import daos.UserDaoImpl;
import models.Board;
import models.Privacy;
import models.User;

import java.util.List;
import java.util.UUID;

public class BoardService {
    private final BoardDao boardDao = new BoardDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public UUID createBoard(String name) {
        Board board = new Board(name);
        System.out.println(board.getId());
        return boardDao.insertBoard(board);
    }

    public void showBoard(UUID boardId) {
        Board board = boardDao.getBoard(boardId);
        System.out.println(board.toString());
    }

    public void showAllBoards() {
        List<Board> boards = boardDao.getAllBoards();
        for (Board board : boards) {
            System.out.println(board.toString());
        }
    }

    public void updateBoardName(UUID boardId, String name) {
        Board board = boardDao.getBoard(boardId);
        board.setName(name);
        boardDao.updateBoard(board);
    }

    public void updateBoardPrivacy(UUID boardId, Privacy privacy) {
        Board board = boardDao.getBoard(boardId);
        board.setPrivacy(privacy);
        boardDao.updateBoard(board);
    }

    public void addMember(UUID boardId, UUID userId) {
        Board board = boardDao.getBoard(boardId);
        User user = userDao.getUser(userId);
        board.getMembers().add(user);
        boardDao.updateBoard(board);
    }

    public void removeMember(UUID boardId, UUID userId) {
        Board board = boardDao.getBoard(boardId);
        User user = userDao.getUser(userId);
        board.getMembers().remove(user);
        boardDao.updateBoard(board);
    }

    public void deleteBoard(UUID boardId) {
        boardDao.deleteBoard(boardId);
    }
}
