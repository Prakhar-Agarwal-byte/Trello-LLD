package exceptions;

public class UserNotMemberOfBoardException extends IllegalArgumentException{
    public UserNotMemberOfBoardException() {
        super("User is not a member of a board");
    }
}
