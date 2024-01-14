package htwberlin.webtech.spieler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import htwberlin.webtech.game.Game;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String playerName;
    public Integer punktzahl;
    @ManyToOne
    @JoinColumn
    private Game game;




    public Spieler() {}

    public Spieler(String playerName) {
        this.playerName = playerName;
        this.punktzahl = 0;
    }

    public Integer getPunktzahl() {
        return punktzahl;
    }

    public void setPunktzahl(Integer punktzahl) {
        this.punktzahl = punktzahl;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}