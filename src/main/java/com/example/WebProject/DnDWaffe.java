package com.example.WebProject;

public enum DnDWaffe{
    //Simple Melee Weapons
    CLUB("1d4" , "bludgening"),
    DAGGER("1d4" , "piercing"),
    GREATCLUB("1d8" , "bludgening"),
    HANDAXE("1d6" , "slashing"),
    JAVELIN("1d" , "piercing"),
    LIGHTHAMMER("1d4" , "bludgening"),
    MACE("1d6" , "bludgening"),
    QUARTERSTAFF("1d6" , "bludgening"),
    SICKLE("1d4" , "slashing"),
    SPEAR("1d6" , "piercing"),

    //Simple Ranged Weapons

    LIGHTCROSSBOW("1d8" , "piercing"),
    DART("1d4" , "piercing"),
    SHORTBOW("1d6" , "piercing"),
    SLING("1d4" , "bludgening"),

    //Martial Melee Weapons

    BATTLEAXE("1d8" , "slashing"),
    FLAIL("1d8" , "bludgeoning"),
    GLAIVE("1d10" , "slashing"),
    GREATAXE("1d12" , "slashing"),
    GREATSWORD("2d6" , "slashing"),
    HALBERD("1d10" , "slashing"),
    LANCE("1d12" , "piercing"),
    LONGSWORD("1d8" , "slashing"),
    MAUL("2d6" , "bludgeoning"),
    MORNINGSTAR("1d8" , "piercing"),
    PIKE("1d10" , "piercing"),
    RAPIER("1d8" , "piercing"),
    SCIMITAR("1d6" , "slashing"),
    SHORTSWORD("1d6" , "piercing"),
    TRIDENT("1d6" , "piercing"),
    WARPICK("1d8" , "piercing"),
    WARHAMMER("1d8" , "bludgeoning"),
    WHIP("1d4" , "slashing"),

    //Martial Ranged Weapons

    BLOWGUN("1" , "piercing"),
    HANDCROSSBOW("1d6" , "piercing"),
    HEAVYCROSSBOW("1d10" , "piercing"),
    LONGBOW("1d8" , "piercing"),
    NET("0" , "none");

    private final String damage;
    private final String damageType;

    DnDWaffe(String damage, String damageType) {
        this.damage = damage;
        this.damageType = damageType;
    }

    public String getDamage() {
        return damage;
    }

    public String getDamageType() {
        return damageType;
    }
}