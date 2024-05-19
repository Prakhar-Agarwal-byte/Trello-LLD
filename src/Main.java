import models.Privacy;
import services.*;

import java.util.UUID;

public class Main {
    private static final BoardService boardService = new BoardService();
    private static final TListService tListService = new TListService();
    private static final CardService cardService = new CardService();
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        UUID u1 = userService.createUser("Prakhar");
        UUID u2 = userService.createUser("Prachi");
        UUID u3 = userService.createUser("Shubhra");
        boardService.showAllBoards();
        UUID b1 = boardService.createBoard("work@tech");
        boardService.showBoard(b1);
        boardService.showAllBoards();
        boardService.updateBoardName(b1, "workat.tech");
        boardService.updateBoardPrivacy(b1, Privacy.PRIVATE);
        boardService.showBoard(b1);
        boardService.createBoard("workat");
        boardService.showAllBoards();
        boardService.addMember(b1, u1);
        boardService.addMember(b1, u2);
        boardService.addMember(b1, u3);
        boardService.removeMember(b1, u2);
        boardService.showBoard(b1);
        UUID b2 = boardService.createBoard("temp");
        boardService.deleteBoard(b2);
//        boardService.showBoard(b2);
        boardService.showAllBoards();
        UUID l1 = tListService.createList(b1, "Mock Interviews");
        tListService.showList(l1);
        tListService.updateTListName(l1, "Mock Interviews - Applied");
        tListService.showList(l1);
        UUID l2 = tListService.createList(b1, "Mock Interviews - Scheduled");
        boardService.showBoard(b1);
        UUID c1 = cardService.createCard(l1, "abcd@gmail.com");
        UUID c2 = cardService.createCard(l1, "abcda@gmail.com");
        tListService.showList(l1);
        cardService.updateCardName(c1, "abcde@gmail.com");
        cardService.updateCardDescription(c1, "At 7PM");
        tListService.showList(l1);
        cardService.assignCard(c2, u1);
        cardService.showCard(c2);
        cardService.moveCard(c2, l2);
        tListService.showList(l1);
        tListService.showList(l2);
        cardService.unassignCard(c2);
        cardService.showCard(c2);
        boardService.showAllBoards();
    }
}
