/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class Main {
    public static void main(String[] args) {
        int[] numbers = new RandomNumberArray().getRandomNumberArray(1000, 0, 100);
        String[] strings = new RandomStringArray().getRandomStringArray(10,10);
        List<Weapon> weapons = new WeaponsReader().getWeaponsFromFile("weapons.csv");
        
        Streams streams = new Streams();
        
        Arrays.stream(numbers).forEach(System.out::println);
        System.out.println("\naverage");
        System.out.println(streams.average(numbers)+"\n");
        
        Arrays.stream(strings).forEach(System.out::println);
        System.out.println("\nupperCase");
        streams.upperCase(strings).forEach(System.out::println);
        System.out.println("");
        
        weapons.forEach(System.out::println);
        System.out.println("\nfindWeaponWithLowestDamage");
        System.out.println(streams.findWeaponWithLowestDamage(weapons));
        System.out.println("\nfindWeaponWithHighestStrength");
        System.out.println(streams.findWeaponWithHighestStrength(weapons));
        System.out.println("\ncollectMissileWeapons");
        streams.collectMissileWeapons(weapons).forEach(System.out::println);
        System.out.println("\nfindWeaponWithLongestName");
        System.out.println(streams.findWeaponWithLongestName(weapons));
        System.out.println("\ntoNameList");
        streams.toNameList(weapons).forEach(System.out::println);
        System.out.println("\ntoSpeedArray");
        Arrays.stream(streams.toSpeedArray(weapons))
                .forEach(System.out::println);
        System.out.println("\nsumUpValues");
        System.out.println(streams.sumUpValues(weapons));
        System.out.println("\nsumUpHashCodes");
        System.out.println(streams.sumUpHashCodes(weapons));
        System.out.println("\nremoveDuplicates");
        streams.removeDuplicates(weapons).forEach(System.out::println);
        System.out.println("\nincreaseValuesByTenPercent");
        streams.increaseValuesByTenPercent(weapons);
        weapons.forEach(System.out::println);
    }
}
