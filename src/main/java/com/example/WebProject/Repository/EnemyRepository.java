package com.example.WebProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.WebProject.Enemys.EnemyTemplate;

//Alle passenden Spezies, Unterspezies und Biome finden
@RepositoryRestResource(collectionResourceRel = "enemys", path = "enemys")
public interface EnemyRepository extends JpaRepository<EnemyTemplate, Long>{
    List<EnemyTemplate> findBySubspecies(@Param("subspecies") String subspecies);
    List<EnemyTemplate> findBySpecies(@Param("species") String species);
    List<EnemyTemplate> findByBiom(@Param("biom") String biom);
}
