error id: file:///C:/Users/jejen/OneDrive/Dokumente/repos/Spring-Webserver/src/main/java/com/example/WebProject/EnemyRepository.java:java/lang/String#
file:///C:/Users/jejen/OneDrive/Dokumente/repos/Spring-Webserver/src/main/java/com/example/WebProject/EnemyRepository.java
empty definition using pc, found symbol in pc: java/lang/String#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 585
uri: file:///C:/Users/jejen/OneDrive/Dokumente/repos/Spring-Webserver/src/main/java/com/example/WebProject/EnemyRepository.java
text:
```scala
package com.example.WebProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Alle passenden Spezies und Unterspezies finden
@RepositoryRestResource(collectionResourceRel = "enemys", path = "enemys")
public interface EnemyRepository extends JpaRepository<Enemy, Long>{
    List<Enemy> findBySubSpecies(@Param("subSpecies") String subSpecies);
    List<Enemy> findBySpecies(@Param("species") Strin@@g species);
    List<Enemy> findByBiom(@Param("biom") String biom);
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/String#