package com.example.WebProject.Homebrew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.WebProject.Enumzusätze.Systeme;
import com.example.WebProject.Repository.EnemyRepository;

//Datenbank mit allen Feinden
@Configuration
public class HomeEnemyDatabase {
    private static final Logger log = LoggerFactory.getLogger(HomeEnemyDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EnemyRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new HomeEnemy("Löwe", "Goldlöwe", "Steppe", 100, Systeme.HOMEBREW, 25, 10)));
            log.info("Preloading " + repository.save(new HomeEnemy("Wolf", "gewöhnlicher Wolf", "Wald", 100, Systeme.HOMEBREW, 10, 5)));
            log.info("Preloading " + repository.save(new HomeEnemy("Wolf", "Alpha Wolf", "Wald", 100, Systeme.HOMEBREW, 20, 10)));
            log.info("Preloading " + repository.save(new HomeEnemy("Ork", "Schamane", "Orkland", 100, Systeme.HOMEBREW, 18, 15)));
            log.info("Preloading " + repository.save(new HomeEnemy("Ork", "Krieger", "Orkland", 100, Systeme.HOMEBREW, 25, 25)));
            log.info("Preloading " + repository.save(new HomeEnemy("Mensch", "Bandit", "Wald", 100, Systeme.HOMEBREW, 40, 20)));
            log.info("Preloading " + repository.save(new HomeEnemy("Mensch", "Söldner", "Wald", 100, Systeme.HOMEBREW, 45, 30)));
            log.info("Preloading " + repository.save(new HomeEnemy("Mensch", "Gardist", "Stadt", 100, Systeme.HOMEBREW, 40, 35)));
            log.info("Preloading " + repository.save(new HomeEnemy("Drache", "Lindwurm", "Höhle", 100, Systeme.HOMEBREW, 95, 100)));
            log.info("Preloading " + repository.save(new HomeEnemy("Elf", "Waldelf", "Wald", 100, Systeme.HOMEBREW, 30, 25)));
        };
    }
}
