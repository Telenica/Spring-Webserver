package com.example.WebProject.Enemys;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import java.util.Set;

import com.example.WebProject.DSA.DSAZustände;
import com.example.WebProject.DnD.DnDCondition;
import com.example.WebProject.Enumzusätze.ConditionInterface;
import com.example.WebProject.Enumzusätze.Status;
import com.example.WebProject.Homebrew.HomeCondition;

import java.util.HashSet;

//Feind in Gruppe
@Entity
public class EnemyGroupMember {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enemy_id")
    private EnemyTemplate enemyTemplate;

    private int currentHP;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection(targetClass = HomeCondition.class)
    @Enumerated(EnumType.STRING)
    private Set<ConditionInterface> conditions = new HashSet<>();

    //ID zurückgeben
    public Long getId() { 
        return id; 
    }

    //herausgeben und angeben des Feindes der zur Gruppe dazu soll
    public EnemyTemplate getEnemyTemplate() { 
        return enemyTemplate; 
    }

    public void setEnemyTemplate(EnemyTemplate enemyTemplate) { 
        this.enemyTemplate = enemyTemplate; 
    }

    //herausgeben und angeben der HP des Feindes
    public int getCurrentHP() { 
        return currentHP; 
    }

    public void setCurrentHP(int currentHP) { 
        this.currentHP = Math.max(0, Math.min(currentHP, enemyTemplate.getMaxHP())); 
        updateStatus();
    }

    //Gesundheitslevel herausgeben und berechnen
    public Status getStatus() { 
        return status; 
    }

    private void updateStatus() {
        if (currentHP <= 0) {
            status = Status.BESIEGT;
        } 
        else if (currentHP <= enemyTemplate.getMaxHP() / 2) {
            status = Status.ANGESCHLAGEN;
        } 
        else {
            status = Status.GESUND;
        }
    }

    //Gesundheitszustand anpassen und herausgeben
    public Set<ConditionInterface> getConditions() { 
        return conditions; 
    }

    public void addCondition(ConditionInterface condition) {
        switch (enemyTemplate.getSystem()) {
            case DND: 
                if (condition instanceof DnDCondition) {
                    conditions.add(condition);                    
                }
                else {
                    System.err.println("not from Type DnDCondition");
                }
            case DSA:
                if (condition instanceof DSAZustände) {
                    conditions.add(condition);                    
                }
                else {
                    System.err.println("not from Type DSAZustände");
                }
            case HOMEBREW:
                if (condition instanceof HomeCondition) {
                    conditions.add(condition);                    
                }
                else {
                    System.err.println("not from Type HomeCondition");
                }
            default:
                break;
        } 
    }

    public void removeCondition(ConditionInterface condition) { 
        conditions.remove(condition); 
    }

    public void setConditions(Set<ConditionInterface> conditions){
        switch (enemyTemplate.getSystem()) {
            case DND: 
                if (conditions.stream().allMatch(c -> c instanceof DnDCondition)) {
                    this.conditions = conditions;                    
                }
                else {
                    System.err.println("not from Type DnDCondition");
                }
                break;
            case DSA:
                if (conditions.stream().allMatch(c -> c instanceof DSAZustände)) {
                    this.conditions = conditions;                    
                }
                else {
                    System.err.println("not from Type DSAZustände");
                }
                break;
            case HOMEBREW:
                if (conditions.stream().allMatch(c -> c instanceof HomeCondition)) {
                    this.conditions = conditions;                    
                }
                else {
                    System.err.println("not from Type HomeCondition");
                }
                break;
            default:
                break;
        } 
    }

}
