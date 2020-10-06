package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    private int[] numbers;
    private String[] strings;
    
    public Streams(){
        numbers = new RandomNumberArray().getRandomNumberArray(1000, 0, 100);
        strings = new RandomStringArray().getRandomStringArray(10,10);
    }
    
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
        //implement this
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       //implement this
    }
}
