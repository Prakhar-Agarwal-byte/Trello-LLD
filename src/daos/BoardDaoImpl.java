package daos;

import data.Db;
import exceptions.BoardNotFoundException;
import models.Board;

import java.util.*;

public class BoardDaoImpl implements BoardDao{
    private final Db db = Db.getInstance();

    @Override
    public UUID insertBoard(Board board) {
        db.boards.put(board.getId(), board);
        return board.getId();
    }

    @Override
    public Board getBoard(UUID id) {
        Board board = db.boards.get(id);
        if (board == null) throw new BoardNotFoundException();
        return board;
    }

    @Override
    public List<Board> getAllBoards() {
        return new ArrayList<>(db.boards.values());
    }

    @Override
    public void updateBoard(Board newBoard) {
        Board oldBoard = db.boards.get(newBoard.getId());
        if (oldBoard == null) throw new BoardNotFoundException();
        db.boards.put(newBoard.getId(), newBoard);
    }

    @Override
    public void deleteBoard(UUID id) {
        Board board = db.boards.get(id);
        if (board == null) throw new BoardNotFoundException();
        db.boards.remove(id);
    }
}
