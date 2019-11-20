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

        for (int i = 0; i <= anzahl.length; i++) {       // Fills the Check Array with the Number 5  max Horizontal = 5 Chips
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

    private static void startGame(char[][] feld, char[] anzahl, int rowx, int rowy, Scanner input, int auswahl) {

        int playerID = 0;                                       //Number to distinguish between P1 & P2 turn (Modulo)
        do {
            showField(feld);                                    //Calls the Methode to show the GameGrid
            //PlayerX(feld, anzahl, rowx, rowy, input);
            Player(feld, anzahl, rowx, rowy,playerID, input);   //Calls the Method to let the Player Input
            showField(feld);
            check(feld, anzahl, rowx, auswahl);                 //Check if a win condition is present
            //Player(feld, anzahl, rowx, rowy,playerID, input);
            //PlayerO(feld, anzahl, rowx, rowy, input);
            //showField(feld);
            //check(feld, anzahl, rowx, auswahl);
            clearScreen();                                      //
            playerID++;                                        //increasing Number to distinguish between P1 & P2
        } while (auswahl != 9);
    }

    public static void showField(char[][] feld) {
        // Function that prints the field represented in an array
        System.out.print("\n\n");
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

    /* input für player 1 oder 2. int player (kann 1 oder 2 sein) */
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

    public static void Player(char[][] feld, char[] anzahl, int rowx, int rowy, int playerID, Scanner input) {

        if ((playerID % 2) == 0)
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

        //TODO -Checking Horizontal
        //TODO -Cleanup of code
    public static void check ( char[][] feld, char[] anzahl, int rowx, int auswahl){


            int count = 0;
            int i;

            for (i = 0; i < 6; i++) {           //Check for X
                for (int j = 0; j < 7; j++) {
                    if (feld[i][j] == 'X')

                        count++;
                        //System.out.println(count);
                    else if (feld[i][j] == 'O') count = 0;
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
                    if (feld[i][j] == 'X') count = 0;
                    if (count == 4) {


                        System.out.println("WINNER is Player O");
                        // auswahl =9;
                        System.exit(0);

                    }
                }
            }
        }

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n");
        System.out.print("\u001b[H\u001b[2J");
        //System.out.flush();
    }

    public static void validInput(char[][] feld, char[] anzahl, int rowx, int rowy)
    {
        try
        {
            rowx = rowx - 1;  //X


            char x = ((char) rowx);
            feld[anzahl[rowx]][x] = 'X';
        }catch(Exception e) {

        }

}






}

