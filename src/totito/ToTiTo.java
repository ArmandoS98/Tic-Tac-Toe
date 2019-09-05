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
    public static void main(String[] args) {
        // TODO code application logic here5
        String ch;
        do {
            new ToTiToLogica();
            System.out.println("Quieres seguir jugando (Enter 'y')? ");
            Scanner in = new Scanner(System.in);
            ch = in.nextLine();
        } while (ch.equals("y"));
    }
}
