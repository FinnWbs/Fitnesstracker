package htwberlin.webtech.game;

import htwberlin.webtech.spieler.Spieler;
import htwberlin.webtech.spieler.SpielerRepository;
import htwberlin.webtech.spieler.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repo;

    @Autowired
    SpielerService spielerService;

    @Autowired
    SpielerRepository spielerRepository;

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
    public void updateGameName(Long gameId, String newName) {
        Game game = repo.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
        game.setName(newName);
        repo.save(game);
    }

    public void updateCurrentQuestion(String currentQuestion, Long gameId, List<String> possibleAnswers, String givenSongName) {
        Game game = this.getGameById(gameId);
        game.setCurrentQuestion(currentQuestion);
        game.setPossibleAnswers(possibleAnswers);
        game.setGivenSongName(givenSongName);
        this.repo.save(game);
    }
}