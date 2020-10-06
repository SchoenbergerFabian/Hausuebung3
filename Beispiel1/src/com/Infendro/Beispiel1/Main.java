package com.Infendro.Beispiel1;

import javax.sound.midi.Patch;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        List<Weapon> weapons = initWeapons();

        Print print = new Print();

        weapons = sortDamage(weapons);
        System.out.println("\u001B[31mSorted by Damage, high to low\u001B[0m");
        print.printNormal(weapons);
        System.out.println();
        print.printTable(weapons);

        weapons = sortCombatType_DamageType_Name(weapons);
        System.out.println("\n\u001B[31mSorted by CombatType, then DamageType, then Name\u001B[0m");
        print.printNormal(weapons);
        System.out.println();
        print.printTable(weapons);
    }

    public static List<Weapon> initWeapons(){
        try {
            return Files.lines(new File("weapons.csv").toPath())
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(line -> new Weapon(line[0],
                            CombatType.valueOf(line[1]),
                            DamageType.valueOf(line[2]),
                            Integer.parseInt(line[3]),
                            Integer.parseInt(line[4]),
                            Integer.parseInt(line[5]),
                            Integer.parseInt(line[6])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("ERROR: not a number!");;
        }

        return new ArrayList<>();
        /*
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
        */
    }

    public static List<Weapon> sortDamage(List<Weapon> weapons){
        return weapons.stream()
                .sorted((w1,w2)-> w2.getDamage()-w1.getDamage())
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
