
import kotlin.collections.unsigned.UArraysKt;

import java.util.Scanner;

public class proof_of_cocept {


    public static void main(String[] args) {
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println("| | | | | | | |");
        System.out.println("| | | | | | | |");
        System.out.println("| | | | | | | |");
        System.out.println("| | | | | | | |");
        System.out.println("| | | | | | | |");
        System.out.println("| | | | | | | |");

        // examples of coordinates in the array
        // (0/0) links unten
        // (6/0) rechts unten
        // (0/5) links oben
        // (6/5) rechts oben


        // create an array with the size of the needed connect four field
        char[][] feld = new char[6][7];

        // fill the complete array with 'X'
       /* for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                feld[i][j] = 'X';
            }
        }*/

        // print the complete array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(feld[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        // function call to print the given array
        showField(feld);

    }


    public static void showField (char[][] feld) {
        // Function that prints the field represented in an array

        System.out.println(" 1 2 3 4 5 6 7");

        // iterate trough the array and print each element (' ', 'X' or 'O')
        // separated with "|"
        for (int x = 0; x < 6; x++) {
            System.out.print("|");
            for (int y = 0; y < 7; y++) {
                System.out.print(feld[x][y]);
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }


    public static void PlayerX(char[][] feld, char[] anzahl, int rowx, int rowy, Scanner input) {
        System.out.print("\nPLAYER X");
        System.out.print("\nWhich ROW ? "); //X
        rowx = input.nextInt();
        //System.out.print("\nWhich Hight ?"); //Y
        //rowy = input.nextInt();
        if (rowx <= 7) {
            //rowy = rowy - 1;   //Y
            rowx = rowx - 1;  //X


            //char y = anzahl[rowy];
            //char y = ((char) rowy);
            char x = ((char) rowx);
            feld[anzahl[rowx]][x] = 'X';
            //i = (char) (i + 1);
            anzahl[rowx]--;

        }
    }

    public static void PlayerO(char[][] feld, char[] anzahl, int rowx, int rowy, Scanner input) {
        System.out.print("PLAYER O");
        System.out.print("\nWhich ROW ? "); //X
        rowx = input.nextInt();
        //System.out.print("\nWhich Hight ?"); //Y
        //rowy = input.nextInt();
        if (rowx <= 7) {
            //rowy = rowy - 1;   //Y
            rowx = rowx - 1;  //X


            //char y = anzahl[rowy];
            //char y = ((char) rowy);
            char x = ((char) rowx);
            feld[anzahl[rowx]][x] = 'O';
            //i = (char) (i + 1);
            anzahl[rowx]--;

        }
    }









}
