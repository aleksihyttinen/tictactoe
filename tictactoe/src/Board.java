package tictactoe.src;
/**
* contains all of the methods used.
* for different functions of the game board.
*
* @author Aleksi Hyttinen
* @version 13/12/2020
* @since Java 14
*/

public class Board {

    /**
    * initializes the game board.
    *
    * This method has a welcome message which indicates the boards
    * minimum size, and then asks the user
    * how big they want their board to be.
    *
    * @return an array the size of the users choice.
    */

    public static char[][] initializeBoard() {
        System.out.println("Welcome to TicTacToe! Minimum board size is 3x3.");
        System.out.println("Insert game board size. (N x N)");
        int boardSize = MyConsole.getInput();
        while(boardSize < 3) {
            System.out.println("Board can't be smaller than 3x3.");
            System.out.println("Insert game board size. (N x N)");
            boardSize = MyConsole.getInput();
        }
        char[][] array = new char [boardSize][boardSize];
        return array;
    }

    /**
    * asks the user how many consecutive marks are needed to win.
    *
    * This method gets the users input and then validates it. 
    * The requirements for the input are: If the board is the
    * minimum size (3x3) the marks to win can't be less than three,
    * and if the board is 10x10 or more,
    * you need atleast 5 marks to win.
    *
    * @param boardArray is the game board array. Its length is
    * used to determine the validations for the input.
    * @return the amount of marks needed to win.
    */

    public static int marksToWin(char[][] boardArray) {
        int marksToWin = 0;
        System.out.println("How many marks to win?");
        marksToWin = MyConsole.getInput();
        if(boardArray.length >= 10 && marksToWin < 5) {
            while(boardArray.length >= 10 && marksToWin < 5) {
                System.out.println("Marks to win can't be less than 5 when " +
                                    "playing on a board 10x10 or bigger.");
                System.out.println("How many marks to win?");
                marksToWin = MyConsole.getInput();
            }
        }
        if(marksToWin < 3) {
            while(marksToWin < 3) {
                System.out.println("Marks to win can't be under 3.");
                System.out.println("How many marks to win?");
                marksToWin = MyConsole.getInput();
            }
        }
        if(marksToWin > boardArray.length) {
            while(marksToWin > boardArray.length) {
                System.out.println("Marks to win can't be more " +
                                    "than the board size.");
                System.out.println("How many marks to win?");
                marksToWin = MyConsole.getInput();
            }
        }
        return marksToWin;
    }

    /**
    * is used in the initialization,
    * which fills the new board with empty slots marked as '-'.
    * 
    * @param boardArray is the empty game board array.
    */

    public static void fillBoard(char[][] boardArray) {
        for(int i = 0; i < boardArray.length; i++) {
            for( int j = 0; j < boardArray[i].length; j++) {
                boardArray[i][j] = '-';
            }
        }
    }

    /**
    * prints the game board at it's current state.
    *
    * @param boardArray is the game board at it's current state.
    */
    public static void printBoard(char[][] boardArray) {
        System.out.println();
        for(int i = 0; i < boardArray.length; i++) {
            for( int j = 0; j < boardArray[i].length; j++) {
                System.out.print(boardArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}