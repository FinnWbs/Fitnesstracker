package htwberlin.webtech.game;

import htwberlin.webtech.spieler.Spieler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repo;

    public Game createGame(Spieler spielErsteller, String gameName) {
        Game newGame = new Game();
        newGame.name = gameName;
        newGame.spieler = (List.of(spielErsteller));
        return repo.save(newGame);
    }

    public Game getGameById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Iterable<Game> listGames() {
       return this.repo.findAll();
    }

    public void deleteGame(Long id) {
        this.repo.deleteById(id);
    }

    public Game joinGame(Spieler spieler, Long gameId){
        Game game = this.getGameById(gameId);
        game.spieler.add(spieler);
        return this.repo.save(game);
    }
}