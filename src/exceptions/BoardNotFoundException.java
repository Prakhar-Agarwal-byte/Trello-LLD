package exceptions;

public class BoardNotFoundException extends IllegalArgumentException{
    public BoardNotFoundException() {
        super("Board not found");
    }
}
