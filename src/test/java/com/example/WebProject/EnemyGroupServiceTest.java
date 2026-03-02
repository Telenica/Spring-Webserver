package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Unit-Tests für Gruppenlogik
@SpringBootTest
public class EnemyGroupServiceTest {
    private Enemy goblinTemplate;

    @BeforeEach
    void setup() {
        goblinTemplate = new Enemy("Goblin", "Forest Goblin", "Wald", 10);
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
        member.setCurrentHP(4); // weniger als maxHP / 2

        assertEquals(Status.ANGESCHLAGEN, member.getStatus());
    }

    @Test
    void testStatusDead() {
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(goblinTemplate);
        member.setCurrentHP(0);

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
}
