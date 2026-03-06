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
    private double Cr;

    public DndEnemy(String species, String subspecies, String biom, int maxHP, Systeme sys, int Str, int Dex, int Con, int Int, int Wis, int Cha, int Ac, int Speed, double Cr){
        super(species, subspecies, biom, maxHP, sys);
        this.Str = Str;
        this.Dex = Dex;
        this.Con = Con;
        this.Int = Int;
        this.Wis = Wis;
        this.Cha = Cha;
        this.Ac = Ac;
        this.Speed = Speed;
        this.Cr = Cr;
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

}