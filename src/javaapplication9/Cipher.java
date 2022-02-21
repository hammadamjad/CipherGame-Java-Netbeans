/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.util.ArrayList;

/**
 *
 * @author hamma
 */
class Cipher extends Encrypt_and_Decrypt{
    
    public  void show_pairs(ArrayList<String> pairs) {
        System.out.println("Pairs:");
        for (String x : pairs) {
            System.out.println(x);
        }
    }

    public boolean check_capital_char(String str) {

        char[] chr = str.toCharArray();
        for (int i = 0; i < chr.length; i++) {

            if (!Character.isUpperCase(chr[i])
                        && (chr[i] >= 'a' && chr[i] <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public boolean qoute_enqoute_match(String encryp_qoute, String qoute) {
        if (encryp_qoute.equals(qoute.toUpperCase())) {
            return true;
        }
        return false;
    }

    public void make_truncated_lines(String peare_qoutes[]) {
        System.out.println("Choose a truncated line:");
        int count = 1;
        for (String l : peare_qoutes) {
            System.out.println(count + ". " + l.substring(0, 50));
            count++;
        }
    }

    public void show_win_loss(long time){
        if( time <= 0){
            System.out.println("\n\nSorry, not completed in time.");
        }
        else{
            System.out.println("\n\nYou won!!!!!!!!!!!!!");
            System.out.println("Score: "+ time);
        }
    }
}
