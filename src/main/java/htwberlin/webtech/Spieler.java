package htwberlin.webtech;

import jakarta.persistence.*;

@Entity
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String playerName;
    public Spieler() {}

    public Spieler(String playerName) {
        this.playerName = playerName;
    }
}