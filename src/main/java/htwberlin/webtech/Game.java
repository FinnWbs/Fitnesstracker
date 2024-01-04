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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;

        Game game = (Game) o;

        if (getId() != null ? !getId().equals(game.getId()) : game.getId() != null) return false;
        return getName() != null ? getName().equals(game.getName()) : game.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", Frage='" + name + '\'' +
                '}';
    }
}