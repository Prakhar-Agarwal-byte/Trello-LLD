package exceptions;

public class CardNotFoundException extends IllegalArgumentException{
    public CardNotFoundException(){
        super("Card not found");
    }
}
