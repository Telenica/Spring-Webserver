package com.example.WebProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Alle passenden Spezies und Unterspezies finden
@RepositoryRestResource(collectionResourceRel = "enemys", path = "enemys")
public interface EnemyRepository extends JpaRepository<Enemy, Long>{
    List<Enemy> findBySubSpecies(@Param("subSpecies") String subSpecies);
    List<Enemy> findBySpecies(@Param("species") String species);
}
