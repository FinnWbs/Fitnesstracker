package htwberlin.webtech.spieler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpielerRepository extends CrudRepository<Spieler, Long> {
    Spieler getSpielerByPlayerName(String name);
}