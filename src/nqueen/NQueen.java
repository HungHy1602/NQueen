/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nqueen;

/* Name: Huynh Duy Anh
Student Code: SE182336
Purpose: Problem 4 - N-Queens Puzzle.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {

    private static final char EMPTY = '◼';
    private List<String[]> res;
    private int N;

    public List<String[]> solveNQueens(int n) {
        res = new ArrayList<>();
        N = n;
        // Create an empty NxN board
        char[][] emptyBoard = new char[N][N];
        // Fill the board with empty character
        for (char[] row : emptyBoard) {
            Arrays.fill(row, EMPTY);
        }
        // start the algo with the first row
        nextRow(emptyBoard, 0, new HashSet<>(n), new HashSet<>(n), new HashSet<>(n));
        return res;
    }

    private void nextRow(char[][] board, int row,
            Set<Integer> visitedColumns,
            Set<Integer> visitedDiagonals,
            Set<Integer> visitedAntiDiagonals) {
        if (row == N) { // End of all rows
            String[] newBoard = new String[board.length];
            for (int i = 0; i < newBoard.length; i++) {
                newBoard[i] = new String(board[i]);
            }
            res.add(newBoard);
            return;
        }

        for (int col = 0; col < N; col++) {
            // Using row and column to find the current diagonal and anti-diagonal indexes
            int currDiag = row - col + N;
            int currAntiDiag = row + col;

            if (visitedColumns.contains(col)
                    || visitedDiagonals.contains(currDiag)
                    || visitedAntiDiagonals.contains(currAntiDiag)) {
                continue;
            }

            // If success, add the queen
            board[row][col] = 'Q';

            // Mark visited
            visitedColumns.add(col);
            visitedDiagonals.add(currDiag);
            visitedAntiDiagonals.add(currAntiDiag);

            // Continue to the next row
            nextRow(board, row + 1, visitedColumns, visitedDiagonals, visitedAntiDiagonals);

            // Then 'backtrack' by removing the queen and move to the next column
            board[row][col] = EMPTY;
            visitedColumns.remove(col);
            visitedDiagonals.remove(currDiag);
            visitedAntiDiagonals.remove(currAntiDiag);
        }
    }
}
