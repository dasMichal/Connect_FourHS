import java.util.Scanner;

public class connect_four {


    public static void main(String[] args) {

        //char x = X;
        //char o = O;
        //char anzahl= 0;
        int rowy = 0;
        int rowx = 0;
        Scanner input = new Scanner(System.in);
        // create an array with the size of the needed connect four field
        char[][] feld = new char[6][7];
        char[] anzahl = new char[7];

        System.out.println("CONNECT FOUR\n");

        for (int i = 0; i < 6; i++) {
            anzahl[i] = 0;
        }



        do {
            System.out.print("\nWhich ROW ?"); //X
            rowx = input.nextInt();
            //System.out.print("\nWhich Hight ?"); //Y
            //rowy = input.nextInt();
            if ((rowy <= 6) && (rowx <= 7)) {
                rowy = rowy - 1;   //Y
                rowx = rowx - 1;  //X
                char i = 0;
                anzahl[rowx] = i;

                anzahl[rowx] = i;
                //char y = anzahl[rowy];
                char y = ((char) rowy);
                char x = ((char) rowx);
                feld[i][x] = 'X';
                i = (char) (i + 1);

            }
            showField(feld);
        }while(rowx !=9);


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
}
