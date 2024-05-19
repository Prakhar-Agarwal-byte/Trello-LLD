package daos;

import models.Board;

import java.util.List;
import java.util.UUID;

public interface BoardDao {
    UUID insertBoard(Board board);
    Board getBoard(UUID id);
    List<Board> getAllBoards();
    void updateBoard(Board board);
    void deleteBoard(UUID id);

}
