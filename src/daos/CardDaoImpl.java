package daos;

import data.Db;
import exceptions.CardNotFoundException;
import models.Card;

import java.util.List;
import java.util.UUID;

public class CardDaoImpl implements CardDao{
    private final Db db = Db.getInstance();

    @Override
    public UUID insertCard(Card card) {
        db.cards.put(card.getId(), card);
        return card.getId();
    }

    @Override
    public Card getCard(UUID id) {
        Card card = db.cards.get(id);
        if (card == null) throw new CardNotFoundException();
        return card;
    }

    @Override
    public List<Card> getAllCards() {
        return (List<Card>) db.cards.values();
    }

    @Override
    public void updateCard(Card newCard) {
        Card oldCard = db.cards.get(newCard.getId());
        if (oldCard == null) throw new CardNotFoundException();
        db.cards.put(newCard.getId(), newCard);
    }

    @Override
    public void deleteCard(UUID id) {
        Card card = db.cards.get(id);
        if (card == null) throw new CardNotFoundException();
        db.cards.remove(id);
    }
}
