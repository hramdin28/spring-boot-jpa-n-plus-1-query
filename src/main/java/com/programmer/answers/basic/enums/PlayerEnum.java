package com.programmer.answers.basic.enums;

/**
 * Ajouter deux attributs supplémentaires, age et pays, à chaque joueur.
 */
public enum PlayerEnum {
    MESSI(32, "Argentine"),
    RONALDO(34, "Portugal"),
    ZLATAN(37, "Suede"),
    GERRARD(40, "Angleterre"),
    ZIDANE(45, "France");

    public final int age;
    public final String pays;

    PlayerEnum(int age, String pays) {
        this.age = age;
        this.pays = pays;
    }

}
