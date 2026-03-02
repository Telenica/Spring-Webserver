package com.example.WebProject;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Feindesklasse mit ID um Spezies, Unterspezies und Biom festzulegen und auszulesen
@Entity
public class Enemy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String species;
    private String subspecies;
    private String biom;
    private int maxHP;

    Enemy() {}

    //zur Erstellung
    Enemy(String species, String subspecies, String biom, int maxHP){
        this.species = species;
        this.subspecies = subspecies;
        this.biom = biom;
        this.maxHP = maxHP;
    }

    //ID herausgeben
    public Long getId(){
        return this.id;
    }

    //Spezies herausgeben und angeben
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    //Subspezies herausgeben und angeben
    public String getSubSpecies() {
        return subspecies;
    }

    public void setSubSpecies(String subSpecies) {
        this.subspecies = subSpecies;
    }

    //Biom herausgeben und angeben
    public String getBiom() {
        return biom;
    }

    public void setBiom(String biom) {
        this.biom = biom;
    }

    //HP herausgeben und angeben
    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    //HashCode erstellen
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.species, this.subspecies, this.biom);
    }

    //String von allen angegebenen Variablen herausgeben
    @Override
    public String toString() {
        return "Enemy{" + "id=" + this.id + ", species='" + this.species + "', subspecies='" + this.subspecies + "', biom='" + this.biom + "'}";
    }
}