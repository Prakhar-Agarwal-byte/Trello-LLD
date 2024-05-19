package data;

import models.Board;
import models.Card;
import models.TList;
import models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Db {
    public Map<UUID, Board> boards = new HashMap<>();
    public Map<UUID, User> users = new HashMap<>();
    public Map<UUID, TList> tLists = new HashMap<>();
    public Map<UUID, Card> cards = new HashMap<>();
    private static volatile Db INSTANCE;

    private Db() {}

    public static Db getInstance() {
        if (INSTANCE == null) {
            synchronized (Db.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Db();
                }
            }
        }
        return INSTANCE;
    }
}
