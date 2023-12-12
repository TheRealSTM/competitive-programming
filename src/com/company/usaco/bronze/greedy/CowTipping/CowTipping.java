// package com.company.usaco.bronze.greedy.CowTipping;

import java.io.*;
import java.util.Arrays;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=689
 *
 * Task Notes:
 * - Cows were grazing in a N^2 arrangement where 1 <= N <= 10 - now some are tipped over
 * - Machine can unflip cows in bulk
 * - Machine can be applied to any upper-left rectangle (Machine toggles cows)
 * - Task determine min # of operations
 *
 * Solution Notes:
 *  - Start at pos (n - 1, n - 1) - in a greedy manner, flip the grid if a '1' is found
 *  - Initially move up the rows in the (n - 1) column, then move to the left of the columns
 *    in a given row. Calling flipGrid everytime a '1' is encountered.
 *
 * Outccome:
 * - All test cases pass.
 *
 */
public class CowTipping {
    static String inputFileName = "cowtip.in";
    static String outputFileName = "cowtip.out";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(bufferedReader.readLine());
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = bufferedReader.readLine().toCharArray();
        }
        int numberOfFlips = 0;
        for (int i = n - 1; i >= 0; i--) {
            int row = i, col = i - 1;
            while (row >= 0) {
                if (grid[row][i] == '1') {
                    flipBoard(grid, row, i);
                    numberOfFlips++;
                }
                row--;
            }
            while (col >= 0) {
                if (grid[i][col] == '1') {
                    flipBoard(grid, i, col);
                    numberOfFlips++;
                }
                col--;
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(numberOfFlips);
        }
    }

    private static void flipBoard(char[][] grid, int lowerRightRow, int lowerRightCol) {
        for (int i = 0; i <= lowerRightRow; i++) {
            for (int j = 0; j <= lowerRightCol; j++) {
                grid[i][j] = (grid[i][j] == '1') ? '0' : '1';
            }
        }
    }
}
