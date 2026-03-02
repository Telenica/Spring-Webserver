package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Unit-Tests für Feines-Logik
@SpringBootTest
public class EnemyServiceTest {
    @Test
    void testEnemyCreation() {
        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);

        assertEquals("Goblin", goblin.getSpecies());
        assertEquals("Forest Goblin", goblin.getSubSpecies());
        assertEquals("Wald", goblin.getBiom());
        assertEquals(10, goblin.getMaxHP());
    }
}
