package htwberlin.webtech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FrageController {

    @Autowired
    FrageService service;

    Logger logger = LoggerFactory.getLogger(FrageController.class);

    @PostMapping("/game")
    public Game createGame(@RequestBody Game game) {
        return service.save(game);
    }

    @GetMapping("/game/{id}")
    public Game getFrage(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long frageID = Long.parseLong(id);
        return service.get(frageID);
    }

    @GetMapping("/game")
    public List<Game> getAllFragen() {
        return service.getAll();
    }

}