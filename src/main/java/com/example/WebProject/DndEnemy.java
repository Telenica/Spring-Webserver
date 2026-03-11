package com.example.WebProject;

import jakarta.persistence.Entity;

@Entity
public class DndEnemy extends Enemy {

    //Basiswerte
    private int Str;
    private int Dex;
    private int Con;
    private int Int;
    private int Wis;
    private int Cha;
    private int Ac;
    private int Speed;
    private int Ini;
    private double Cr;
    private List<DnDWaffe> Waffen;
    private List<DnDSpells> Spells;
    private List<DnDDamageType> Resistance;
    private List<DnDDamageType> Immunitys;
    private List<DnDSense> Senses;
    private List<DnDAction> Actions;

    public DndEnemy(String species, String subspecies, String biom, int maxHP, Systeme sys, int Str, int Dex, int Con, int Int, int Wis, int Cha, int Ac, int Speed, int Ini, double Cr, List<DnDWaffe> Waffen,List<DnDDamageType> Resistance, List<DnDDamageType> Immunitys, List<Sense> Senses, List<DnDSpells> Spells, List<DnDAction> Actions){
        super(species, subspecies, biom, maxHP, sys);
        this.Str = Str;
        this.Dex = Dex;
        this.Con = Con;
        this.Int = Int;
        this.Wis = Wis;
        this.Cha = Cha;
        this.Ac = Ac;
        this.Speed = Speed;
        @Getter@Setter this.Ini = Ini;
        this.Cr = Cr;
        this.Waffen = Waffen;
        @Getter@Setter this.Resistance = Resistance;
        @Getter@Setter this.Immunitys = Immunitys;
        @Getter@Setter this.Senses = Senses;
        this.Spells = Spells;
        @Getter@Setter this.Actions = Actions;
    }

    //Getter und Setter
    //Strength
    public int getStr(){
        return Str;
    }

    public void setStr(int Str){
        this.Str = Str;
    }

    //Dexterity
    public int getDex(){
        return Dex;
    }

    public void setDex(int Dex){
        this.Dex = Dex;
    }

    //Constitution
    public int getCon(){
        return Con;
    }

    public void setCon(int con){
        this.Con = con;
    }

    //Intelligence
    public int getInt(){
        return Int;
    }

    public void setInt(int Int){
        this.Int = Int;
    }

    //Wisdome
    public int getWis(){
        return Wis;
    }

    public void setWis(int Wis){
        this.Wis = Wis;
    }

    //Charisma
    public int getCha(){
        return Cha;
    }

    public void setCha(int Cha){
        this.Cha = Cha;
    }

    //Armor Class
    public int getAc(){
        return Ac;
    }

    public void setAc(int Ac){
        this.Ac = Ac;
    }

    //Speed
    public int getSpeed(){
        return Speed;
    }

    public void setSpeed(int Speed){
        this.Speed = Speed;
    }

    //Challenge Rating
    public double getCr(){
        return Cr;
    }

    public void setCr(double Cr){
        this.Cr = Cr;
    }

    //Waffen
    public List getWaffen() {
        return WAFFEN;
    }

    public void setWaffen(List<DnDWaffe> Waffen) {
        this.Waffen = Waffen;
    }

    public void addWaffe(DnDWaffe Waffe) {
        this.Waffen.add(Waffe);
    }

    public void removeWaffe(DnDWaffe Waffe) {
        this.Waffen.remove(Waffe);
    }

    //Spells
    public List getSpells() {
        return this.Spells;
    }

    public void setSpells(List<DnDSpells> Spells) {
        this.Spells = Spells;
    }

    public void addSpell(DnDSpells Spell) {
        this.Spells.add(Spell);
    }

    public void removeSpell(DnDSpells Spell) {
        this.WAFFEN.remove(Spell);
    }
}