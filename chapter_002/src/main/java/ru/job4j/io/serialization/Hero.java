package ru.job4j.io.serialization;

import com.google.gson.*;
import java.util.Arrays;

public class Hero {

    private final boolean isHuman;
    private final int valueOfGold;
    private final SpellBook spell;
    private final String[] weapon;

    public Hero(boolean isHuman, int valueOfGold, SpellBook spell, String... weapon) {
        this.isHuman = isHuman;
        this.valueOfGold = valueOfGold;
        this.spell = spell;
        this.weapon = weapon;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public int getValueOfGold() {
        return valueOfGold;
    }

    public String[] getWeapon() {
        return weapon;
    }

    public SpellBook getSpell() {
        return spell;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "isHuman=" + isHuman +
                ", valueOfGold=" + valueOfGold +
                ", spell=" + spell +
                ", weapon=" + Arrays.toString(weapon) +
                '}';
    }

    public static void main(String[] args) {
        final Hero alfredVanBidden = new Hero(true, 35,
                new SpellBook("Firestorm"), "One-Handed Sword", "Wand");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(alfredVanBidden));

        final String personJson =
                "{"
                        +"\"isHuman\":true,"
                        +"\"value of gold\" : 35,"
                        +"\"spell\":"
                        +"{"
                        + "\"spell\":Firestorm"
                        +"},"
                        +"\"weapon\":"
                        +"[\"One-Handed Sword\", \"Wand\"]"
                        +"}";
        final  Hero fromJson = gson.fromJson(personJson, Hero.class);
        System.out.println(fromJson);
    }
}


