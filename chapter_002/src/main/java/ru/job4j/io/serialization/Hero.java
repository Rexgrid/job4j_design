package ru.job4j.io.serialization;

import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        JSONObject spell = new JSONObject("{\"spell\":\"Firestorm\"}");

        List<String> weapons = new ArrayList<>();
        weapons.add("One-Handed Sword");
        weapons.add("Wand");
        JSONArray jsonArray = new JSONArray(weapons);

        final Hero alfredVanBidden = new Hero(true, 35,
                new SpellBook("Firestorm"), "One-Handed Sword", "Wand");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isHuman", alfredVanBidden.isHuman);
        jsonObject.put("valueOfGold", alfredVanBidden.getValueOfGold());
        jsonObject.put("spell", spell );
        jsonObject.put("weapon",jsonArray);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(alfredVanBidden));

    }
}


