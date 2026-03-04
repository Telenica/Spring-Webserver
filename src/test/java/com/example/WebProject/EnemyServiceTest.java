package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Unit-Tests für Feines-Logik
@SpringBootTest
public class EnemyServiceTest {

    private Enemy goblin;

    @BeforeEach
    void setup() {
        goblin = new Enemy("Goblin", "Forest Goblin", "Forest", 10);
    }

    @Test
    void testEnemyCreation() { 
        assertEquals("Goblin", goblin.getSpecies());
        assertEquals("Forest Goblin", goblin.getSubSpecies());
        assertEquals("Forest", goblin.getBiom());
        assertEquals(10, goblin.getMaxHP());
    }

    @Test
    void testEnemyGetterSetter() {
        goblin.setSpecies("Wolf");
        assertEquals("Wolf", goblin.getSpecies());
        goblin.setSubSpecies("Desert Wolf");
        assertEquals("Desert Wolf", goblin.getSubSpecies());
        goblin.setBiom("Desert");
        assertEquals("Desert", goblin.getBiom());
        goblin.setMaxHP(50);
        assertEquals(50, goblin.getMaxHP());
    }

    @Test
    void testString() {
        assertEquals("Enemy{id=null, species='Goblin', subspecies='Forest Goblin', biom='Forest', max HP='10'}", goblin.toString());
    }
}
