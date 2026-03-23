package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.Enemys.EnemyGroupMember;
import com.example.WebProject.Enemys.EnemyTemplate;
import com.example.WebProject.Enumzusätze.Status;
import com.example.WebProject.Enumzusätze.Systeme;
import com.example.WebProject.Homebrew.HomeCondition;
import com.example.WebProject.Homebrew.HomeEnemy;
import com.example.WebProject.Repository.EnemyGroupMemberRepository;
import com.example.WebProject.Repository.EnemyRepository;
import com.example.WebProject.Service.EnemyService;

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

    private EnemyTemplate goblinTemplate;
    private EnemyTemplate wolfTemplate;

    @BeforeEach
    void setup() {
        goblinTemplate = enemyRepository.save(new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5));
        wolfTemplate = enemyRepository.save(new HomeEnemy("Wolf", "Forest Wolf", "Wald", 15, Systeme.HOMEBREW, 20,10));
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

        member.addCondition(HomeCondition.FURCHT);
        member.addCondition(HomeCondition.BETAEUBT);

        // Nach speichern erneut laden
        EnemyGroupMember saved = memberRepository.findById(member.getId()).orElseThrow();
        assertTrue(saved.getConditions().contains(HomeCondition.FURCHT));
        assertTrue(saved.getConditions().contains(HomeCondition.BETAEUBT));
    }
}