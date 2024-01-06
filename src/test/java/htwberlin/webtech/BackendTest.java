package htwberlin.webtech;

import htwberlin.webtech.game.Game;
import htwberlin.webtech.game.GameRepository;
import htwberlin.webtech.game.GameService;
import htwberlin.webtech.spieler.Spieler;
import htwberlin.webtech.spieler.SpielerRepository;
import htwberlin.webtech.spieler.SpielerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class BackendTest {


    @Autowired
    private SpielerService service;

    @MockBean
    private SpielerRepository repo;


    @Test
    void testGet() {
        var t1 = new Spieler("Fi nn");
        doReturn(Optional.of(t1)).when(repo).findById(1L);

        Spieler actual = service.get(1L);

        Assertions.assertEquals(actual.getPlayerName(), "Fi nn");
    }
}
