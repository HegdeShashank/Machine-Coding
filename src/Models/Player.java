package Models;

import java.util.UUID;

public class Player {
    UUID id;
    private final String name;
    private int position;

    public Player(String name) {
        id = new UUID(30, 1);
        this.name = name;
        position = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }
}
