package tictactoe.src;
/**
* contains methods for checking if the game has been won,
* or if it has resulted in a tie.
*
* @author Aleksi Hyttinen
* @version 13/12/2020
* @since Java 14
*/

public class Wincheck {

    /**
    * calls different methods to check if the game is over.
    *
    * This method calls for four different methods 
    * which keep track of the game situation.
    *
    * @param boardArray is the game board at it's current state.
    * @param marksToWin is the amount of
    * consecutive marks needed to win.
    *
    * @return a true or false value
    * which determines if the game should turn off.
    */

    public static boolean gameWon(char[][] boardArray, int marksToWin) {
        boolean gameOn = true;
        boolean tie = false;
        if(gameOn) {
            gameOn = checkColumns(boardArray, marksToWin);
        }
        if(gameOn) {
            gameOn = checkRows(boardArray, marksToWin);
        }
        if(gameOn) {
            gameOn = checkDiagonal(boardArray, marksToWin);
        }
        if(gameOn) {
            tie = checkTie(boardArray);
        }
        if(tie) {
            System.out.println("TIE!");
            gameOn = false;
        }
        return gameOn;
    }

    /**
    * checks if the board is full.
    *
    * @param boardArray is the game board at it's current state.
    * @return a true value if the board is full
    * and a false value if it's not.
    */

    public static boolean checkTie(char[][] boardArray) {
        for(int i = 0; i < boardArray.length; i++) {
            for(int j = 0; j < boardArray[i].length; j++) {
                if(boardArray[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
    * goes through the board counting marks from up to down.
    *
    * @param boardArray is the game board at it's current state.
    * @param marksToWin is the amount of
    * consecutive marks needed to win.
    * @return a true or false value
    * which determines if the game has been won.
    */

    public static boolean checkColumns(char[][] boardArray, int marksToWin) {
        int xCounter = 0;
        int oCounter = 0;
        for(int i = 0; i < boardArray.length; i++) {
            xCounter = 0;
            oCounter = 0;
            for(int j = 0; j < boardArray[i].length; j++) {
                if(boardArray[j][i] == 'X') {
                    xCounter++;
                } 
                if(boardArray[j][i] != 'X') {
                    xCounter = 0;
                }
                if(xCounter == marksToWin) {
                    System.out.println("X WON!");
                    return false;
                }
            }
        }
        for(int i = 0; i < boardArray.length; i++) {
            xCounter = 0;
            oCounter = 0;
            for(int j = 0; j < boardArray[i].length; j++) {
                if(boardArray[j][i] == 'O') {
                    oCounter++;
                } 
                if(boardArray[j][i] != 'O') {
                    oCounter = 0;
                }
                if(oCounter == marksToWin) {
                    System.out.println("O WON!");
                    return false;
                }
            }
        }
        return true;  
    }

    /**
    * goes through the board counting marks from left to right.
    *
    * @param boardArray is the game board at it's current state.
    * @param marksToWin is the amount of
    * consecutive marks needed to win.
    * @return a true or false value
    * which determines if the game has been won.
    */

    public static boolean checkRows(char[][] boardArray, int marksToWin) {
        int xCounter = 0;
        int oCounter = 0;
        for(int i = 0; i < boardArray.length; i++) {
            xCounter = 0;
            oCounter = 0;
            for(int j = 0; j < boardArray[i].length; j++) {
                if(boardArray[i][j] == 'X') {
                    xCounter++;
                } 
                if(boardArray[i][j] != 'X') {
                    xCounter = 0;
                }
                if(xCounter == marksToWin) {
                    System.out.println("X WON!");
                    return false;
                }
            }
        }
        for(int i = 0; i < boardArray.length; i++) {
            xCounter = 0;
            oCounter = 0;
            for(int j = 0; j < boardArray[i].length; j++) {
                if(boardArray[i][j] == 'O') {
                    oCounter++;
                } 
                if(boardArray[i][j] != 'O') {
                    oCounter = 0;
                }
                if(oCounter == marksToWin) {
                    System.out.println("O WON!");
                    return false;
                }
            }
        }
        return true;  
    }

    /**
    * goes through the board counting marks diagonally.
    *
    * @param boardArray is the game board at it's current state.
    * @param marksToWin is the amount of
    * consecutive marks needed to win.
    * @return a true or false value
    * which determines if the game has been won.
    */


    public static boolean checkDiagonal(char[][] boardArray, int marksToWin) {
        int xCounter = 0;
        int oCounter = 0;
        int diagonalX = 0;
        int diagonalY = 0;
        //checks diagonals for X win
        //from top left to botton right
        do {
            if(boardArray[diagonalY][diagonalX] == 'X') {
                xCounter++;
            }
            if(boardArray[diagonalY][diagonalX] != 'X') {
                xCounter = 0;
            }
            if(xCounter == marksToWin) {
                System.out.println("X WON!");
                return false;
            }
            diagonalX++;
            diagonalY++;
        } while(xCounter != marksToWin &&
                diagonalX < boardArray[0].length &&
                diagonalY < boardArray.length);

        //from top right to bottom left
        diagonalY = 0;
        diagonalX = boardArray[0].length -1;

        do {
            if(boardArray[diagonalY][diagonalX] == 'X') {
                xCounter++;
            }
            if(boardArray[diagonalY][diagonalX] != 'X') {
                xCounter = 0;
            }
            if(xCounter == marksToWin) {
                System.out.println("X WON!");
                return false;
            }
            diagonalY++;
            diagonalX--;
        } while(xCounter != marksToWin &&
                diagonalX < boardArray[0].length &&
                diagonalY < boardArray.length);

        //checks diagonals for O win
        //from top left to bottom right
        diagonalY = 0;
        diagonalX = 0;
        do {
            if(boardArray[diagonalY][diagonalX] == 'O') {
                oCounter++;
            }
            if(boardArray[diagonalY][diagonalX] != 'O') {
                oCounter = 0;
            }
            if(oCounter == marksToWin) {
                System.out.println("O WON!");
                return false;
            }
            diagonalX++;
            diagonalY++;
        } while(xCounter != marksToWin &&
                diagonalX < boardArray[0].length &&
                diagonalY < boardArray.length);
        //from top right to bottom left
        diagonalY = 0;
        diagonalX = boardArray[0].length -1;

        do {
            if(boardArray[diagonalY][diagonalX] == 'O') {
                oCounter++;
            }
            if(boardArray[diagonalY][diagonalX] != 'O') {
                oCounter = 0;
            }
            if(oCounter == marksToWin) {
                System.out.println("O WON!");
                return false;
            }
            diagonalY++;
            diagonalX--;
        } while(xCounter != marksToWin &&
                diagonalX < boardArray[0].length &&
                diagonalY < boardArray.length);
        return true;
    }
         
}
