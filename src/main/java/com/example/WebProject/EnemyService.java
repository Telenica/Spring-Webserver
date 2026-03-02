package com.example.WebProject;

import org.springframework.stereotype.Service;

// Erstellung von Gruppenteilnehmern
@Service
public class EnemyService {
    
    private final EnemyRepository enemyRepository;

    public EnemyService(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;
    }

    //Gruppenmitglied aus Template erstellen
    public EnemyGroupMember memberfromTemplate(Long enemyId) {
        Enemy template = enemyRepository.findById(enemyId).orElseThrow(() -> new RuntimeException("Enemy not found"));
        
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(template);
        member.setCurrentHP(template.getMaxHP()); //Status wird automatisch gesetzt
        return member;
    }
}
