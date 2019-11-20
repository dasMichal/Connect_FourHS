import java.util.*;

public class connect_four {


    public static void main(String[] args) {

        //--------------------------

        //declaring Variables

        //char o = O;
        //char anzahl= 0;
        int rowy = 0;
        int rowx = 0;
        int auswahl;


        Scanner input = new Scanner(System.in);         //importing Scanner
        // create an array with the size of the needed connect four field
        char[][] feld = new char[6][7];                 //Creating the Game Grid
        char[] anzahl = new char[7];                    //Creating a Check Array to count how many chips are in the horizontl Array

        for (int i = 0; i < anzahl.length; i++) {       // Fills the Check Array with the Number 5 => max Horizontal = 5 Chips
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
        else {
            startGame(feld, anzahl, rowx, rowy, input, auswahl);            //Starting Game Instance
        }
    }

    private static void startGame(char[][] feld, char[] anzahl, int rowx, int rowy, Scanner input, int auswahl) {

        int playerID = 0;                                       //Number to distinguish between P1 & P2 turn (Modulo)
        do {
            showField(feld);                                    //Calls the Methode to show the GameGrid
            Player(feld, anzahl, rowx, rowy,playerID, input);   //Calls the Method to let the Player Input
            showField(feld);
            check2(feld, anzahl);                               //Check if a win condition is present
            playerID++;                                        //increasing Number to distinguish between P1 & P2
        } while (rowx != 42);
    }

    public static void showField(char[][] feld) {
        // Function that prints the field represented in an array
        System.out.print("\n\n");
        System.out.println(" 1 2 3 4 5 6 7");

        // iterate trough the array and print each element (' ', 'X' or 'O')
        // separated with "|"
        for (int y = 0; y < 6; y++) {
            System.out.print("|");
            for (int x = 0; x < 7; x++) {
                System.out.print(feld[y][x]);
                System.out.print("|");
            }
            System.out.print("\n");
        }


    }


    private static void Player(char[][] feld, char[] anzahl, int rowx, int rowy, int playerID, Scanner input) {

        if ((playerID % 2) == 0)                //Check if its Player X or Player O turn
        {

            System.out.print("\nPLAYER X");
            System.out.print("\nWhich ROW ? "); //X
            rowx = input.nextInt();
            //System.out.print("\nWhich Hight ?"); //Y
            //rowy = input.nextInt();

            if (rowx <= 7)
            {
                //rowy = rowy - 1;   //Y
                rowx = rowx - 1;  //X


                //char y = anzahl[rowy];
                //char y = ((char) rowy);
                char x = ((char) rowx);
                feld[anzahl[rowx]][x] = 'X';
                //i = (char) (i + 1);
                anzahl[rowx]--;
            }



        } else

        {

            System.out.print("PLAYER O");
            System.out.print("\nWhich ROW ? "); //X
            rowx = input.nextInt();
            //System.out.print("\nWhich Hight ?"); //Y
            //rowy = input.nextInt();
            if (rowx <= 7)
            {
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


    private static void check2(char[][] feld, char[] anzahl) {

        int counterx = 0;
        int countero = 0;

        for (int x = 0; x < 7; x++) {
            for (int y = 5; y >= 0; y--) {

                if (feld[y][x] == 'X')      /*Checking for X Horizontal*/ {
                    countero = 0;
                    counterx++;
                }
                if (feld[y][x] == 'O')         //Reseting Counter X when findeing a O
                {
                    counterx = 0;
                }
                if (counterx >= 4) {
                    System.out.println("WINNER is Player X Horizontal");
                    //auswahl =9;
                    System.exit(0);

                }
            }
            //counterx=0;
        }
        counterx = 0;

        for (int y = 5; y >= 0; y--) {
            counterx = 0;
            for (int x = 0; x < 7; x++) {
                if (feld[y][x] == 'X')      /*Checking for X Vertical*/ {
                    countero = 0;
                    counterx++;
                }
                if (feld[y][x] == 'O')         //Reseting Counter X when findeing a O
                {
                    counterx = 0;
                }
                if (counterx >= 4) {
                    System.out.println("WINNER is Player X Vertical");
                    //auswahl =9;
                    System.exit(0);

                }
            }
        }

        for (int x = 0; x < 7; x++) {
            for (int y = 5; y >= 0; y--) {

                if (feld[y][x] == 'X')      /*Checking for X Diagonal*/ {
                    countero = 0;
                    counterx++;

                    do {

                        if (feld[y - 1][x + 1] == 'X') counterx++;
                        else counterx = 0;

                    } while (counterx != 4);

                }
                if (feld[y][x] == 'O')         //Reseting Counter X when findeing a O
                {
                    counterx = 0;
                }
                if (counterx >= 4) {
                    System.out.println("WINNER is Player X Horizontal");
                    //auswahl =9;
                    System.exit(0);

                }
            }


            for (x = 0; x < 7; x++) {
                for (int y = 0; y < 6; y++) {

                    if (feld[y][x] == 'O')      //Checking for O Horizontal
                    {
                        counterx = 0;
                        countero++;
                    }
                    if (feld[y][x] == 'X')      //reset counter O when found X
                    {
                        countero = 0;
                    }
                    if (countero >= 4) {
                        System.out.println("WINNER is Player O Horizontal");
                        //auswahl =9;
                        System.exit(0);

                    }
                }
            }


            for (int y = 5; y >= 0; y--) {
                countero = 0;
                for (x = 0; x < 7; x++) {
                    if (feld[y][x] == 'O')      /*Checking for O Vertical*/ {
                        counterx = 0;
                        countero++;
                    }
                    if (feld[y][x] == 'X')         //Reseting Counter O when findeing a X
                    {
                        countero = 0;
                    }
                    if (countero >= 4) {
                        System.out.println("WINNER is Player O Vertical");
                        //auswahl =9;
                        System.exit(0);

                    }
                }
            }

        }


    }
}
