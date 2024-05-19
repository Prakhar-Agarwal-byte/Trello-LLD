package exceptions;

public class TListNotFoundException extends IllegalArgumentException {
    public TListNotFoundException() {
        super("TList does not exist");
    }
}
