package com.example.WebProject;

public class DSAEnemy extends Enemy{
    private int MUT;
    private int KLUGHEIT;
    private int INTUITION;
    private int CHARISMA;
    private int FINGERFERTIGKEIT;
    private int GEWANDTHEIT;
    private int KONSTITUTION;
    private int KOERPERKRAFT;
    private int GESCHWINDIGKEIT;
    private int INIBASIS;
    private int ATTACKE;
    private int PARADE;
    private int FERNKAMPF;
    private int AUSWEICHEN;

    public DSAEnemy(String species, String subSpecies, String biom, int maxHP, Systeme sys, int MU, int KL, int IN, int CH, int FF, int GW, int KO, int KK, int GS, int IB, int AT, int PA, int FK, int AW){
        super(species, subSpecies, biom, maxHP, sys);
        this.MUT = MU;
        this.KLUGHEIT = KL;
        this.INTUITION = IN;
        this.CHARISMA = CH;
        this.FINGERFERTIGKEIT = FF;
        this.GEWANDTHEIT = GW;
        this.KONSTITUTION = KO;
        this.KOERPERKRAFT = KK;
        this.GESCHWINDIGKEIT = GS;
        this.INIBASIS = IB;
        this.ATTACKE = AT;
        this.PARADE = PA;
        this.FERNKAMPF = FK;
        this.AUSWEICHEN = AW;
    }

    //Getter und Setter
    
    //Mut
    public int getMU() {
        return MUT;
    }
    
    public void setMU(int MU) {
        this.MUT = MU;
    }

    //Klugheit
    public int getKL() {
        return KLUGHEIT;
    }
    
    public void setKL(int KL) {
        this.KLUGHEIT = KL;
    }

    //Intuition
    public int getIN() {
        return INTUITION;
    }
    
    public void setIN(int IN) {
        this.INTUITION = IN;
    }

    //Charisma
    public int getCH() {
        return CHARISMA;
    }
    
    public void setCH(int CH) {
        this.CHARISMA = CH;
    }

    //Fingerfertigkeit
    public int getFF() {
        return FINGERFERTIGKEIT;
    }
    
    public void setFF(int FF) {
        this.FINGERFERTIGKEIT = FF;
    }

    //Gewandheit
    public int getGW() {
        return GEWANDTHEIT;
    }

    public void setGW(int GW) {
        this.GEWANDTHEIT = GW;
    }

    //Konstitution
    public int getKO() {
        return KONSTITUTION;
    }

    public void setKO(int KO){
        this.KONSTITUTION = KO;
    }

    //Koerperkraft
    public int getKK() {
        return KOERPERKRAFT;
    }
    
    public void setKK(int KK){
        this.KOERPERKRAFT = KK;
    }

    //Geschwindigkeit
    public int getGS() {
        return GESCHWINDIGKEIT;
    }

    public void setGS(int GS) {
        this.GESCHWINDIGKEIT = GS;
    }

    //INI-Basiswert
    public int getIB() {
        return INIBASIS;
    }

    public void setIB(int IB) {
        this.INIBASIS = IB;
    }

    //Attacke
    public int getAT() {
        return ATTACKE;
    }

    public void setAT(int AT) {
        this.ATTACKE = AT;
    }

    //Parade
    public int getPA() {
        return PARADE;
    }

    public void setPA(int PA) {
        this.PARADE = PA;
    }

    //Fernkampf
    public int getFK() {
        return FERNKAMPF;
    }

    public void setFK(int FK) {
        this.FERNKAMPF = FK;
    }

    //Ausweichen
    public int getAW() {
        return AUSWEICHEN;
    }

    public void setAW(int AW) {
        this.AUSWEICHEN = AW;
    }
}
