package models;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {
    private final UUID id;
    private String name;
    private Privacy privacy;
    private String url;
    private List<User> members;
    private List<TList> lists;

    public Board(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.privacy = Privacy.PUBLIC;
        this.url = Utils.getUrl("board", id);
        this.members = new ArrayList<>();
        this.lists = new ArrayList<>();
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

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<TList> getLists() {
        return lists;
    }

    public void setLists(List<TList> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privacy=" + privacy +
                ", url='" + url + '\'' +
                ", members=" + members +
                ", lists=" + lists +
                '}';
    }
}
