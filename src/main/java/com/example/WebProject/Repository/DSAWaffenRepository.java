package com.example.WebProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.WebProject.DSA.DSAWaffenTemplate;

@RepositoryRestResource(collectionResourceRel = "dsaweapons", path = "dsaweapons")
public interface DSAWaffenRepository extends JpaRepository<DSAWaffenTemplate, Long>{
    List<DSAWaffenTemplate> findByName(@Param("name") String name);
}
