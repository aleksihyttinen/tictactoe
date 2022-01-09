package tictactoe.src;
import java.io.Console;

/**
* contains methods that ask for user input and validates it.
*
* @author Aleksi Hyttinen
* @version 13/12/2020
* @since Java 14
*/

public class MyConsole {

    /**
    * asks the user for an integer value.
    *
    * The method will ask for an int value in a while-loop.
    * Inside the loop the method checks if the given input is valid.
    * If it isn't, the method will display a error message
    * and ask the user for new input.
    * If the input is valid,
    * the method will stop looping and return the given value.
    *
    * @return the value the user has given.
    */

    public static int getInput() {
        String errorMessageNonNumeric = "Wrong input. " +
                "Please give a integer number.";
        String errorMessageNegative = "Wrong input. " +
                "Please give a positive number.";
        Console c = System.console();
        boolean value = true;
        int returnInput = 0;
        boolean exception = false;
        while(value) {
            try {
                returnInput = Integer.parseInt(c.readLine());
                value = false;
                if(returnInput < 0) {
                    System.out.println(errorMessageNegative);
                    value = true;
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
                exception = true;
            }
        }
        return returnInput;
    }

    /**
    * asks the user for a number
    * which will be used for coordinates on the board.
    *
    * This method has more specific validations for the input
    * than getInput. It validates the number and then checks if
    * the number is on the board to prevent out of index inputs.
    *
    * @param boardArray is the game board array.
    * Its length is used to determine the validations for the input.
    * @return the validated user input.
    */

    public static int getCoordinates(char[][] boardArray) {
        String errorMessageNonNumeric = "Wrong input. " +
                "Please give a integer number.";
        String errorMessageOutOfBoard = 
                 "Board size is " + boardArray.length +
                 "x" + boardArray.length + 
                 " please insert a positive number in this range.";
        Console c = System.console();
        boolean value = true;
        int returnInput = 0;
        boolean exception = false;
        while(value) {
            try {
                returnInput = Integer.parseInt(c.readLine());
                value = false;
                if(returnInput > boardArray.length || returnInput < 0) {
                    System.out.println(errorMessageOutOfBoard);
                    value = true;
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
                exception = true;
            }
        }
        returnInput = returnInput -1; 
        // -1 so the input is logical instead of indexes.
        return returnInput;
    }
}