package com.example.WebProject.DnD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.WebProject.Repository.DnDWaffenRepository;

public class DnDWaffenDatabase {

    @Bean
    CommandLineRunner initDatabase(DnDWaffenRepository repository) {
        return args -> {

        for (DnDWaffe w : DnDWaffe.values()) {

            if (repository.findByName(w.name()).isEmpty()) {

                DnDWaffenTemplate entity = new DnDWaffenTemplate();
                entity.setName(w.name());
                entity.setDamage(w.getDamage());
                entity.setDamageType(DnDDamageType.valueOf(w.getDamageType().toUpperCase()));

                repository.save(entity);
            }
        }
    };
    }
}
