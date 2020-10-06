/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;

/**
 *
 * @author Fabian
 */
public class RandomStringArray {
    public String[] getRandomStringArray(int amount,int length){
        return Arrays.stream(new String[amount])
                .map(string -> getRandomString(length))
                .toArray(String[]::new);
    }
    
    private String getRandomString(int length){
        String string = "";
        for (int i = 0; i < length; i++) {
            string += getRandomASCIICharacter();
        }
        return string;
    }
    
    private char getRandomASCIICharacter(){
        return (char) ((int)(Math.random()*26)+26);
    }
}
