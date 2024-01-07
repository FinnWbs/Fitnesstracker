package htwberlin.webtech;

import htwberlin.webtech.game.Game;
import htwberlin.webtech.game.GameService;
import htwberlin.webtech.spieler.Spieler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Test
    public void testGetGame() throws Exception {
        Spieler spielErsteller = new Spieler("Player1");
        Game mockGame = new Game("TestGame", Collections.singletonList(spielErsteller));
        Mockito.when(gameService.getGameById(Mockito.anyLong())).thenReturn(mockGame);

        mockMvc.perform(MockMvcRequestBuilders.get("/game/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("TestGame"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.spieler[0].name").value("Player1"));
    }
}