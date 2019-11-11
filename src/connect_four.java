import java.util.*;

public class connect_four {


    public static void main(String[] args) {

        //char o = O;
        //char anzahl= 0;
        int rowy = 0;
        int rowx = 0;
        int auswahl;

        Scanner input = new Scanner(System.in);
        // create an array with the size of the needed connect four field
        char[][] feld = new char[6][7];
        char[] anzahl = new char[7];
        for (int i = 0; i < 6; i++) {       //erzeugt array zum überprüfen wie viele Chips in einem Feld sind
            anzahl[i] = 5;
        }


        System.out.println("CONNECT FOUR\n");


            /* Hauptmenue */
            System.out.print("\n");
            System.out.print("-----------------------------------------------\n");
            System.out.print("1.  Start New Game\n");
            System.out.print("9.  Exit\n");
            System.out.print("-----------------------------------------------\n\n");
            System.out.print("Enter Your Choice :  ");
            auswahl = input.nextInt();

            if (auswahl == 9) System.exit(0);
            else
                {

                    startGame(feld,anzahl,rowx,rowy,input,auswahl);

                }




            /*
            showField(feld);
            PlayerX(feld, anzahl, rowx, rowy, input);
            showField(feld);
            check(feld, anzahl, rowx,auswahl);
            PlayerO(feld, anzahl, rowx, rowy, input);
            showField(feld);
            check(feld, anzahl, rowx,auswahl);
            */




    }

    private static void startGame(char[][] feld, char[] anzahl, int rowx, int rowy, Scanner input, int auswahl){

        do {
            showField(feld);
            PlayerX(feld, anzahl, rowx, rowy, input);
            showField(feld);
            check(feld, anzahl, rowx, auswahl);
            PlayerO(feld, anzahl, rowx, rowy, input);
            showField(feld);
            check(feld, anzahl, rowx, auswahl);
        }while(auswahl !=9);
    }

    public static void showField(char[][] feld) {
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
        System.out.print("PLAYER X");
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

    public static void check(char[][] feld, char[] anzahl, int rowx, int auswahl) {


        int count = 0;
        int i;

        for (i = 0; i < 6; i++) {           //Check for X
            for (int j = 0; j < 7; j++) {
                if (feld[i][j] == 'X')

                    count++;
                //System.out.println(count);

                if (count == 4) {

                    System.out.println("WINNER is Player X");
                    //auswahl =9;
                    System.exit(0);


                }
            }
        }

        count = 0;

        for (i = 0; i < 6; i++) {       //Check for O
            for (int j = 0; j < 7; j++) {
                if (feld[i][j] == 'O')

                    count++;
                //System.out.println(count);

                if (count == 4) {


                    System.out.println("WINNER is Player O");
                   // auswahl =9;
                    System.exit(0);

                }
            }
        }
    }
}
