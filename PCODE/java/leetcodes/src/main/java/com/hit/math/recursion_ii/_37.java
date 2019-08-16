package com.hit.math.recursion_ii;

/**
 * 37. Sudoku Solver
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * <p>
 * A sudoku puzzle...
 * <p>
 * ...and its solution numbers marked in red.
 * <p>
 * Note:
 * <p>
 * 1. The given board contain only digits 1-9 and the character '.'.
 * 2. You may assume that the given Sudoku puzzle will have a single unique solution.
 * 3. The given board size is always 9x9.
 */
public class _37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
