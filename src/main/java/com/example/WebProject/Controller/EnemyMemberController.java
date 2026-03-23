package com.example.WebProject.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebProject.Enemys.EnemyGroupMember;
import com.example.WebProject.Service.EnemyGroupService;
import com.example.WebProject.Service.EnemyService;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

//Controller für zufällige Gruppenerstellung
@RestController
@RequestMapping("/enemy-group-members")
public class EnemyMemberController {
    private final EnemyService enemyService;
    private final EnemyGroupService enemyGroupService;

    public EnemyMemberController(EnemyService enemyService, EnemyGroupService enemyGroupService) {
        this.enemyService = enemyService;
        this.enemyGroupService = enemyGroupService;
    }

    //einen Gegner erzeugen
    @PostMapping("/{enemyId}")
    public EnemyGroupMember createMember(@PathVariable Long enemyId) {
        return enemyService.memberfromTemplate(enemyId);
    }

    //mehrere Gegner auf einmal erzeugen
    @PostMapping("/group")
    public List<EnemyGroupMember> createGroup(@RequestBody List<Long> enemyIds) {
        return enemyIds.stream().map(enemyService::memberfromTemplate).collect(Collectors.toList());
    }

    //zufällige Gruppe aller Gegner
    @PostMapping("/random/{size}")
    public List<EnemyGroupMember> createRandomGroup(@PathVariable int size) {
        return enemyGroupService.createRandomGroupWithAll(size);
    }

    //zufällige Gruppe nach Biomen
    @PostMapping("/random/biomes/{size}")
    public List<EnemyGroupMember> createRandomGroupByBiomes(@PathVariable int size, @RequestBody List<String> biomes) {
        return enemyGroupService.createRandomGroupByBiomes(size, biomes);
    }

    //zufällige Gruppe nach Spezies
    @PostMapping("/random/species/{size}")
    public List<EnemyGroupMember> createRandomGroupBySpecies(@PathVariable int size, @RequestBody List<String> species) {
        return enemyGroupService.createRandomGroupBySpecies(size, species);
    }

    //zufällige Gruppe nach Biom und Spezies
    @PostMapping("/random/biomes-species/{size}")
    public List<EnemyGroupMember> createRandomGroupByBiomesAndSpecies(@PathVariable int size, @RequestBody Map<String, List<String>> filters) {
        List<String> biomes = filters.getOrDefault("biomes", List.of());
        List<String> species = filters.getOrDefault("species", List.of());
        return enemyGroupService.createRandomGroupByBiomesAndSpecies(size, biomes, species);
    }
}
