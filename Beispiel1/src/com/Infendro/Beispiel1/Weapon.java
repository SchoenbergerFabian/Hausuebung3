package com.Infendro.Beispiel1;

import java.util.List;
import java.util.stream.Collectors;

public class Weapon {
    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public Weapon() {
    }

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public static List<Weapon> sortDamage(List<Weapon> weapons){
        return weapons.stream()
                .sorted((w1,w2)-> w1.getDamage()-w2.getDamage())
                .collect(Collectors.toList());
    }

    public static List<Weapon> sortCombatType_DamageType_Name(List<Weapon> weapons){
        return weapons.stream()
                .sorted((w1,w2)-> {
                    int compare = w1.getCombatType().toString().compareTo(w2.getCombatType().toString());
                    if(compare==0){
                        compare = w1.getDamageType().toString().compareTo(w2.getDamageType().toString());
                        if(compare==0){
                            return w1.getName().compareTo(w2.getName());
                        }else{
                            return compare;
                        }
                    }else{
                        return compare;
                    }
                })
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public void setWeaponType(CombatType combatType) {
        this.combatType = combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", combatType=" + combatType +
                ", damageType=" + damageType +
                ", damage=" + damage +
                ", speed=" + speed +
                ", strength=" + strength +
                ", value=" + value +
                '}';
    }
}