package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.WebProject.Enemys.EnemyGroupMember;
import com.example.WebProject.Enemys.EnemyTemplate;
import com.example.WebProject.Enumzusätze.Status;
import com.example.WebProject.Enumzusätze.Systeme;
import com.example.WebProject.Homebrew.HomeCondition;
import com.example.WebProject.Homebrew.HomeEnemy;

// Unit-Tests für Gruppenlogik
@SpringBootTest
public class EnemyGroupServiceTest {
    private EnemyTemplate goblinTemplate;

    @BeforeEach
    void setup() {
        goblinTemplate = new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5);
    }

    @Test
    void testTemplate() {
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblinTemplate);

        assertEquals("Goblin", member.getEnemyTemplate().getSpecies());
        assertEquals("Forest Goblin", member.getEnemyTemplate().getSubSpecies());
        assertEquals("Wald", member.getEnemyTemplate().getBiom());
        assertEquals(10, member.getEnemyTemplate().getMaxHP());
    }

    @Test
    void testCurrentHpAndStatusHealthy() {
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblinTemplate);
        member.setCurrentHP(goblinTemplate.getMaxHP());

        assertEquals(10, member.getCurrentHP());
        assertEquals(Status.GESUND, member.getStatus());
    }

    @Test
    void testStatusWounded() {
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblinTemplate);
        member.setCurrentHP(6); //über Hälfte maxHP

        assertEquals(6, member.getCurrentHP());
        assertEquals(Status.GESUND, member.getStatus());
        
        member.setCurrentHP(5); // Hälfte maxHP

        assertEquals(5, member.getCurrentHP());
        assertEquals(Status.ANGESCHLAGEN, member.getStatus());
        
        member.setCurrentHP(4); // weniger als Hälfte maxHP

        assertEquals(4, member.getCurrentHP());
        assertEquals(Status.ANGESCHLAGEN, member.getStatus());
    }

    @Test
    void testStatusDead() {
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblinTemplate);
        member.setCurrentHP(0);

        assertEquals(0, member.getCurrentHP());
        assertEquals(Status.BESIEGT, member.getStatus());
    }

    @Test
    void testCurrentHpBounds() {
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblinTemplate);

        member.setCurrentHP(-5);
        assertEquals(0, member.getCurrentHP());

        member.setCurrentHP(50);
        assertEquals(goblinTemplate.getMaxHP(), member.getCurrentHP());
    }

    @Test
    void testConditions() {
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblinTemplate);

        assertTrue(member.getConditions().isEmpty());

        member.addCondition(HomeCondition.FURCHT);
        member.addCondition(HomeCondition.BETAEUBT);

        assertTrue(member.getConditions().contains(HomeCondition.FURCHT));
        assertTrue(member.getConditions().contains(HomeCondition.BETAEUBT));
        assertEquals(2, member.getConditions().size());

        member.removeCondition(HomeCondition.BETAEUBT);

        assertTrue(member.getConditions().contains(HomeCondition.FURCHT));
        assertEquals(1, member.getConditions().size());

        member.removeCondition(HomeCondition.FURCHT);

        assertTrue(member.getConditions().isEmpty());
        assertEquals(0, member.getConditions().size());

        member.addCondition(HomeCondition.FURCHT);
        member.addCondition(HomeCondition.FURCHT);

        assertEquals(1, member.getConditions().size());
    }

}
