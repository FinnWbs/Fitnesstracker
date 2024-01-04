package htwberlin.webtech;

import jakarta.persistence.*;

@Entity
    public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String playerid;
    public Game() {}

    public Game(String name, String playerid) {
        this.name = name;
        this.playerid = playerid;
    }
    public String getName() {
        return name;
    }

    public void setName(String frage) {
        this.name = frage;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }
}