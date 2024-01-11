package htwberlin.webtech.game;

import htwberlin.webtech.spieler.Spieler;
import htwberlin.webtech.spieler.SpielerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService service;

    @Autowired
    SpielerService spielerService;


    Logger logger = LoggerFactory.getLogger(GameController.class);

    @PostMapping()
    public Game createGame(@RequestBody CreateGameInput createGameInput) {
        System.out.println(createGameInput.gameCreatorName);
        System.out.println(createGameInput.gameName);
        Spieler spielErsteller = this.spielerService.createSpieler(createGameInput.gameCreatorName);
        return this.service.createGame(spielErsteller, createGameInput.gameName);
    }

    @PostMapping("/join")
    public Game joinGame(@RequestBody JoinGameInput joinGameInput){
        Spieler newPlayer = this.spielerService.createSpieler(joinGameInput.spielerName);
        return this.service.joinGame(newPlayer, joinGameInput.gameId);
    }

    @GetMapping()
    public Iterable<Game> listGames() {
        return this.service.listGames();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long gameID = Long.parseLong(id);
        return service.getGameById(gameID);
    }

    @GetMapping("/player/{id}")
    public Spieler getSpieler(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long SpielerID = Long.parseLong(id);
        return spielerService.getSpielerById(SpielerID);
    }
    @PutMapping("/updateName/{id}")
    public ResponseEntity<String> updateGameName(@PathVariable Long id, @RequestBody UpdateGameNameInput input) {
        service.updateGameName(id, input.getName());
        return ResponseEntity.ok("Game name updated successfully");
    }


    @PostMapping("/increaseScore/{id}")
    public ResponseEntity<String> increaseScore(@PathVariable Long id, @RequestBody UpdatePunktzahlInput input) {
        service.increaseScore(id, input.getPunktzahl());
        return ResponseEntity.ok("Score increased successfully");
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        this.service.deleteGame(id);
    }

}