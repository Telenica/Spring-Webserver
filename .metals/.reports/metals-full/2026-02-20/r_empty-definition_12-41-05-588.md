error id: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyController.java:_empty_/PostMapping#
file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyController.java
empty definition using pc, found symbol in pc: _empty_/PostMapping#
found definition using semanticdb; symbol com/example/WebProject/EnemyController#repository.
empty definition using fallback
non-local guesses:

offset: 922
uri: file:///C:/Users/jejen/Downloads/WebProject/WebProject/src/main/java/com/example/WebProject/EnemyController.java
text:
```scala
package com.example.WebProject;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//In Postman oder etwas äquivalentem
@RestController
public class EnemyController {
    
    private final EnemyRepository repository;

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
    @PostMapping@@("/enemys")
    Enemy newEnemy(@RequestBody Enemy newEnemy){
        return repository.save(newEnemy);
    }

    //Ein Feind

    //Get Befehl
    @GetMapping
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/PostMapping#