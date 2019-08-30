/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totito;

import java.util.Scanner;

/**
 *
 * @author asantos
 */
public class ToTiTo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here5
        String ch;

        do {
            new ToTiToLogica();
            System.out.println("Would you like to play again (Enter 'yes')? ");
            Scanner in = new Scanner(System.in);
            ch = in.nextLine();
            System.out.println("ch value is  " + ch);
        } while (ch.equals("yes"));
    }
}
