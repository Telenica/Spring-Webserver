package com.example.WebProject.DSA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.WebProject.Repository.DSASpellRepository;

public class DSASpellDatabase {

    @Bean
    CommandLineRunner initDatabase(DSASpellRepository repository) {
        return args -> {

        for (DSASpells w : DSASpells.values()) {

            if (repository.findByName(w.name()).isEmpty()) {

                DSASpellTemplate entity = new DSASpellTemplate();
                entity.setName(w.name());
                entity.setProbe(w.getProbe());
                entity.setAsP(w.getAsP());
                entity.setReichweite(w.getReichweite());
                entity.setWd(w.getWd());
                entity.setZiel(w.getZiel());

                repository.save(entity);
            }
        }
    };
    }
}
