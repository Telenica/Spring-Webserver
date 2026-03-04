package com.example.WebProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Alle passenden Zustände und Gesundheitslevel finden
@RepositoryRestResource(collectionResourceRel = "groupmembers", path = "groupmembers")
public interface EnemyGroupMemberRepository extends JpaRepository<EnemyGroupMember, Long> {
    List<EnemyGroupMember> findByStatus(@Param ("status") Status status);
    List<EnemyGroupMember> findByConditionsContaining(@Param ("condition") Condition condition);
}
