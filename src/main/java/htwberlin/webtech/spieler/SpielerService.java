package htwberlin.webtech.spieler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpielerService {

    @Autowired
    SpielerRepository repo;

    public Spieler createSpieler(String spielerName) {
        Spieler newSpieler = new Spieler(spielerName);
        return this.repo.save(newSpieler);
    }

    public Spieler getSpielerById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Spieler getSpielerByName(String spielerName) {
        return this.repo.getSpielerByPlayerName(spielerName);
    }

    public Spieler updatePunktzahl(Long id, Integer punktzahl){
        Spieler spieler = this.repo.findById(id).orElseThrow(() -> new RuntimeException("Spieler nicht gefunden"));
        spieler.setPunktzahl(punktzahl);
        return this.repo.save(spieler);
    }

    public Spieler updateSpieler(Spieler spieler) {
        return this.repo.save(spieler);
    }

    public void increaseScore(Long playerId, int newPunktzahl) {
        Spieler player = getSpielerById(playerId);
        player.setPunktzahl(newPunktzahl);
        repo.save(player);
    }

    public void increaseScoreByPlayerName(String Spielername) {
        Spieler player = getSpielerByName(Spielername);
        player.setPunktzahl(player.punktzahl+1);
        repo.save(player);
    }


    /*public List<Game> getAll() {
        return Streamable.of(this.repo.findAll()).toList();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Game update(Long id, String name, List<Spieler> playerid) {
        Game existingGame = repo.findById(id).orElseThrow(() -> new RuntimeException("Frage nicht gefunden"));
        existingGame.setName(name);
        existingGame.setPlayers(playerid);
        return repo.save(existingGame);
    }
     */

//    public Game join(String ){
//
//    }
}