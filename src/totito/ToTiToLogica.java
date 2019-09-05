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
public class ToTiToLogica {

    private char[] tableroJuego = new char[10];
    private char JugadorActual;

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
        System.out.println("\t\t ___|___|___ ");
        System.out.println("\t\t" + "  " + tableroJuego[4] + " | " + tableroJuego[5] + " | " + tableroJuego[6]);
        System.out.println("\t\t ___|___|___ ");
        System.out.println("\t\t" + "  " + tableroJuego[7] + " | " + tableroJuego[8] + " | " + tableroJuego[9]);
        System.out.print(" \t\t    |   |   ");
    }

    private void jugar() {
        int posicion;
        char blank = ' ';

        System.out.println("Jugadr del primer moviento es " + getJugadorActual());
        dibujarTablero();
        do {
            System.out.print("\n\n  jugador " + getJugadorActual() + " elija una posicion -> ");

            boolean posTaken = true;
            while (posTaken) {
                try {
                    Scanner in = new Scanner(System.in);
                    posicion = in.nextInt();
                    posTaken = verificarPosicion(posicion);
                    if (!posTaken) {
                        tableroJuego[posicion] = getJugadorActual();
                    } else {
                        System.out.println("Esta posicion ya esta ocupada, Elije otra!");
                    }
                } catch (Exception e) {
                    System.out.println("Solo se admiten tipos numericos \nEntrada menor o igual a 9");
                    System.out.print(" -> jugador " + getJugadorActual() + " elija una posicion -> ");
                }
            }

            dibujarTablero();
            turnoJugador();

        } while (/*!verificarJugador2(getJugadorActual(), 1)*/verificarGanador() == blank);

    }

    private char verificarGanador() {
        char Ganador = ' ';

        //Verificacion de las X
        if (tableroJuego[1] == 'X' && tableroJuego[2] == 'X' && tableroJuego[3] == 'X') {
            Ganador = 'X';
        }
        if (tableroJuego[4] == 'X' && tableroJuego[5] == 'X' && tableroJuego[6] == 'X') {
            Ganador = 'X';
        }
        if (tableroJuego[7] == 'X' && tableroJuego[8] == 'X' && tableroJuego[9] == 'X') {
            Ganador = 'X';
        }
        if (tableroJuego[1] == 'X' && tableroJuego[4] == 'X' && tableroJuego[7] == 'X') {
            Ganador = 'X';
        }
        if (tableroJuego[2] == 'X' && tableroJuego[5] == 'X' && tableroJuego[8] == 'X') {
            Ganador = 'X';
        }
        if (tableroJuego[3] == 'X' && tableroJuego[6] == 'X' && tableroJuego[9] == 'X') {
            Ganador = 'X';
        }
        if (tableroJuego[1] == 'X' && tableroJuego[5] == 'X' && tableroJuego[9] == 'X') {
            Ganador = 'X';
        }
        if (tableroJuego[3] == 'X' && tableroJuego[5] == 'X' && tableroJuego[7] == 'X') {
            Ganador = 'X';
        }
        if (Ganador == 'X') {
            System.out.println("\n El jugador X gana el juego.");
            return Ganador;
        }

        // Verificacion de las O
        if (tableroJuego[1] == 'O' && tableroJuego[2] == 'O' && tableroJuego[3] == 'O') {
            Ganador = 'O';
        }
        if (tableroJuego[4] == 'O' && tableroJuego[5] == 'O' && tableroJuego[6] == 'O') {
            Ganador = 'O';
        }
        if (tableroJuego[7] == 'O' && tableroJuego[8] == 'O' && tableroJuego[9] == 'O') {
            Ganador = 'O';
        }
        if (tableroJuego[1] == 'O' && tableroJuego[4] == 'O' && tableroJuego[7] == 'O') {
            Ganador = 'O';
        }
        if (tableroJuego[2] == 'O' && tableroJuego[5] == 'O' && tableroJuego[8] == 'O') {
            Ganador = 'O';
        }
        if (tableroJuego[3] == 'O' && tableroJuego[6] == 'O' && tableroJuego[9] == 'O') {
            Ganador = 'O';
        }
        if (tableroJuego[1] == 'O' && tableroJuego[5] == 'O' && tableroJuego[9] == 'O') {
            Ganador = 'O';
        }
        if (tableroJuego[3] == 'O' && tableroJuego[5] == 'O' && tableroJuego[7] == 'O') {
            Ganador = 'O';
        }
        if (Ganador == 'O') {
            System.out.println("\n El jugador O gana el juego.");
            return Ganador;
        }

        for (int i = 1; i < 10; i++) {
            if (tableroJuego[i] == 'X' || tableroJuego[i] == 'O') {
                if (i == 9) {
                    char Draw = 'D';
                    System.out.println(" Game is stalemate ");
                    return Draw;
                }
            } else {
                break;
            }

        }

        return Ganador;
    }

    private boolean verificarJugador2(char jugador, int i) {
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

        if (!retorno && i == 1) {
            jugador = (jugador == 'X') ? 'O' : 'X';
            verificarJugador2(jugador, 2);
        }

        System.out.println("Ganador " + jugador);
        return retorno;
    }

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

    private String getTitle() {
        return "Tic Tac Toe";
    }

    private char getJugadorActual() {
        return JugadorActual;
    }
}
