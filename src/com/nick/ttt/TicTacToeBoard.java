package com.nick.ttt;

import java.util.ArrayList;
import java.util.HashMap;

public class TicTacToeBoard {

    private char[] board;
    private ArrayList<int[]> winConditions;
    private HashMap<Character, Integer> charToInt;

    public TicTacToeBoard() {
        this.board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.winConditions = new ArrayList<>();
        this.winConditions.add(new int[]{0, 1, 2});
        this.winConditions.add(new int[]{3, 4, 5});
        this.winConditions.add(new int[]{6, 7, 8});
        this.winConditions.add(new int[]{0, 3, 6});
        this.winConditions.add(new int[]{1, 4, 7});
        this.winConditions.add(new int[]{2, 5, 8});
        this.winConditions.add(new int[]{0, 4, 8});
        this.winConditions.add(new int[]{2, 4, 6});
        this.charToInt = new HashMap<>();
        charToInt.put('x', -1);
        charToInt.put('o', 1);
        charToInt.put(' ', 0);
    }

    public TicTacToeBoard(char[] board){
        this.board = new char[9];
        for(int i=0; i < board.length; i++){
            this.board[i] = board[i];
        }
        winConditions = null;
    }

    // TODO: Generate Getters and Setters
    public char[] getBoard() {
        return this.board;
    }

    public ArrayList<int[]> getWinConditions() {
        return this.winConditions;
    }

    public HashMap<Character, Integer> getCharToInt() {
        return charToInt;
    }

    public void placePiece(char xo, int pos) {
        this.getBoard()[pos] = xo;
    }

    public ArrayList<Integer> findEmpties() {
        ArrayList<Integer> empties = new ArrayList<>();
        char[] board = this.getBoard();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                empties.add(i);
            }
        }
        return empties;
    }

    public boolean gameWon() {
        ArrayList<int[]> wins = this.getWinConditions();
        char[] board = this.getBoard();
        HashMap<Character, Integer> map = this.getCharToInt();
        int sum = 0;

        for (int[] arr : wins) {
            for (int i : arr) {
                if (map.containsKey(board[i])) {
                    sum += map.get(board[i]);
                }
            }
            if (sum == 3 || sum == -3) {
                return true;
            } else {
                sum = 0;
            }
        }
        return false;
    }
}
