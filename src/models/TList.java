package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TList {
    private final UUID id;
    private String name;
    private List<Card> cards;
    private Board board;

    public TList(Board board, String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cards = new ArrayList<>();
        this.board = board;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "TList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
