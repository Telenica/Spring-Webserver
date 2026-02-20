package com.example.WebProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Datenbank mit allen Feinden
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EnemyRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Enemy("Wolf", "gewöhnlicher Wolf")));
            log.info("Preloading " + repository.save(new Enemy("Wolf", "Alpha Wolf")));
            log.info("Preloading " + repository.save(new Enemy("Ork", "Schamane")));
            log.info("Preloading " + repository.save(new Enemy("Ork", "Krieger")));
        };
    }
}
