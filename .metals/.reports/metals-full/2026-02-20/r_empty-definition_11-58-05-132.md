error id: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyRepository.java:org/springframework/data/rest/core/annotation/RepositoryRestResource#
file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyRepository.java
empty definition using pc, found symbol in pc: org/springframework/data/rest/core/annotation/RepositoryRestResource#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 240
uri: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyRepository.java
text:
```scala
package com.example.WebProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Reposi@@toryRestResource;

@RepositoryRestResource(collectionResourceRel = "enemys", path = "enemys")
public interface EnemyRepository extends JpaRepository<Enemy, Long>{
    List<Enemy> findBySubSpecies(@Param("subSpecies") String subSpecies);
    List<Enemy> findBySpecies(@Param("species") String species);
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: org/springframework/data/rest/core/annotation/RepositoryRestResource#