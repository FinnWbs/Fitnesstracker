package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrageService {

    @Autowired
    FrageRepository repo;

    public Frage save(Frage frage) {
        return repo.save(frage);
    }

    public Frage get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Frage> getAll() {
        Iterable<Frage> iterator = repo.findAll();
        List<Frage> fragen = new ArrayList<Frage>();
        for (Frage frage : iterator)  fragen.add(frage);
        return fragen;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Frage update(Long id, String frage, String antwort, int playerid) {
        Frage existingFrage = repo.findById(id).orElseThrow(() -> new RuntimeException("Frage nicht gefunden"));
        existingFrage.setFrage(frage);
        existingFrage.setAntwort(antwort);
        existingFrage.setPlayerid(playerid);
        return repo.save(existingFrage);
    }
}