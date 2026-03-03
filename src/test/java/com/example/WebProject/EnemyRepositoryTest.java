package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;
import java.util.List;

// Integrationstest für Datenbank
@DataJpaTest
public class EnemyRepositoryTest {
    @Autowired
    private EnemyRepository enemyRepository;

    @Test
    void testSaveAndFindById() {
        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Forest", 10);
        Enemy saved = enemyRepository.save(goblin);

        Optional<Enemy> found = enemyRepository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("Goblin", found.get().getSpecies());
    }

    @Test
    void testFindAll() {
        enemyRepository.save(new Enemy("Goblin", "Forest Goblin", "Forest", 10));
        enemyRepository.save(new Enemy("Orc", "Hill Orc", "Hills", 15));

        assertEquals(2, enemyRepository.findAll().size());
    }

    @Test
    void testFindMethods() {
        enemyRepository.save(new Enemy("Goblin", "Forest Goblin", "Forest", 10));
        enemyRepository.save(new Enemy("Wolf", "Desert Wolf", "Desert", 15));
        enemyRepository.save(new Enemy("Wolf", "Forest Wolf", "Forest", 15));
        enemyRepository.save(new Enemy("Orc", "Hill Orc", "Hills", 30));

        List<Enemy> goblins = enemyRepository.findBySpecies("Goblin");
        List<Enemy> wolves = enemyRepository.findBySpecies("Wolf");
        List<Enemy> forestEnemies = enemyRepository.findByBiom("Forest");
        List<Enemy> hillOrcs = enemyRepository.findBySubspecies("Hill Orc");

        assertEquals(1, goblins.size());
        assertTrue(goblins.stream().anyMatch(e -> e.getSubSpecies().equals("Forest Goblin")));

        assertEquals(2, wolves.size());
        assertTrue(wolves.stream().anyMatch(e -> e.getSubSpecies().equals("Forest Wolf")));
        assertTrue(wolves.stream().anyMatch(e -> e.getSubSpecies().equals("Desert Wolf")));

        assertEquals(2, forestEnemies.size());
        assertTrue(forestEnemies.stream().anyMatch(e -> e.getSubSpecies().equals("Forest Goblin")));
        assertTrue(forestEnemies.stream().anyMatch(e -> e.getSubSpecies().equals("Forest Wolf")));

        assertEquals(1, hillOrcs.size());
        assertTrue(hillOrcs.stream().anyMatch(e -> e.getSubSpecies().equals("Hill Orc")));
    }
}
