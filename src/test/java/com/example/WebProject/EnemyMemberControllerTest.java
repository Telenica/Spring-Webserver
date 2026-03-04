package com.example.WebProject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import tools.jackson.databind.ObjectMapper;

import java.util.List;

//Testen des EnemyMemberController und dessen Posts für zufällige Gruppenzusammenstellung
@WebMvcTest(EnemyMemberController.class)
class EnemyMemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private EnemyService enemyService;

    @MockitoBean
    private EnemyGroupService enemyGroupService;

    //Post für Gruppenmitglieder testen
    @Test
    void testCreateMember() throws Exception {

        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblin);
        member.setCurrentHP(10);

        when(enemyService.memberfromTemplate(1L)).thenReturn(member);

        mockMvc.perform(post("/enemy-group-members/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentHP").value(10));
    }

    //Post für Gruppenerstellung testen
    @Test
    void testCreateGroup() throws Exception {
        
        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);
        Enemy ork = new Enemy("Ork", "Hill Ork", "Hills", 15);

        EnemyGroupMember m1 = new EnemyGroupMember();
        m1.setEnemyTemplate(goblin);
        m1.setCurrentHP(10);

        EnemyGroupMember m2 = new EnemyGroupMember();
        m2.setEnemyTemplate(ork);
        m2.setCurrentHP(15);

        when(enemyService.memberfromTemplate(1L)).thenReturn(m1);
        when(enemyService.memberfromTemplate(2L)).thenReturn(m2);

        mockMvc.perform(post("/enemy-group-members/group")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(List.of(1L, 2L))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    //allgemein Post testen
    @Test
    void testRandomGroupAll() throws Exception {

        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblin);
        member.setCurrentHP(12);

        when(enemyGroupService.createRandomGroupWithAll(3))
                .thenReturn(List.of(member, member, member));

        mockMvc.perform(post("/enemy-group-members/random/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    //Post für Biome testen
    @Test
    void testRandomGroupByBiomes() throws Exception {

        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblin);
        member.setCurrentHP(8);

        when(enemyGroupService.createRandomGroupByBiomes(2, List.of("Wald")))
                .thenReturn(List.of(member, member));

        mockMvc.perform(post("/enemy-group-members/random/biomes/2")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(List.of("Wald"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    //Post für Spezies testen
    @Test
    void testRandomGroupBySpecies() throws Exception {

        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblin);
        member.setCurrentHP(14);

        when(enemyGroupService.createRandomGroupBySpecies(1, List.of("Goblin")))
                .thenReturn(List.of(member));

        mockMvc.perform(post("/enemy-group-members/random/species/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(List.of("Goblin"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}