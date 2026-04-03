package com.example.WebProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.WebProject.DnD.DnDSpellTemplate;

@RepositoryRestResource(collectionResourceRel = "dndspells", path = "dndspells")
public interface DnDSpellRepository extends JpaRepository<DnDSpellTemplate, Long>{
    List<DnDSpellTemplate> findByName(@Param("name") String name);
}
