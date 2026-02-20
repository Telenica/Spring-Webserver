package com.example.WebProject;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

//Nur ein Link statt mehrere an Enemy
@Component
public class EnemyModelAssembler implements RepresentationModelAssembler<Enemy, EntityModel<Enemy>>{
    @Override
    public EntityModel<Enemy> toModel(Enemy enemy) {

        return EntityModel.of(enemy, //
            linkTo(methodOn(EnemyController.class).one(enemy.getId())).withSelfRel(),
            linkTo(methodOn(EnemyController.class).all()).withRel("enemys"));
    }
}
