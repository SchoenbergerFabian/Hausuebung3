package Test;

import com.Infendro.Beispiel1.Main;
import com.Infendro.Beispiel1.Weapon;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @org.junit.jupiter.api.Test
    void sortMaxToMinDamage() {
        List<Weapon> weapons = Main.initWeapons();
        weapons = Weapon.sortMaxToMinDamage(weapons);

        for(int i = 0; i<weapons.size()-1; i++){
            if(weapons.get(i).getDamage()>weapons.get(i+1).getDamage()){
                fail("Sorting failed!");
            }
        }
    }
}