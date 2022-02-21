/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CipherMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //to generate random values.
        Random rand = new Random();

        //ArrayList of String type which saves pairs.
        ArrayList<String> pairs = new ArrayList<>();

        Cipher cipher = new Cipher();

        char pair_char_1, pair_char_2;

        long time_start,time_end;

        //contains line.
        String qoute = "";

        //contains encrypted version of actual line.
        String encryp_qoute = "";

        //max help is 5 and it will decrease whenever the user ask help.
        int no_help_remaining = 0;

        //used shakespearre qoutes.
        String peare_qoutes[] = {
            "Life’s but a walking shadow, a poor player, that struts and frets his hour upon the stage, and then is heard no more; it is a tale told by an idiot, full of sound and fury, signifying nothing.\n",
            "Doubt thou the stars are fire, doubt that the sun doth move. Doubt truth to be a liar, but never doubt I love.I am one who loved not wisely but too well.They do not love that do not show their love.\n",
            "Love is heavy and light, bright and dark, hot and cold, sick and healthy, asleep and awake.Shall I compare thee to a summer’s day? Thou art more lovely and more temperate.\n",
            "Did my heart love till now? Forswear it, sight! For I ne’er saw true beauty till this night. Love alters not with his brief hours and weeks, but bears it out even to the edge of doom.\n",
            "Good night, good night! Parting is such sweet sorrow, that I shall say good night till it be morrow. Love is not love which alters when it alteration finds.\n",
            "I can see that he’s not in your good books,’ said the messenger. ‘No, and if he were I would burn my library. God has given you one face, and you make yourself another.\n"
        };
        

        //Menu
        System.out.println("______________Welcome to the CIPHER Game_______________ \n");
        System.out.println("\n 1 - Normal Mode");
        System.out.println("2 - Test Mode\n");

        int choice = scan.nextInt();

        //switch for modes as there are 2 modes.
        switch(choice){
            case 1:
                int index = rand.nextInt(5 - 0);
                qoute = peare_qoutes[index];
            break;
            
            case 2:
                cipher.make_truncated_lines(peare_qoutes);
                choice = scan.nextInt();
                qoute = peare_qoutes[choice-1].substring(0, 50);
            break;
            
        }

        encryp_qoute = cipher.encrypt(qoute);

        String input = "";

        System.out.println("Paragraph after encryption: \n" + encryp_qoute);

        //note time at start of game.
        time_start = System.currentTimeMillis();

        do{
            input = "";
            System.out.println("Enter user input: ");
            input = scan.next();

            if (input.equals("help")) {

                if (no_help_remaining == 50) {
                    System.out.println("\nOut of Helps...\n");
                }

                else {
                    
                    encryp_qoute = cipher.pc_help(encryp_qoute, pairs);

                    no_help_remaining += 1;

                    System.out.println("\n" + (5 - no_help_remaining) + " help's are left.\n");
                }
            }
            else if(input.equals("reset")){

                //renewing the encrypted qoute
                encryp_qoute = cipher.encrypt(qoute);

                //removing all pairs.
                pairs.clear();

                //help back to start.
                no_help_remaining= 0;

                System.out.println("\n\nAll of is Reset....\n");

            }
            else {
                pair_char_1 = input.charAt(0);
                pair_char_2 = input.charAt(1);

                encryp_qoute = cipher.decrypt(encryp_qoute, pair_char_1, pair_char_2, pairs);
            }

            System.out.println("State of Paragraph: \n" + encryp_qoute + "\n");

            cipher.show_pairs(pairs);

            if (cipher.qoute_enqoute_match(encryp_qoute, qoute) || cipher.check_capital_char(encryp_qoute)) {
                //note time at end of game.
                time_end = System.currentTimeMillis();
                break;
            }
        }while (true);

        long total_time = 1000 - ((time_end-time_start)/1000);

        cipher.show_win_loss(total_time);

        scan.close();

    }

}


