error id: file:///C:/Users/jejen/OneDrive/Dokumente/repos/Spring-Webserver/src/main/java/com/example/WebProject/Enemy.java:java/util/Objects#hash().
file:///C:/Users/jejen/OneDrive/Dokumente/repos/Spring-Webserver/src/main/java/com/example/WebProject/Enemy.java
empty definition using pc, found symbol in pc: java/util/Objects#hash().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1490
uri: file:///C:/Users/jejen/OneDrive/Dokumente/repos/Spring-Webserver/src/main/java/com/example/WebProject/Enemy.java
text:
```scala
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String species;
    private String subspecies;
    private String biom;

    Enemy() {}

    //zur Erstellung
    Enemy(String species, String subspecies, String biom){
        this.species = species;
        this.subspecies = subspecies;
        this.biom = biom;
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

    //HashCode erstellen
    @Override
    public int hashCode() {
        return Objects.has@@h(this.id, this.species, this.subspecies, this.biom);
    }

    //String von allen angegebenen Variablen herausgeben
    @Override
    public String toString() {
        return "Enemy{" + "id=" + this.id + ", species='" + this.species + "', subspecies='" + this.subspecies + "', biom='" + this.biom + "'}";
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/Objects#hash().