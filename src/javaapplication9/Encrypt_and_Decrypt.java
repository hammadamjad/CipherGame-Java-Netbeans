/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hamma
 */

class Encrypt_and_Decrypt{

    public String encrypt(String qoute) {
        String encryp_qoute = "";
        char letter;
        for (int i = 0; i < qoute.length(); i++) {
            
            letter = Character.toLowerCase(qoute.charAt(i));

            
            if (letter >= 'a' && letter <= 'z') {
                
                letter = (char) (letter + 3);
               
                if (letter > 'z') {
                    
                    letter = (char) (letter + 'a' - 'z' - 1);
                }
                encryp_qoute = encryp_qoute + letter;
            } else {
                encryp_qoute = encryp_qoute + letter;
            }
        }
        return encryp_qoute;
    }

    public String decrypt(String encryp_qoute, char pair_char_1, char pair_char_2, ArrayList<String> pairs) {
        if (pair_char_1 == pair_char_2) {
            return encryp_qoute;
        }
        
        if (encryp_qoute.contains(pair_char_2+"".toUpperCase())) {
            for (String el : pairs) {
                if (el.charAt(2) == Character.toUpperCase(pair_char_2)) {

                    encryp_qoute = encryp_qoute.replaceAll(el.charAt(2)+"",el.charAt(0)+"");

                    pairs.remove(el);
                    break;
                }
            }
        }

        for(String el : pairs){
            if(el.charAt(0) == pair_char_1){
                pairs.remove(el);
                break;
            }
        }

        pairs.add(pair_char_1 + ">" + Character.toUpperCase(pair_char_2));

        return encryp_qoute.replaceAll(pair_char_1+"", (pair_char_2+"").toUpperCase());

    }

    public  String pc_help(String encryp_qoute, ArrayList<String> pairs) {

        //random for random character in string.
        Random rand = new Random();

        //generating a random character.
        char letter = (char) ('a' + rand.nextInt(26));

        //checking if character exists in encrypted quote.
        while(!encryp_qoute.contains(letter+"")){
            
            letter = (char) ('a' + rand.nextInt(26));
        }

        //getting the character to replace with.
        char chr_replace = (char) (letter - 3);

        if(chr_replace < 'a') {
            //reshift to starting position
            chr_replace = (char) (chr_replace-'a'+'z'+1);
        }

        //adding pair to array list.
        pairs.add(letter + ">" + Character.toUpperCase(chr_replace));

        //making changes to new character and returning it.
        return encryp_qoute.replaceAll(letter+"", (chr_replace+"").toUpperCase());

    }

}
