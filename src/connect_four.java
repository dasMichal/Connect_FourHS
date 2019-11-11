import java.util.Scanner;

public class connect_four {


    public static void main(String[] args) {

        //char x = X;
        //char o = O;

        int row = 0;
        Scanner input = new Scanner(System.in);
        // create an array with the size of the needed connect four field
        char[][] feld = new char[6][7];

        System.out.println("CONNECT FOUR\n");






        System.out.print("\nWhich ROW ?");
        row = input.nextInt();
        if (row<=6) {

            char x = ((char) row);
            feld[x][0] = 'X';
        }

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
