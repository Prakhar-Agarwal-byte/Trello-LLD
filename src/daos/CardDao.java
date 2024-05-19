package daos;

import models.Card;

import java.util.List;
import java.util.UUID;

public interface CardDao {
    UUID insertCard(Card card);
    Card getCard(UUID id);
    List<Card> getAllCards();
    void updateCard(Card card);
    void deleteCard(UUID id);
}
