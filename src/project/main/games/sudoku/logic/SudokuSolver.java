package project.main.games.sudoku.logic;

import java.util.stream.IntStream;

public class SudokuSolver {
    private static final int GRID_SIZE = 3 * 3;

    private static boolean allowedInRow(int[][] board, int row, int number) {
        return IntStream.range(0, GRID_SIZE)
                .noneMatch(col -> board[row][col] == number);
    }

    private static boolean allowedInCol(int[][] board, int col, int number) {
        return IntStream.range(0, GRID_SIZE)
                .noneMatch(row -> board[row][col] == number);
    }

    private static boolean allowedInBox(int[][] board, int row, int col, int number) {
        final int boxCol = col - (col % 3);
        final int boxRow = row - (row % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRow + i][boxCol + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAllowed(int[][] board, int row, int col, int number) {
        return allowedInRow(board, row, number) &&
                allowedInCol(board, col, number) &&
                allowedInBox(board, row, col, number);
    }

    public static boolean solve(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isAllowed(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}