package com.example.WebProject;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

//Zufällig Gegnergruppe erstellen
@Service
public class EnemyGroupService {
    private final EnemyService enemyService;
    private final EnemyRepository enemyRepository;
    private final Random rand = new Random();

    public EnemyGroupService(EnemyService enemyService, EnemyRepository enemyRepository) {
        this.enemyService = enemyService;
        this.enemyRepository = enemyRepository;
    }

    // mit Gegnerauswahl und bestimmter Größe zufällige Gruppe mit Duplikaten erstellen
    public List<EnemyGroupMember> createRandomGroup(int size, List<Enemy> enemies) {
        if(enemies.isEmpty()){
            throw new RuntimeException("Keine Gegner verfügbar für die gewählte Liste");
        }

        List<EnemyGroupMember> group = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            // Zufälligen Gegner auswählen (Duplikate möglich)
            Enemy randomEnemy = enemies.get(rand.nextInt(group.size()));
            EnemyGroupMember member = enemyService.memberfromTemplate(randomEnemy.getId());
            group.add(member);
        }

        return group;
    }

    // 1️⃣ Zufällige Gruppe aus allen Gegnern
    public List<EnemyGroupMember> createRandomGroupWithAll(int size) {
        List<Enemy> allEnemies = enemyRepository.findAll();
        return createRandomGroup(size, allEnemies);
    }

    // 2️⃣ Zufällige Gruppe aus bestimmtem Biom 
    public List<EnemyGroupMember> createRandomGroupByBiomes(int size, List<String> biomes) {
        List<Enemy> filtered = enemyRepository.findAll().stream().filter(e -> biomes.contains(e.getBiom())).toList();
        return createRandomGroup(size, filtered);
    }

    // 3️⃣ Zufällige Gruppe von bestimmter Spezies 
    public List<EnemyGroupMember> createRandomGroupBySpecies(int size, List<String> species) {
        List<Enemy> filtered = enemyRepository.findAll().stream().filter(e -> species.contains(e.getSpecies())).toList();
        return createRandomGroup(size, filtered);
    }

    // 4️⃣ Zufällige Gruppe aus Biomen und Spezies 
    public List<EnemyGroupMember> createRandomGroupByBiomesAndSpecies(int size, List<String> biomes, List<String> species) {
        List<Enemy> filtered = enemyRepository.findAll().stream()
        .filter(e -> biomes.contains(e.getBiom())).filter(e -> species.contains(e.getSpecies())).toList();
        return createRandomGroup(size, filtered);
    }
}
