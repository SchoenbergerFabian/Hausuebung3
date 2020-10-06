package com.Infendro.Beispiel1;

import java.util.List;

public class Print {

    private Printable printNormal = weapons -> {
        weapons.forEach(System.out::println);
    };

    private Printable printTable = weapons -> {
        //SPACES
        //NAME
        int spacesName = weapons.stream()
                .map(weapon -> weapon.getName().length())
                .max((length1,length2)->length1-length2)
                .get();
        if(spacesName<=4){
            spacesName = 4;
        }
        //COMBATTYPE
        int spacesCombatType = weapons.stream()
                .map(weapon -> weapon.getCombatType().toString().length())
                .max((length1,length2)->length1-length2)
                .get();
        if(spacesCombatType<=10){
            spacesCombatType = 10;
        }
        //DAMAGETYPE
        int spacesDamageType = weapons.stream()
                .map(weapon -> weapon.getDamageType().toString().length())
                .max((length1,length2)->length1-length2)
                .get();
        if(spacesDamageType<=10){
            spacesDamageType = 10;
        }
        //DAMAGE
        int spacesDamage = weapons.stream()
                .map(weapon -> Integer.toString(weapon.getDamage()).length())
                .max((length1,length2)->length1-length2)
                .get();
        if(spacesDamage<=6){
            spacesDamage = 6;
        }
        //SPEED
        int spacesSpeed = weapons.stream()
                .map(weapon -> Integer.toString(weapon.getSpeed()).length())
                .max((length1,length2)->length1-length2)
                .get();
        if(spacesSpeed<=5){
            spacesSpeed = 5;
        }
        //STRENGTH
        int spacesStrength = weapons.stream()
                .map(weapon -> Integer.toString(weapon.getSpeed()).length())
                .max((length1,length2)->length1-length2)
                .get();
        if(spacesStrength<=8){
            spacesStrength = 8;
        }
        //VALUE
        int spacesValue = weapons.stream()
                .map(weapon -> Integer.toString(weapon.getValue()).length())
                .max((length1,length2)->length1-length2)
                .get();
        if(spacesValue<=5){
            spacesValue = 5;
        }

        //SEPARATOR
        String separator = "+";
        for(int i = -2; i<spacesName;i++){
            separator+="-";
        }
        separator+="+";
        for(int i = -2; i<spacesCombatType;i++){
            separator+="-";
        }
        separator+="+";
        for(int i = -2; i<spacesDamageType;i++){
            separator+="-";
        }
        separator+="+";
        for(int i = -2; i<spacesDamage;i++){
            separator+="-";
        }
        separator+="+";
        for(int i = -2; i<spacesSpeed;i++){
            separator+="-";
        }
        separator+="+";
        for(int i = -2; i<spacesStrength;i++){
            separator+="-";
        }
        separator+="+";
        for(int i = -2; i<spacesValue;i++){
            separator+="-";
        }
        separator+="+";

        //TITLEROW
        String title = "| name";
        for(int i = 0; i<spacesName-4;i++){
            title+=" ";
        }
        title+=" | combatType";
        for(int i = 0; i<spacesCombatType-10;i++){
            title+=" ";
        }
        title+=" | damageType";
        for(int i = 0; i<spacesDamageType-10;i++){
            title+=" ";
        }
        title+=" | damage";
        for(int i = 0; i<spacesDamage-6;i++){
            title+=" ";
        }
        title+=" | speed";
        for(int i = 0; i<spacesSpeed-5;i++){
            title+=" ";
        }
        title+=" | strength";
        for(int i = 0; i<spacesStrength-8;i++){
            title+=" ";
        }
        title+=" | value";
        for(int i = 0; i<spacesValue-5;i++){
            title+=" ";
        }
        title+=" |";

        //PRINT
        System.out.println(separator+"\n" +
                title + "\n" +
                separator);

        //FINAL VARIABLES FOR LAMBDA
        int finalSpacesName = spacesName;
        int finalSpacesCombatType = spacesCombatType;
        int finalSpacesDamageType = spacesDamageType;
        int finalSpacesDamage = spacesDamage;
        int finalSpacesSpeed = spacesSpeed;
        int finalSpacesStrength = spacesStrength;
        int finalSpacesValue = spacesValue;
        String finalSeparator = separator;
        weapons.forEach(weapon -> {
            //WEAPONROW
            String weaponRow = "| "+weapon.getName();
            for(int i = 0; i< finalSpacesName - weapon.getName().length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" | "+weapon.getCombatType().toString();
            for(int i = 0; i< finalSpacesCombatType - weapon.getCombatType().toString().length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" | "+weapon.getDamageType().toString();
            for(int i = 0; i< finalSpacesDamageType - weapon.getDamageType().toString().length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" | "+weapon.getDamage();
            for(int i = 0; i< finalSpacesDamage - Integer.toString(weapon.getDamage()).length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" | "+weapon.getSpeed();
            for(int i = 0; i< finalSpacesSpeed - Integer.toString(weapon.getSpeed()).length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" | "+weapon.getStrength();
            for(int i = 0; i< finalSpacesStrength - Integer.toString(weapon.getStrength()).length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" | "+weapon.getValue();
            for(int i = 0; i< finalSpacesValue - Integer.toString(weapon.getValue()).length(); i++){
                weaponRow+=" ";
            }
            weaponRow+=" |";

            //PRINT
            System.out.println(weaponRow+"\n" +
                    finalSeparator);
        });
    };

    public void printNormal(List<Weapon> weapons){
        printNormal.print(weapons);
    }

    public void printTable(List<Weapon> weapons){
        printTable.print(weapons);
    }

    public void setPrintNormal(Printable printNormal) {
        this.printNormal = printNormal;
    }

    public void setPrintTable(Printable printTable) {
        this.printTable = printTable;
    }
}
