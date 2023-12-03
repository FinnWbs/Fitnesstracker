package htwberlin.webtech;

import jakarta.persistence.*;

@Entity
public class Frage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String frage;
    private String antwort;
    private int playerid;
    public Frage() {}

    public Frage(String frage, String antwort, int playerid) {
        this.frage = frage;
        this.antwort = antwort;
        this.playerid = playerid;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }
    public String getAntwort() {
        return antwort;
    }
    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Frage)) return false;

        Frage frage = (Frage) o;

        if (getAntwort() != frage.getAntwort()) return false;
        if (getId() != null ? !getId().equals(frage.getId()) : frage.getId() != null) return false;
        return getFrage() != null ? getFrage().equals(frage.getFrage()) : frage.getFrage() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFrage() != null ? getFrage().hashCode() : 0);
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", Frage='" + frage + '\'' +
                ", Antwort=" + antwort +
                '}';
    }
}