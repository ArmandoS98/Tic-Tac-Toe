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

    private int counter;
    private char[] tableroJuego = new char[10];
    private char JugadorActual;

    public ToTiToLogica() {
        newBoard();
        play();
    }

    private void newBoard() {
        char posndef[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        counter = 0;
        JugadorActual = 'X';
        for (i = 1; i < 10; i++) {
            tableroJuego[i] = posndef[i];
        }
    }

    private String currentBoard() {
        System.out.print("\n");
        System.out.println("\t\t" + "  " + tableroJuego[1] + " | " + tableroJuego[2] + " | " + tableroJuego[3]);
        System.out.println("\t\t ___|___|___ ");
        System.out.println("\t\t" + "  " + tableroJuego[4] + " | " + tableroJuego[5] + " | " + tableroJuego[6]);
        System.out.println("\t\t ___|___|___ ");
        System.out.println("\t\t" + "  " + tableroJuego[7] + " | " + tableroJuego[8] + " | " + tableroJuego[9]);
        System.out.print(" \t\t    |   |   ");
        return "currentBoard";
    }

    private void play() {
        int spot;
        char blank = ' ';

        System.out.println("Player " + getPlayer() + " will go first and be the letter 'X'");
        currentBoard();
        do {
            // display current board

            System.out.println("\n\n Player " + getPlayer() + " choose a posn.");

            boolean posTaken = true;
            while (posTaken) {
                // System.out.println( "position is taken, please enter a valid space");
                Scanner in = new Scanner(System.in);
                spot = in.nextInt();
                posTaken = checkPosn(spot);
                if (!posTaken) {
                    tableroJuego[spot] = getPlayer();
                } else {
                    System.out.println("That posn is already taken, please choose another");
                }
            }

            System.out.println("Nice move.");

            currentBoard();              // display current board

            nextPlayer();
        } while (checkWinner() == blank);

    }

    private char checkWinner() {
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
            System.out.println("Player1 wins the game.");
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
            System.out.println("Player2 wins the game.");
            return Ganador;
        }

        // check for Tie
        for (int i = 1; i < 10; i++) {
            if (tableroJuego[i] == 'X' || tableroJuego[i] == 'O') {
                if (i == 9) {
                    char Draw = 'D';
                    System.out.println(" Game is stalemate ");
                    return Draw;
                }
                continue;
            } else {
                break;
            }

        }

        return Ganador;
    }

    private boolean checkPosn(int spot) {

        if (tableroJuego[spot] == 'X' || tableroJuego[spot] == 'O') {
            return true;
        } else {
            return false;
        }

    }

    private void nextPlayer() {
        if (JugadorActual == 'X') {
            JugadorActual = 'O';
        } else {
            JugadorActual = 'X';
        }

    }

    private String getTitle() {
        return "Tic Tac Toe";
    }

    private char getPlayer() {
        return JugadorActual;
    }
}
