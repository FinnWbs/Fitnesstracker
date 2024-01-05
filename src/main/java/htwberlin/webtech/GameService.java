package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    FrageRepository repo;

    public Game save(Game game) {
        return repo.save(game);
    }

    public Game get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Game> getAll() {
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

//    public Game join(String ){
//
//    }
}