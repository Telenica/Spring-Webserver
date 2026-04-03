package com.example.WebProject.DnD;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.WebProject.Repository.DnDSpellRepository;

public class DnDSpellDatabase {
    private static final Logger log = LoggerFactory.getLogger(DnDSpellDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DnDSpellRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new DnDSpellTemplate("ACIDSPLASH", 0, "1d6 Acid", "1 Action", "60 ft. (5 ft. Sphere)", "Instantaneous", "V, S", "damage increase by 1d6 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Artificer"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("BLADEWARD", 0, "-", "1 Action", "self", "1 Round", "V, S", "-", List.of("Sorcerer", "Wizard", "Warlock", "Bard"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("BOOMINGBLADE", 0, "1d8 Thunder", "1 Action", "self (5 foot radius)", "1 round", "S, M (melee weapon worth at least 1 sp)", "damage increase by 1d8 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Artificer", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("CHILLTOUCH", 0, "1d10 Necrotic", "1 Action", "touch", "Instantaneous", "V, S", "damage increase by 1d10 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Warlock", "Wizard", "Artificer"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("CONTROLFLAMES", 0, "-", "1 Action", "60 ft. (5 ft. Cube)", "Instantaneous", "S", "-", List.of("Sorcerer", "Wizard", "Druid"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("CREATEBONFIRE", 0, "1d8 Fire", "1 Action", "60 ft. (5 ft. Kube)", "1 Minute", "V, S", "damage increase by 1d8 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Artificer", "Druid", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("DANCINGLIGHTS", 0, "-", "1 Action", "120 ft.", "1 Minute", "V, S, M(a bit phosphorus)", "-", List.of("Sorcerer", "Wizard", "Artificer", "Bard"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("DRUIDCRAFT", 0, "-", "1 Action", "30 ft.", "Instantaneous", "V, S", "-", List.of("Druid"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("ELDRITHBLAST", 0, "1d10 Force", "1 Action", "120 ft.", "Instantaneous", "V, S", "Beams increase by 1 more at lvl 5, lvl 11 and lvl 17", List.of("Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("ELEMENTALISM", 0, "-", "1 Action", "30 ft. (5 ft. Kube)", "Instantaneous", "V, S", "-", List.of("Sorcerer", "Wizard", "Artificer", "Druid"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("ENCODETHOUGHTS", 0, "-", "1 Action", "self", "8 hours", "S", "-", List.of("Sorcerer", "Wizard", "Artificer", "Bard", "Cleric", "Druid", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("FIREBOLT", 0, "1d10 Fire", "1 Action", "120 ft.", "Instantaneous", "V, S", "damage increase by 1d10 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Artificer"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("FRIENDS", 0, "-", "1 Action", "self", "Concentration, up to 1 minute", "S, M (small amount of makeup applied to the face as the spell is cast)", "-", List.of("Sorcerer", "Wizard", "Bard", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("FROSTBITE", 0, "1d6 Cold", "1 Action", "60 ft.", "Instantaneous", "V, S", "damage increase by 1d6 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Artificer", "Warlock", "Druid"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("GREENFLAMEBLADE", 0, "normal attack damage + spellcasting modifier fire damage", "1 Action", "self (5 ft. radius)", "Instantaneous", "S, M (melee weapon worth at least 1sp)", "fire damage increase by 1d8 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Artificer", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("GUIDANCE", 0, "-", "1 Action", "touch", "1 Minute", "V, S", "-", List.of("Cleric", "Druid", "Artificer"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("GUST", 0, "-", "1 Action", "30 ft.", "Instantaneous", "V, S", "-", List.of("Sorcerer", "Wizard", "Druid"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("INFESTATION", 0, "1d6 poison", "1 Action", "30 ft.", "Instantaneous", "V, S, M (living flea)", "damage increase by 1d6 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Druid", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("LIGHT", 0, "-", "1 Action", "touch", "1 hour", "V, M (firefly or phosphorescent moss)", "-", List.of("Sorcerer", "Wizard", "Artificer", "Bard", "Cleric", "Warlock (Clestial Patron)"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("LIGHTNINGLURE", 0, "1d8 lightning", "1 Action", "self (15 ft. radius)", "Instantaneous", "V", "damage increase by 1d8 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Artificer", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("MAGEHAND", 0, "-", "1 Action", "30 ft.", "1 Minute", "V, S", "-", List.of("Sorcerer", "Wizard", "Artificer", "Bard", "Warlock", "Rogue (Arcane Trickster)"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("MAGICKSTONE", 0, "1d6 + spellcasting modifier bludgeioning", "1 Bonusaction", "touch", "1 Minute", "V, S", "", List.of("Druid", "Warlock", "Artificer"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("MENDING", 0, "-", "1 Action", "touch", "Instantaneous", "V, S, M (two lodestones)", "-", List.of("Sorcerer", "Wizard", "Bard", "Cleric", "Druid"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("MESSAGE", 0, "-", "1 Action", "120 ft.", "1 round", "S, M (copper wire)", "-", List.of("Sorcerer", "Wizard", "Artificer", "Bard", "Druid"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("MINDSLIVER", 0, "1d6 psychic", "1 Action", "60 ft.", "1 round", "V", "damage increase by 1d6 at lvl 5, lvl 11 and lvl 17", List.of("Sorcerer", "Wizard", "Warlock"))));
            log.info("Preloading " + repository.save(new DnDSpellTemplate("MINORILLUSION", 0, "-", "1 Action", "30 ft. (5 ft. Kube)", "1 Minute", "S, M (bit of fleece)", "-", List.of("Sorcerer", "Wizard", "Bard", "Warlock"))));
        };
    }
}
