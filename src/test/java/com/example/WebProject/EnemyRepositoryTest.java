package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

// Integrationstest für Datenbank
@DataJpaTest
public class EnemyRepositoryTest {
    @Autowired
    private EnemyRepository enemyRepository;

    @Test
    void testSaveAndFindById() {
        Enemy goblin = new Enemy("Goblin", "Forest Goblin", "Wald", 10);
        Enemy saved = enemyRepository.save(goblin);

        Optional<Enemy> found = enemyRepository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("Goblin", found.get().getSpecies());
    }

    @Test
    void testFindAll() {
        enemyRepository.save(new Enemy("Goblin", "Forest Goblin", "Wald", 10));
        enemyRepository.save(new Enemy("Orc", "Hill Orc", "Berge", 15));

        assertEquals(2, enemyRepository.findAll().size());
    }
}
