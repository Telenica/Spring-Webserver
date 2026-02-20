error id: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyController.java:_empty_/EnemyRepository#
file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyController.java
empty definition using pc, found symbol in pc: _empty_/EnemyRepository#
found definition using semanticdb; symbol local0
empty definition using fallback
non-local guesses:

offset: 791
uri: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyController.java
text:
```scala
package com.example.WebProject;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

//In Postman oder etwas äquivalentem
@RestController
public class EnemyController {
    
    private final EnemyReposito@@ry repository;

    EnemyController(EnemyRepository repository){
        this.repository = repository;
    }

    //Anzeige von allen Feinden

    //Get Befehl
    @GetMapping("/enemys")
    List<Enemy> all() {
        return repository.findAll();
    }

    //Post Befehl
    @PostMapping("/enemys")
    Enemy newEnemy(@RequestBody Enemy newEnemy){
        return repository.save(newEnemy);
    }

    //Ein Feind

    //Get Befehl
    @GetMapping("/enemys/{id}")
    Enemy one(@PathVariable Long id) {
        Enemy enemy = repository.findById(id)
            .orElseThrow(() -> new EnemyNotFoundException(id));
        
        return EntityModel.of(enemy, //
            linkTo(methodOn(EnemyController.class).one(id)).withSelfRel(),
            linkTo(methodOn(EnemyController.class).all()).withRel("enemys")
        )
    }

    //Put Befehl
    @PutMapping("/enemys/{id}")
    Enemy replaceEmployee(@RequestBody Enemy newEnemy, @PathVariable Long id) {
        return repository.findById(id)
        .map(enemy -> {
            enemy.setSpecies(newEnemy.getSpecies());
            enemy.setSubSpecies(newEnemy.getSubSpecies());
            return repository.save(enemy);
        })
        .orElseGet(() -> {
            return repository.save(newEnemy);
        });
    }

    //Delete Befehl
    @DeleteMapping("/enemys/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/EnemyRepository#