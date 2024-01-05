package htwberlin.webtech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService service;

    Logger logger = LoggerFactory.getLogger(GameController.class);

    @PostMapping()
    public Game createGame(@RequestBody Game game) {
        return this.service.save(game);
    }

    @GetMapping()
    public List<Game> getAllFragen() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Game getFrage(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long gameID = Long.parseLong(id);
        return service.get(gameID);
    }

}