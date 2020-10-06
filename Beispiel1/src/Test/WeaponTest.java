package Test;

import com.Infendro.Beispiel1.Main;
import com.Infendro.Beispiel1.Weapon;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @org.junit.jupiter.api.Test
    void sortDamage() {
        List<Weapon> weapons = Main.initWeapons();
        weapons = Main.sortDamage(weapons);

        for(int i = 0; i<weapons.size()-1; i++){
            if(weapons.get(i).getDamage()<weapons.get(i+1).getDamage()){
                fail("Sorting failed!");
            }
        }
    }

    @org.junit.jupiter.api.Test
    void sortCombatType_DamageType_Name() {
        List<Weapon> weapons = Main.initWeapons();
        weapons = Main.sortCombatType_DamageType_Name(weapons);

        for(int i = 0; i<weapons.size()-1; i++){
            Weapon w1 = weapons.get(i);
            Weapon w2 = weapons.get(i+1);

            int compare = w1.getCombatType().toString().compareTo(w2.getCombatType().toString());
            if(compare>0){
                fail("Sorting of CombatType failed!");
            }else if(compare==0){
                compare = w1.getDamageType().toString().compareTo(w2.getDamageType().toString());
                if(compare>0){
                    fail("Sorting of DamageType failed!");
                }else if(compare==0){
                    compare = w1.getName().compareTo(w2.getName());
                    if(compare>0){
                        fail("Sorting of Name failed!");
                    }
                }
            }
        }
    }

}