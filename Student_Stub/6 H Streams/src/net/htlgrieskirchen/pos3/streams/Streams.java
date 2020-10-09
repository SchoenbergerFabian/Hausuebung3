package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {
    
    public double average(int[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .getAsDouble();
    }
    
    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings)
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream()
                .min((w1,w2) -> w1.getDamage()-w2.getDamage())
                .orElse(null);
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream()
                .max((w1,w2) -> w1.getMinStrength()-w2.getMinStrength())
                .orElse(null);
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream()
                .filter(weapon -> weapon.getDamageType()==DamageType.MISSILE)
                .collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream()
                .max((w1,w2) -> w1.getName().length()-w2.getName().length())
                .orElse(null);  
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream()
                .map(weapon -> weapon.getName())
                .collect(Collectors.toList());
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(weapon -> weapon.getSpeed())
                .toArray();
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(weapon -> weapon.getValue())
                .sum();
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(weapon -> weapon.hashCode())
                .sum();
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       weapons.stream()
               .forEach(weapon -> weapon.setValue((int) (weapon.getValue()*1.1)));
    }
}
