package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrageService {

    @Autowired
    FrageRepository repo;

    public Game save(Game game) {
        return repo.save(game);
    }

    public Game get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Game> getAll() {
        Iterable<Game> iterator = repo.findAll();
        List<Game> fragen = new ArrayList<Game>();
        for (Game game : iterator)  fragen.add(game);
        return fragen;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Game update(Long id, String name, String playerid) {
        Game existingGame = repo.findById(id).orElseThrow(() -> new RuntimeException("Frage nicht gefunden"));
        existingGame.setName(name);
        existingGame.setPlayerid(playerid);
        return repo.save(existingGame);
    }
}