package com.example.WebProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.example.WebProject.Enemys.EnemyTemplate;
import com.example.WebProject.Enumzusätze.Systeme;
import com.example.WebProject.Homebrew.HomeEnemy;
import com.example.WebProject.Repository.EnemyRepository;

import java.util.Optional;
import java.util.List;

// Integrationstest für Datenbank
@DataJpaTest
public class EnemyRepositoryTest {
    @Autowired
    private EnemyRepository enemyRepository;

    @Test
    void testSaveAndFindById() {
        EnemyTemplate goblin = new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5);
        EnemyTemplate saved = enemyRepository.save(goblin);

        Optional<EnemyTemplate> found = enemyRepository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("Goblin", found.get().getSpecies());
    }

    @Test
    void testFindAll() {
        enemyRepository.save(new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5));
        enemyRepository.save(new HomeEnemy("Orc", "Hill Orc", "Hills", 15, Systeme.HOMEBREW, 50, 20));

        assertEquals(2, enemyRepository.findAll().size());
    }

    @Test
    void testFindMethods() {
        enemyRepository.save(new HomeEnemy("Goblin", "Forest Goblin", "Forest", 10, Systeme.HOMEBREW, 10, 5));
        enemyRepository.save(new HomeEnemy("Wolf", "Desert Wolf", "Desert", 15, Systeme.HOMEBREW, 25, 10));
        enemyRepository.save(new HomeEnemy("Wolf", "Forest Wolf", "Forest", 15, Systeme.HOMEBREW, 25, 10));
        enemyRepository.save(new HomeEnemy("Orc", "Hill Orc", "Hills", 30, Systeme.HOMEBREW, 50, 20));

        List<EnemyTemplate> goblins = enemyRepository.findBySpecies("Goblin");
        List<EnemyTemplate> wolves = enemyRepository.findBySpecies("Wolf");
        List<EnemyTemplate> forestEnemies = enemyRepository.findByBiom("Forest");
        List<EnemyTemplate> hillOrcs = enemyRepository.findBySubspecies("Hill Orc");

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
