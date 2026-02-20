package com.example.WebProject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
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
    
    private final EnemyRepository repository;

    private final EnemyModelAssembler assembler;

    EnemyController(EnemyRepository repository, EnemyModelAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    //Anzeige von allen Feinden

    //Get Befehl
    @GetMapping("/enemys")
     CollectionModel<EntityModel<Enemy>> all() {
        List<EntityModel<Enemy>> enemys = repository.findAll().stream()
        .map(assembler::toModel) //verkürzte Variante von EntityModel um Link zu erzeugen
        .collect(Collectors.toList());
        
        return CollectionModel.of(enemys, linkTo(methodOn(EnemyController.class).all()).withSelfRel());
    }

    //Post Befehl
    @PostMapping("/enemys")
    ResponseEntity<?> newEnemy(@RequestBody Enemy newEnemy){
        EntityModel<Enemy> entityModel = assembler.toModel(repository.save(newEnemy));

        return ResponseEntity //
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
            .body(entityModel);
    }

    //Ein Feind

    //Get Befehl
    @GetMapping("/enemys/{id}")
    EntityModel<Enemy> one(@PathVariable Long id) {
        Enemy enemy = repository.findById(id)
            .orElseThrow(() -> new EnemyNotFoundException(id));
        
        return assembler.toModel(enemy); //verkürzte Variante von EntityModel um Link zu erzeugen
    }

    //Put Befehl
    @PutMapping("/enemys/{id}")
    ResponseEntity<?> replaceEnemy(@RequestBody Enemy newEnemy, @PathVariable Long id) {
        Enemy updatedEnemy = repository.findById(id) //
        .map(enemy -> {
            enemy.setSpecies(newEnemy.getSpecies());
            enemy.setSubSpecies(newEnemy.getSubSpecies());
            return repository.save(enemy);
        }) //
        .orElseGet(() -> {
            return repository.save(newEnemy);
        });

        EntityModel<Enemy> entityModel = assembler.toModel(updatedEnemy);

        return ResponseEntity //
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
            .body(entityModel);
    }

    //Delete Befehl
    @DeleteMapping("/enemys/{id}")
    ResponseEntity<?> deleteEnemy(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
