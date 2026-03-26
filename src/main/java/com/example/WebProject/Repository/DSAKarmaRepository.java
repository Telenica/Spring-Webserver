package com.example.WebProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.WebProject.DSA.DSAKarmaTemplate;

@RepositoryRestResource(collectionResourceRel = "dsakarma", path = "dsakarma")
public interface DSAKarmaRepository extends JpaRepository<DSAKarmaTemplate, Long>{
    List<DSAKarmaTemplate> findByName(@Param("name") String name);
}
