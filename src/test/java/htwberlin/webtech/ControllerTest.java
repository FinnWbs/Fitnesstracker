package htwberlin.webtech;

import htwberlin.webtech.game.Game;
import htwberlin.webtech.game.GameController;
import htwberlin.webtech.game.GameRepository;
import htwberlin.webtech.game.GameService;
import htwberlin.webtech.spieler.Spieler;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService service;

    @Test
    public void testGetController() throws Exception {
        Spieler player = new Spieler("Fi nn");
        List<Spieler> list = new ArrayList<>();
        list.add(player);

        Game game = new Game("Erstes Game", list);
        when(service.getGameById(1L)).thenReturn(game);

        String exp = "{\"id\":1,\"name\":\"Erstes Game\",\"spieler\":[{\"id\":1,\"playerName\":\"Fi nn\"}]}";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/game/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(exp)));
    }

}
