package com.example.WebProject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/enemy-group-members")
public class EnemyMemberController {
    private final EnemyService enemyService;

    public EnemyMemberController(EnemyService enemyService) {
        this.enemyService = enemyService;
    }

    //einen Gegner erzeugen
    @PostMapping("/{enemyId}")
    public EnemyGroupMember createMember(@PathVariable Long enemyId) {
        return enemyService.memberfromTemplate(enemyId);
    }

    //mehrere Gegner auf einmal erzeugen
    @PostMapping("/group")
    public List<EnemyGroupMember> createGroup(@RequestBody List<Long> enemyIds) {
        return enemyIds.stream()
                       .map(enemyService::memberfromTemplate)
                       .collect(Collectors.toList());
    }
}
