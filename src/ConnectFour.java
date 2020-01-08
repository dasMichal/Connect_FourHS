//package ConnectFour;

import java.util.Scanner;

public class ConnectFour {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // create an array with the size of the needed connect four field
        char[][] array = new char[6][7];

        // fill the complete array with ' ' (empty)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                array[i][j] = ' ';
            }
        }

        int player;
        int column;
        int playerID = 0;

        // execute loop while no one has won yet
        while (playerWins(array) == 0) {
            showField(array);

            column = 0;
            // this loop executes until the user gives a legal input for a column (1-7)
            do {
                System.out.print("player[1|2] column [1-7]: ");

                if ((playerID % 2) == 0)
                {
                    player = 1;
                }else player =2;

                //player = input.nextInt();
                column = input.nextInt();

                // user gives a invalid column
                if (column <= 0 || column > 7) {
                    System.out.println("Invalid input. Column must be between 1-7!");
                }

                // user wants to place in a column that is already full
                else if (columnFull(column - 1, array)) {
                    System.out.println("Column is full! Choose another one.");
                    column = 0;
                }

            } while (column <=  0 || column > 7);

            insertChip(player, column, array);
            playerID ++;
        }

        showField(array);

        if (playerWins(array) == 1) {
            System.out.println("Player X wins");
        }
        else if (playerWins(array) == 2) {
            System.out.println("Player O wins");
        }
        else if (playerWins(array) == 3) {
            System.out.println("Draw");
        }

        input.close();
    }










    /** prints the field in a nice looking way */
    public static void showField (char[][] array) {

        System.out.print("\n");
        System.out.println(" 1 2 3 4 5 6 7");

        // iterate trough the array and print each element (' ', 'X' or 'O')
        // separated with "|"
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 7; j++) {
                System.out.print(array[i][j]);
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }

    /** check if a column is already full */
    public static boolean columnFull(int column, char[][] array) {
        if (array[0][column] != ' ') {
            return true;
        }
        else {
            return false;
        }
    }

    /** insert a chip into the field
     * column is the column of the playerfield, not the array (so 1-7)*/
    public static void insertChip(int player, int column, char[][] array) {
        column -= 1;
        for (int i = 5; i >= 0; i--) {
            if (array[i][column ] == ' ') {
                if (player == 1) {
                    array[i][column] = 'X';
                    break;
                }
                else {
                    array[i][column] = 'O';
                    break;
                }
            }
        }
    }


    /**
     * this function checks if one player has won yet
     * return 0: no one has won yet
     * return 1: player1 wins
     * return 2: player2 wins
     * return 3: draw
     */
    public static int playerWins(char[][] array) {

        // check horizontally -------------------------------------
        int countX;
        int countO;

        for (int i = 0; i < 6; i++) {
            // reset counters after each horizontal line
            countX = 0;
            countO = 0;
            for (int j = 0;  j < 7; j++) {
                // 'X'
                if (array[i][j] == 'X') {
                    countX++;
                    countO = 0;
                }
                // 'O'
                else if (array[i][j] == 'O') {
                    countO++;
                    countX = 0;
                }
                // ' '
                else {
                    countX = 0;
                    countO = 0;
                }

                // check if char occurred 4 times in a row
                if (countX == 4) {
                    return 1;
                }
                else if (countO == 4) {
                    return 2;
                }
            }
        }

        // check vertically -------------------------------------
        for (int i = 0; i < 7; i++) {
            // reset counters after each vertical line
            countX = 0;
            countO = 0;
            for (int j = 0;  j < 6; j++) {
                // 'X'
                if (array[j][i] == 'X') {
                    countX++;
                    countO = 0;
                }
                // 'O'
                else if (array[j][i] == 'O') {
                    countO++;
                    countX = 0;
                }
                // ' '
                else {
                    countX = 0;
                    countO = 0;
                }

                // check if char occurred 4 times in a row
                if (countX == 4) {
                    return 1;
                }
                else if (countO == 4) {
                    return 2;
                }
            }
        }

        // check diagonally -------------------------------------
        countX = 0;
        countO = 0;

        // rows from left bottom to right top
        for (int j = 3; j <= 5; j++) {
            for (int i = 0, x = j; i <= j; i++, x--) {
                if (array[i][x] == 'X') {
                    countX++;
                    countO = 0;
                }
                else if (array[i][x] == 'X') {
                    countO++;
                    countX = 0;
                }
                else {
                    countX = 0;
                    countO = 0;
                }

                // check if char occurred 4 times in a row
                if (countX == 4) {
                    return 1;
                }
                else if (countO == 4) {
                    return 2;
                }
            }
            countX = 0;
            countO = 0;
        }
        for (int i = 0; i <= 2; i++) {
            for (int x = i, j = 6; x <= 5; x++, j--) {
                if (array[x][j] == 'X') {
                    countX++;
                    countO = 0;
                }
                else if (array[x][j] == 'X') {
                    countO++;
                    countX = 0;
                }
                else {
                    countX = 0;
                    countO = 0;
                }

                // check if char occurred 4 times in a row
                if (countX == 4) {
                    return 1;
                }
                else if (countO == 4) {
                    return 2;
                }
            }
            countX = 0;
            countO = 0;
        }

        // rows from top left to right bottom
        for (int j = 3; j <= 5; j++) {
            for (int i = 0, x = 5 - j; i <= j; i++, x++) {
                if (array[x][i] == 'X') {
                    countX++;
                    countO = 0;
                }
                else if (array[x][i] == 'X') {
                    countO++;
                    countX = 0;
                }
                else {
                    countX = 0;
                    countO = 0;
                }

                // check if char occurred 4 times in a row
                if (countX == 4) {
                    return 1;
                }
                else if (countO == 4) {
                    return 2;
                }
            }
            countX = 0;
            countO = 0;
        }
        for (int i = 1; i <= 3; i++) {
            for (int x = i, j = 0; x <= 6; x++, j++) {
                if (array[j][x] == 'X') {
                    countX++;
                    countO = 0;
                }
                else if (array[j][x] == 'X') {
                    countO++;
                    countX = 0;
                }
                else {
                    countX = 0;
                    countO = 0;
                }

                // check if char occurred 4 times in a row
                if (countX == 4) {
                    return 1;
                }
                else if (countO == 4) {
                    return 2;
                }
            }
            countX = 0;
            countO = 0;
        }

        // check for draw -------------------------------------
        boolean everythingFilled = true;
        // check if every cell is filled
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (array[i][j] == ' ') {
                    everythingFilled = false;
                }
            }
        }

        if (everythingFilled) {
            return 3;
        }

        // no win has been found
        return 0;


    }

}
