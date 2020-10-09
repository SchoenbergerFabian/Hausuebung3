/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Fabian
 */
public class RandomNumberArray {
    public int[] getRandomNumberArray(int amount, int min, int max){
        return Arrays.stream(new int[amount])
                .map(number -> getRandomNumber(min, max))
                .toArray();
    }
    
    private int getRandomNumber(int min, int max){
        Random random = new Random();
        return random.nextInt(max+min+1)-min;
    }
}
