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

    @PostMapping("/frage")
    public Frage createThing(@RequestBody Frage frage) {
        return service.save(frage);
    }

    @GetMapping("/frage/{id}")
    public Frage getThing(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long frageID = Long.parseLong(id);
        return service.get(frageID);
    }

    @GetMapping("/frage")
    public List<Frage> getAllThings() {
        return service.getAll();
    }

}