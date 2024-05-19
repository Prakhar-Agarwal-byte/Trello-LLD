package models;

import java.util.UUID;

public class Card {
    private final UUID id;
    private String name;
    private String description;
    private User assignedUser;
    private TList tList;

    public Card(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = "";
        this.assignedUser = null;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public TList gettList() {
        return tList;
    }

    public void settList(TList tList) {
        this.tList = tList;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assignedUser=" + assignedUser +
                '}';
    }
}
