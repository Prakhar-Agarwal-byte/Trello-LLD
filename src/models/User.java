package models;

import java.util.UUID;

public class User {
    private final UUID id;
    private String name;
    private String email;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
