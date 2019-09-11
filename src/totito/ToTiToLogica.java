package totito;

import java.util.Scanner;

/**
 * Programa ToTiTo / Tic Tac Toe
 *
 * @author asantos 
 * Fecha 11/09/2019 
 * Ingenieria En Sitemas 
 * Programacion Avanzada
 */
public class ToTiToLogica {

    private char[] tableroJuego = new char[10];
    private char JugadorActual;

    private String nombreJugadorX = "";
    private String nombreJugadorY = "";

    public ToTiToLogica() {
        inicializarTablero();
        jugar();
    }

    private void inicializarTablero() {
        char posndef[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        JugadorActual = 'X';
        for (i = 1; i < 10; i++) {
            tableroJuego[i] = posndef[i];
        }
    }

    private void dibujarTablero() {
        System.out.print("\n");
        System.out.println("\t\t" + "  " + tableroJuego[1] + " | " + tableroJuego[2] + " | " + tableroJuego[3]);
        System.out.println("\t\t ---|---|--- ");
        System.out.println("\t\t" + "  " + tableroJuego[4] + " | " + tableroJuego[5] + " | " + tableroJuego[6]);
        System.out.println("\t\t ---|---|--- ");
        System.out.print("\t\t" + "  " + tableroJuego[7] + " | " + tableroJuego[8] + " | " + tableroJuego[9]);
        //System.out.print(" \t\t    |   |   ");
    }

    /**
     * Logica Principal del Juego.
     */
    private void jugar() {
        int posicion = 0;
        String posicionJugadorX = "";
        String posicionJugadorY = "";
        Scanner in = new Scanner(System.in);

        System.out.println("TO-TI-TO");
        System.out.print("Nombre Jugador X -> ");
        nombreJugadorX = in.nextLine();
        System.out.print("Nombre Jugador Y -> ");
        nombreJugadorY = in.nextLine();

        System.out.println(nombreJugadorX + " vs " + nombreJugadorY);
        //System.out.println("Jugadr del primer moviento es " + getJugadorActual());
        dibujarTablero();

        //Ciclo en el cual se repite hasta que no haya mas espacion o bien cuando uno de los 2 jugadores gane!
        do {
            System.out.print("\n\n  jugador " + getJugadorActual() + " elija una posicion -> ");

            boolean posTaken = true;
            while (posTaken) {
                try {
                    posicion = in.nextInt();
                    posTaken = verificarPosicion(posicion);
                    if (!posTaken) {
                        tableroJuego[posicion] = getJugadorActual();
                    } else {
                        System.out.print("\nEsta posicion ya esta ocupada, Elije otra -> ");
                    }
                } catch (Exception e) {
                    System.out.println("Solo se admiten tipos numericos \nEntrada menor o igual a 9");
                    System.out.print(" -> jugador " + getJugadorActual() + " elija una posicion -> ");
                }
            }

            //System.out.println(posicion);
            if (getJugadorActual() == 'X') {
                posicionJugadorX += String.valueOf(posicion) + ", ";
                //System.out.println(posicionJugadorX);
            } else {
                posicionJugadorY += String.valueOf(posicion) + ", ";
                //System.out.println(posicionJugadorY);
            }

            dibujarTablero();
            turnoJugador();

        } while (!hayGanador('X') /*verificarGanador() == blank*/);

        //System.out.println(posicionJugadorX.length());
        //System.out.println(posicionJugadorY.length());
        // System.out.println(posicionJugadorX.substring(0, (posicionJugadorX.length() - 2)));
        System.out.println("------------Movimientos-------------");
        System.out.println("Mov. de X en posiciones -> [" + posicionJugadorX.substring(0, (posicionJugadorX.length() - 2)) + "]");
        System.out.println("Mov. de O en posiciones -> [" + posicionJugadorY.substring(0, (posicionJugadorY.length() - 2)) + "]");
        System.out.println("------------------------------------");
    }

    /**
     * Validacion del ganador o Emparte
     *
     * @param jugador puede ser [X/O]
     * @return falso o verdadero
     */
    private boolean hayGanador(char jugador/*, int i*/) {
        boolean retorno = false;

        //Verificacion de las X
        if (tableroJuego[1] == jugador && tableroJuego[2] == jugador && tableroJuego[3] == jugador) {
            retorno = true;
        }
        if (tableroJuego[4] == jugador && tableroJuego[5] == jugador && tableroJuego[6] == jugador) {
            retorno = true;
        }
        if (tableroJuego[7] == jugador && tableroJuego[8] == jugador && tableroJuego[9] == jugador) {
            retorno = true;
        }
        if (tableroJuego[1] == jugador && tableroJuego[4] == jugador && tableroJuego[7] == jugador) {
            retorno = true;
        }
        if (tableroJuego[2] == jugador && tableroJuego[5] == jugador && tableroJuego[8] == jugador) {
            retorno = true;
        }
        if (tableroJuego[3] == jugador && tableroJuego[6] == jugador && tableroJuego[9] == jugador) {
            retorno = true;
        }
        if (tableroJuego[1] == jugador && tableroJuego[5] == jugador && tableroJuego[9] == jugador) {
            retorno = true;
        }
        if (tableroJuego[3] == jugador && tableroJuego[5] == jugador && tableroJuego[7] == jugador) {
            retorno = true;
        }

        if (retorno) {
            System.out.println("\n--------------Ganador---------------");
            System.out.println("\t     Ganador " + jugador);
            System.out.println("------------------------------------\n");
        } else if (jugador == 'X') {
            retorno = hayGanador('O');
            if (!retorno) {
                retorno = hayEmpate();
            }
        }
        return retorno;
    }

    /**
     * Validar que la posicion no este ocupada
     *
     * @param spot recibe el numero ingresado por el usuario
     * @return falso o verdadero
     */
    private boolean verificarPosicion(int spot) {
        if (tableroJuego[spot] == 'X' || tableroJuego[spot] == 'O') {
            return true;
        } else {
            return false;
        }

    }

    private void turnoJugador() {
        if (JugadorActual == 'X') {
            JugadorActual = 'O';
        } else {
            JugadorActual = 'X';
        }

    }

    private char getJugadorActual() {
        return JugadorActual;
    }

    private boolean hayEmpate() {
        boolean retorno = false;
        for (int i = 1; i < 10; i++) {
            if (tableroJuego[i] == 'X' || tableroJuego[i] == 'O') {
                if (i == 9) {
                    System.out.println("\n Empate");
                    retorno = true;
                }
            } else {
                break;
            }
        }
        return retorno;
    }

}
