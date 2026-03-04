package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

// testen von laden und speichern von Feinden
@SpringBootTest
@Transactional // rollt DB-Änderungen nach jedem Test zurück
public class EnemyGroupServiceDbTest {

    @Autowired
    private EnemyRepository enemyRepository;

    @Autowired
    private EnemyGroupMemberRepository memberRepository;

    @Autowired
    private EnemyService enemyService;

    private Enemy goblinTemplate;
    private Enemy wolfTemplate;

    @BeforeEach
    void setup() {
        goblinTemplate = enemyRepository.save(new Enemy("Goblin", "Forest Goblin", "Wald", 10));
        wolfTemplate = enemyRepository.save(new Enemy("Wolf", "Forest Wolf", "Wald", 15));
    }

    //Überprüfen ob Gruppenmitglied mit Status und HP gespeichert ist
    @Test
    void testMemberPersistence() {
        EnemyGroupMember member = enemyService.memberfromTemplate(goblinTemplate.getId());

        // Prüfen, dass es in DB gespeichert wurde
        EnemyGroupMember saved = memberRepository.findById(member.getId()).orElse(null);
        assertNotNull(saved);
        assertEquals(goblinTemplate.getId(), saved.getEnemyTemplate().getId());

        // Status und HP korrekt
        assertEquals(Status.GESUND, saved.getStatus());
        assertEquals(goblinTemplate.getMaxHP(), saved.getCurrentHP());

        // Conditions leer
        assertTrue(saved.getConditions().isEmpty());
    }

    //Test zur Gruppenerstellung
    @Test
    void testCreateGroupPersistence() {
        List<Long> ids = List.of(goblinTemplate.getId(), wolfTemplate.getId());
        List<EnemyGroupMember> group = enemyService.createGroup(ids);

        assertEquals(2, group.size());

        // Prüfen, dass beide Mitglieder in DB sind
        for (EnemyGroupMember member : group) {
            EnemyGroupMember saved = memberRepository.findById(member.getId()).orElse(null);
            assertNotNull(saved);
            assertEquals(Status.GESUND, saved.getStatus());
            assertTrue(saved.getConditions().isEmpty());
        }

        // Prüfen, dass richtige Templates zugeordnet ist
        assertTrue(group.stream().anyMatch(m -> m.getEnemyTemplate().getSpecies().equals("Goblin")));
        assertTrue(group.stream().anyMatch(m -> m.getEnemyTemplate().getSpecies().equals("Wolf")));
    }

    //Test zur Speicherung des Zustands eines Gruppenmitglieds
    @Test
    void testAddConditionsPersistence() {
        EnemyGroupMember member = enemyService.memberfromTemplate(goblinTemplate.getId());

        member.addCondition(Condition.FURCHT);
        member.addCondition(Condition.BETAEUBT);

        // Nach speichern erneut laden
        EnemyGroupMember saved = memberRepository.findById(member.getId()).orElseThrow();
        assertTrue(saved.getConditions().contains(Condition.FURCHT));
        assertTrue(saved.getConditions().contains(Condition.BETAEUBT));
    }
}