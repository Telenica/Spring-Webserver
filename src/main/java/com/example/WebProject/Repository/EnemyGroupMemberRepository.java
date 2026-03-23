package com.example.WebProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.WebProject.Enemys.EnemyGroupMember;
import com.example.WebProject.Enumzusätze.Status;
import com.example.WebProject.Homebrew.HomeCondition;

//Alle passenden Zustände und Gesundheitslevel finden
@RepositoryRestResource(collectionResourceRel = "groupmembers", path = "groupmembers")
public interface EnemyGroupMemberRepository extends JpaRepository<EnemyGroupMember, Long> {
    List<EnemyGroupMember> findByStatus(@Param ("status") Status status);
    List<EnemyGroupMember> findByConditionsContaining(@Param ("condition") HomeCondition condition);
}
