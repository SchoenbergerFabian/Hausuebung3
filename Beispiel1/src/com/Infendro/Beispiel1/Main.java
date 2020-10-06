package com.Infendro.Beispiel1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

}
