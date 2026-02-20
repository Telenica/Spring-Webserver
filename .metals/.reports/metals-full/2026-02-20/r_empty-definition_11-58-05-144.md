error id: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyRepository.java:java/util/List#
file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyRepository.java
empty definition using pc, found symbol in pc: java/util/List#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 55
uri: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyRepository.java
text:
```scala
package com.example.WebProject;

import java.util.Lis@@t;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "enemys", path = "enemys")
public interface EnemyRepository extends JpaRepository<Enemy, Long>{
    List<Enemy> findBySubSpecies(@Param("subSpecies") String subSpecies);
    List<Enemy> findBySpecies(@Param("species") String species);
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/List#