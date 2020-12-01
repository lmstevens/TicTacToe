package com.nick.ttt.tests.com.nick.ttt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.nick.ttt.TicTacToeBoard;
import com.nick.ttt.TicTacToeGame;

class UnitTests {
    /**
     * IN PROGRESS: Creates ArrayLists of TicTacToeBoards to use in Unit Testing @Tests.
     */
    ArrayList<TicTacToeBoard> testXBoardList = new ArrayList<TicTacToeBoard>();

    @BeforeAll
    public static void createWinningXBoards(){
        // TicTacToeBoard testBoard = new TicTacToeBoard();
            testXBoardList.add(new TicTacToeBoard(new char[]{'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '}));
    }
    
    /**
     * Tests placing a single piece on an empty board.
     */


    @Test
    void placePiece() {
        TicTacToeGame game = new TicTacToeGame();
        for(int i = 0; i < game.getGameBoard().getBoard().length; i++){
            game.getGameBoard().placePiece('X', i);
            Assertions.assertEquals('X', game.index(i));
        }

        //test 'O'
        for(int i = 0; i < game.getGameBoard().getBoard().length; i++){
            game.getGameBoard().placePiece('O', i);
            Assertions.assertEquals('O', game.index(i));
        }
    }

    /**
     * Tests the find all empties sub functions.
     */
    @Test
    void findEmptyNumber() {
        TicTacToeBoard emptyBoard = new TicTacToeBoard();
        Assertions.assertTrue(validateEmptyNumber(emptyBoard, 9));

        TicTacToeBoard allXBoard = new TicTacToeBoard(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
        Assertions.assertTrue(validateEmptyNumber(allXBoard, 0));

        TicTacToeBoard allOBoard = new TicTacToeBoard(new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'});
        Assertions.assertTrue(validateEmptyNumber(allOBoard, 0));

        TicTacToeBoard someEmpties = new TicTacToeBoard(new char[]{' ', ' ', ' ', 'X', 'O', ' ', ' ', 'X','O'});
        Assertions.assertTrue(validateEmptyNumber(someEmpties, 5));
    }

    //a helper method for findEmpties()
    boolean validateEmptyNumber(TicTacToeBoard board, int n){
        //empty character is declared in case it is refactored.
        //originally I put the value in the loop but interestingly '0'==0 even if they are both chars
        //while 0==(char) 0 returns true.
        //since an empty game board is initialized as charArray of 0 not a charArray of '0' this matters

        char[] boardChars = board.getBoard();
        ArrayList<Integer> emptyLocations = board.findEmpties();
        int totalEmpties = 0;
        for (int i = 0; i < emptyLocations.size(); i++) {
            //take each empty location and see if it is actually empty in the board.
            int loc = emptyLocations.get(i);
            if (boardChars[loc] == ' ') {
                totalEmpties++;
            }
        }
        return totalEmpties == n;
    }
    
    /**
     * IN PROGRESS Tests the gameWon() function by calling TicTacToeBoards from testXBoardList.
     */
    @Test
    void gameWonTest() {

        TicTacToeBoard winningBoard = new TicTacToeBoard(testXBoardList.get(0));
        Assertions.assertTrue(winningBoard.gameWon());
    }

    /**
     * IN PROGRESS Tests the gameWon() function on not winning board.
     * Want to call TicTacToeBoards from new ArrayList created in @BeforeAll annotation
     * for NotWinning TicTacToeBoards.
     */
    @Test
    void gameNotWonTest() {

        TicTacToeBoard winningBoard = new TicTacToeBoard(new char[]{'X', 'O', 'X',
                                                                    ' ', 'O', 'O',
                                                                    ' ', ' ', ' '});
        Assertions.assertFalse(winningBoard.gameWon());
    }


}
