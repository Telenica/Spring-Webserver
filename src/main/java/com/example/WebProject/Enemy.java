package com.example.WebProject;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Feindesklasse mit ID um Spezies und Unterspezies festzulegen und auszulesen
@Entity
public class Enemy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String species;
    private String subspecies;

    Enemy() {}

    //zur Erstellung
    Enemy(String species, String subspecies){
        this.species = species;
        this.subspecies = subspecies;
    }

    public Long getId(){
        return this.id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSubSpecies() {
        return subspecies;
    }

    public void setSubSpecies(String subSpecies) {
        this.subspecies = subSpecies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.species, this.subspecies);
    }

    @Override
    public String toString() {
        return "Enemy{" + "id=" + this.id + ", species='" + this.species + "', subspecies='" + this.subspecies + "'}";
    }
}