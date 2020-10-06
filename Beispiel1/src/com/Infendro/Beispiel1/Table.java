package com.Infendro.Beispiel1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Table {

    private List<Weapon> weapons;

    private String[] titles;
    private int[] spaces;

    public Table(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void print(){
        initTitles();
        setSpaces();
        final String separator = getSeparator();
        final String titleRow = getTitleRow();
        final String[] weaponRows = getWeaponRows();

        System.out.println(separator+"\n" +
                titleRow+"\n" +
                separator);
        Arrays.stream(weaponRows)
                .forEach(weaponRow -> {
                    System.out.println(weaponRow+"\n" +
                            separator);
                });
    }

    private void initTitles(){
        titles = new String[]{"name","combatType","damageType","damage","speed","strength","value"};
    }

    private void setSpaces(){
        spaces = new int[7];

        //NAME
        setSpace(0,weapon -> weapon.getName().length());
        //COMBATTYPE
        setSpace(1,weapon -> weapon.getCombatType().toString().length());
        //DAMAGETYPE
        setSpace(2,weapon -> weapon.getDamageType().toString().length());
        //DAMAGE
        setSpace(3,weapon -> Integer.toString(weapon.getDamage()).length());
        //SPEED
        setSpace(4,weapon -> Integer.toString(weapon.getSpeed()).length());
        //STRENGTH
        setSpace(5,weapon -> Integer.toString(weapon.getSpeed()).length());
        //VALUE
        setSpace(6,weapon -> Integer.toString(weapon.getValue()).length());

        for (int i = 0; i < spaces.length; i++) {
            if(spaces[i]<titles[i].length()){
                spaces[i]=titles[i].length();
            }
        }
    }

    private void setSpace(int index, Function<Weapon,Integer> function){
        spaces[index] = weapons.stream()
                .map(function)
                .max((length1,length2) -> length1-length2)
                .orElse(null);
    }

    private String getSeparator(){
        String separator = "+";
        for(int column = 0; column<7; column++){
            for(int i = -2; i<spaces[column];i++){
                separator+="-";
            }
            separator+="+";
        }
        return separator;
    }

    private String getTitleRow(){
        String title = "| ";
        for(int column = 0; column<7; column++){
            title+=titles[column];
            for(int i = 0; i<spaces[column]-titles[column].length();i++){
                title+=" ";
            }
            title+=" | ";
        }
        return title;
    }

    private String[] getWeaponRows(){
        return weapons.stream()
                .map(this::getWeaponRow)
                .toArray(String[]::new);
    }

    private String getWeaponRow(Weapon weapon){
        String[] weaponArgs = getWeaponArgs(weapon);

        String weaponRow = "| ";
        for (int column = 0; column<7; column++){
            weaponRow+=weaponArgs[column];
            for(int i = 0; i< spaces[column] - weaponArgs[column].length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" | ";
        }
        return weaponRow;
    }

    private String[] getWeaponArgs(Weapon weapon){
        return new String[]{
            weapon.getName(),
            weapon.getCombatType().toString(),
            weapon.getDamageType().toString(),
            Integer.toString(weapon.getDamage()),
            Integer.toString(weapon.getSpeed()),
            Integer.toString(weapon.getStrength()),
            Integer.toString(weapon.getValue())
        };
    }
}
