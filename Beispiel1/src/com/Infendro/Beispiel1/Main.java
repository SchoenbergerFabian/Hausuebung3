package com.Infendro.Beispiel1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Weapon> weapons = initWeapons();
        weapons.stream()
        .mapToInt(Weapon::getDamage)
        .forEach(System.out::println);
    }

    public static List<Weapon> initWeapons(){
        List<Weapon> weapons = new ArrayList<>();

        try {
            BufferedReader filereader = new BufferedReader(new FileReader(new File("weapons.csv")));

            String line = filereader.readLine();
            //skip first line!
            line = filereader.readLine();
            while(line!=null){
                String[] args = line.split(";");
                weapons.add(new Weapon(
                        args[0],
                        CombatType.valueOf(args[1]),
                        DamageType.valueOf(args[2]),
                        Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]),
                        Integer.parseInt(args[5]),
                        Integer.parseInt(args[6])));
                line = filereader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weapons;
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
}
