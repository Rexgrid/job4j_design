package ru.job4j.io.serialization;

public class SpellBook {

    private final String spell;

    public SpellBook(String spell) {
        this.spell = spell;
    }

    public String getSpell() {
        return spell;
    }

    @Override
    public String toString() {
        return "SpellBook{" +
                "spell='" + spell + '\'' +
                '}';
    }
}
