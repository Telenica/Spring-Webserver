package com.example.WebProject;

import org.springframework.stereotype.Service;

import java.util.List;

// Erstellung von Gruppenteilnehmern
@Service
public class EnemyService {
    
    private final EnemyRepository enemyRepository;
    private final EnemyGroupMemberRepository memberRepository;

    public EnemyService(EnemyRepository enemyRepository, EnemyGroupMemberRepository memberRepository) {
        this.enemyRepository = enemyRepository;
        this.memberRepository = memberRepository;
    }

    //Gruppenmitglied aus Template erstellen
    public EnemyGroupMember memberfromTemplate(Long enemyId) {
        EnemyTemplate template = enemyRepository.findById(enemyId).orElseThrow(() -> new RuntimeException("Enemy not found"));
        
        EnemyGroupMember member = new EnemyGroupMember();
        member.setEnemyTemplate(template);
        member.setCurrentHP(template.getMaxHP()); //Status wird automatisch damit gesetzt und Conditions ist shcon leer
        return memberRepository.save(member);
    }

    public List<EnemyGroupMember> createGroup(List<Long> enemyIds) {
        return enemyIds.stream().map(this::memberfromTemplate).toList();
    }
}
