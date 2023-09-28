/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nqueen;

import java.util.List;
import java.util.Scanner;

/* Name: Huynh Duy Anh
Student Code: SE182336
Purpose: Problem 4 - N-Queens Puzzle.
 */
public class NQueen_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter size of chessboard (or 'q' to quit): ");
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("q")) {
                return;
            }
            try {
                int n = Integer.parseInt(str);
                if (n < 1) {
                    System.out.println("Number must be N >= 1");
                } else {
                    solveNQueens(n);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        } while (true);
    }

    private static void solveNQueens(int n) {
        NQueen nQueen = new NQueen();
        List<String[]> res = nQueen.solveNQueens(n);
        int i = 0;
        for (String[] solution : res) {
            System.out.println("SOLUTION #" + (++i));
            for (String line : solution) {
                System.out.println(line);
            }
            System.out.println();
        }
        System.out.println();
    }
}
