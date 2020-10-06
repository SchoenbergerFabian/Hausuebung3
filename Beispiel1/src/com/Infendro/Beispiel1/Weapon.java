package com.Infendro.Beispiel1;

import java.util.List;
import java.util.stream.Collectors;

public class Weapon {
    private String name;
    private WeaponType weaponType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public Weapon() {
    }

    public Weapon(String name, WeaponType weaponType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.weaponType = weaponType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public static List<Weapon> sortMaxToMinDamage(List<Weapon> weapons){
        return weapons.stream()
                .sorted((w1,w2)-> w1.getDamage()-w2.getDamage())
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
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
}
