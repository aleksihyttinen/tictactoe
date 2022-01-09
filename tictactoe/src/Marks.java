package tictactoe.src;
import java.lang.Math;
/**
* contains methods for placing the different marks on the board.
*
* @author Aleksi Hyttinen
* @version 13/12/2020
* @since Java 14
*/

public class Marks {

    /**
    * asks for user input on where they want to place their mark.
    *
    * The method asks for user input, with MyConsole.getCoordinates()
    * and then checks if the slot on the board is free or not.
    * If it isn't free, the method keeps asking
    * until the user chooses a empty slot.
    *
    * @param boardArray is the game board at it's current state.
    * @return the board with the new mark.
    */

    public static char[][] playerChoice(char[][] boardArray) {
        char playerMark = 'X';
        System.out.println("Place your mark, count the rows and columns " +
                            "from the top left corner");
        System.out.println();
        System.out.println("Column?");
        int x = MyConsole.getCoordinates(boardArray);
        System.out.println("Row?");
        int y = MyConsole.getCoordinates(boardArray);
        if(boardArray[y][x] == '-') {
            boardArray[y][x] = playerMark;  
        } else {
            do {
                System.out.println("That spot has already been used. " +
                                    "Please select an empty spot to " +
                                    "place your mark on.");
                System.out.println();
                System.out.println("Column?");
                x = MyConsole.getCoordinates(boardArray);
                System.out.println("Row?");
                y = MyConsole.getCoordinates(boardArray);
            } while(boardArray[y][x] != '-');
            boardArray[y][x] = playerMark;
        }
        return boardArray;
    }

    /**
    * inserts the randomly generated computer mark to the board.
    *
    * The method asks computerCoordinates() for coordinates,
    * and then checks if the slot on the board is free or not.
    * If it isn't free, the method keeps asking
    * until the coordinates match an empty slot.
    *
    * @param boardArray is the game board at it's current state.
    * @return the board with the new mark.
    */

    public static char[][] computerChoice(char[][] boardArray) {
        char computerMark = 'O';
        int x = computerCoordinates(boardArray);
        int y = computerCoordinates(boardArray);
        if(boardArray[y][x] == '-') {
            System.out.println("Computers choice:");
            boardArray[y][x] = computerMark;
        } else {
            do {
                x = computerCoordinates(boardArray);
                y = computerCoordinates(boardArray);
            } while(boardArray[y][x] != '-');
            boardArray[y][x] = computerMark;
        }
        return boardArray;
    }

    /**
    * counts a random number for coordinates
    * using the Math.random() method.
    *
    * @param boardArray is the game board array. Its length is used
    * to calculate the random number to fit inside of the game board.
    * @return the random number.
    */

    public static int computerCoordinates(char[][] boardArray) {
        double i = Math.random() * boardArray.length;
        int j = (int) i;
        return j;
    }
}