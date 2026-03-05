package com.example.WebProject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

// Rest-API Tests von EnemyController
@WebMvcTest(EnemyController.class)
public class EnemyGroupControllerTest {
     @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private EnemyRepository repository;

    @MockitoBean
    private EnemyModelAssembler assembler;

    //Getter für Alle testen
    @Test
    void testGetAllEnemies() throws Exception {
        Enemy goblin = new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5);

        // Repository liefert 1 Enemy
        when(repository.findAll()).thenReturn(List.of(goblin));

        // Assembler liefert ein valides EntityModel
        when(assembler.toModel(goblin)).thenReturn(EntityModel.of(goblin));

        mockMvc.perform(get("/enemys")).andExpect(status().isOk()); // Prüft HTTP 200
    }

    //Getter für eine ID testen
    @Test
    void testGetOneEnemy() throws Exception {

        Enemy goblin = new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5);

        when(repository.findById(1L)).thenReturn(Optional.of(goblin));
        when(assembler.toModel(goblin)).thenReturn(EntityModel.of(goblin));

        mockMvc.perform(get("/enemys/1")).andExpect(status().isOk()); // Prüft HTTP 200
    }

    //Post für Feinde testen
    @Test
    void testCreateEnemy() throws Exception {

        Enemy goblin = new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5);
        EntityModel<Enemy> model = EntityModel.of(goblin);
        model.add(Link.of("http://localhost/enemys/1").withSelfRel());

        when(repository.save(any(Enemy.class))).thenReturn(goblin);
        when(assembler.toModel(goblin)).thenReturn(model);

        mockMvc.perform(post("/enemys").contentType("application/json").content(objectMapper.writeValueAsString(goblin)))
        .andExpect(status().isCreated()); 
    }

    //Put für Feinde testen
    @Test
    void testReplaceEnemy() throws Exception {

        Enemy existing = new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5);
        Enemy updated = new HomeEnemy("Orc", "Hill Orc", "Berge", 20, Systeme.HOMEBREW, 50, 20);

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(Enemy.class))).thenReturn(updated);

        EntityModel<Enemy> model = EntityModel.of(updated);
        model.add(Link.of("http://localhost/enemys/1").withSelfRel());

        when(assembler.toModel(updated)).thenReturn(model);

        mockMvc.perform(put("/enemys/1").contentType("application/json").content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isCreated()); 
    }

    //Delete für Feinde testen
    @Test
    void testDeleteEnemy() throws Exception {

        doNothing().when(repository).deleteById(1L);

        mockMvc.perform(delete("/enemys/1")).andExpect(status().isNoContent());
    }
}
