package totito;

import java.util.Scanner;

/**
 * Programa ToTiTo / Tic Tac Toe
 * @author asantos
 * Fecha 11/09/2019
 * Ingenieria En Sitemas
 * Programacion Avanzada
 */
public class ToTiTo {

    /**
     * Instacia de nuestra clase ToTiToLogica
     * asi como el ciclo donde estara repitiendo
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here5
        String seleccion;
        Scanner in = new Scanner(System.in);
        
        do {
            new ToTiToLogica();
            System.out.println("Quieres seguir jugando (Enter 'y')? ");
            seleccion = in.nextLine();
        } while (seleccion.equals("y"));
    }
}
