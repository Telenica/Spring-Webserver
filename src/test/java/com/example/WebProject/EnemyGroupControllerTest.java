package com.example.WebProject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

// Rest-API Tests
@WebMvcTest(EnemyController.class)
public class EnemyGroupControllerTest {
     @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EnemyRepository repository;

    @MockitoBean
    private EnemyModelAssembler assembler;

    @Test
    void testGetAllEnemies() throws Exception {
        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);

        // Repository liefert 1 Enemy
        when(repository.findAll()).thenReturn(List.of(goblin));

        // Assembler liefert ein valides EntityModel
        when(assembler.toModel(goblin)).thenReturn(EntityModel.of(goblin));

        mockMvc.perform(get("/enemys"))
               .andExpect(status().isOk()); // Prüft HTTP 200
    }
}
