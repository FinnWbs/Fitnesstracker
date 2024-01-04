package htwberlin.webtech;

import jakarta.persistence.*;

@Entity
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerid;
    public Spieler() {}

    public Spieler(String playerid) {
        this.playerid = playerid;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }
}