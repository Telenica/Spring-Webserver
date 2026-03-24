package com.example.WebProject.DSA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.WebProject.Repository.DSAWaffenRepository;

public class DSAWaffenDatabase {

    @Bean
    CommandLineRunner initDatabase(DSAWaffenRepository repository) {
        return args -> {

        for (DSAWaffe w : DSAWaffe.values()) {

            if (repository.findByName(w.name()).isEmpty()) {

                DSAWaffenTemplate entity = new DSAWaffenTemplate();
                entity.setName(w.name());
                entity.setDamage(w.getDamage());
                entity.setLoading(w.getLoading());
                entity.setAtPaMond(w.getAtPaMod());
                entity.setDistance(w.getDistance());

                repository.save(entity);
            }
        }
    };
    }
}
