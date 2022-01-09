package tictactoe.src;
import tictactoe.src.Wincheck;
import tictactoe.src.Marks;
import tictactoe.src.MyConsole;
import tictactoe.src.Board;

/**
* contains the methods needed for the TicTacToe-game to run.
* 
* @author Aleksi Hyttinen
* @version 13/12/2020
* @since Java 14
*/
public class Tictactoe {
    /** tells methods whether the game should be on or off.
    */
    static Boolean gameOn = true;
    /** is the value of marks needed to win.
    *
    * I introduced this value here
    * to simplify inserting it to params.
    * MarksToWin's value will be filled in Board.initializeboard().
    */
    static int marksToWin;

    /** 
    * is the main method which starts the app.
    *
    * @param args is not used in this app.
    */
    public static void main(String[] args) {
        startGame(marksToWin);
    }

    /** 
    * is responsible for implementing all the
    * methods needed for the game to run.
    *
    * This method will call all the methods needed,
    * and give them their params. It also constantly
    * checks with the while-loop if the game is still on.
    *
    * @param marksToWin is the amount of consecutive
    * marks needed to win.
    */

    public static void startGame(int marksToWin) {
        char[][] boardArray;
        boardArray = Board.initializeBoard();
        marksToWin = Board.marksToWin(boardArray);
        Board.fillBoard(boardArray);
        Board.printBoard(boardArray);
        
        while(gameOn) {
            Marks.playerChoice(boardArray);
            Board.printBoard(boardArray);
            gameOn = Wincheck.gameWon(boardArray, marksToWin);
            if(gameOn) {
                Marks.computerChoice(boardArray);
                Board.printBoard(boardArray);
                gameOn = Wincheck.gameWon(boardArray, marksToWin);
            }
        }
    }
}