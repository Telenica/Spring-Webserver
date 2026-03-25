package com.example.WebProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.WebProject.DSA.DSASpellTemplate;

@RepositoryRestResource(collectionResourceRel = "dsaspells", path = "dsaspells")
public interface DSASpellRepository extends JpaRepository<DSASpellTemplate, Long>{
    List<DSASpellTemplate> findByName(@Param("name") String name);
}
