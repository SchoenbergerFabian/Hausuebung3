/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Fabian
 */
public class WeaponsReader {
    public List<Weapon> getWeaponsFromFile(String file){
        List<Weapon> weapons = new ArrayList<>();
        
        try {
            weapons = Files.lines(new File(file).toPath())
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
        } catch (IOException ex) {
            System.out.println("ERROR File not found!");
        }
        
        return weapons;
    }
}
