package com.example.WebProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.WebProject.DnD.DnDWaffenTemplate;

@RepositoryRestResource(collectionResourceRel = "dndweapons", path = "dndweapons")
public interface DnDWaffenRepository extends JpaRepository<DnDWaffenTemplate, Long> {
    List<DnDWaffenTemplate> findByName(@Param("name") String name);
}
