package com.company.usaco.bronze.simulation.TheCowSignalAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=665
 *
 * Task Notes:
 * - Bessie and her friends are playing as their favorite superheroes. They need a call-to-action.
 * - On a sheet of paper of size (1 <= M <= 10, 1 <= N <= 10), bessie wants to scale it by K integer
 *   where 1 <= K <= 10.
 * - The signal will consist of "." and "X" characters.
 *
 * Input Notes:
 * -First line contains M, N, and K. Next M lines will be N characters long describing the image.
 *
 * Output Notes:
 * - You should output K * M lines with K * N characters to generate the enlarged image.
 *
 * Solution Notes:
 * - Read all the data in (including the image)
 * - Create a new array to contain the scaled image
 * - Cycle through each row duplicating the columns, then duplicate the created row
 * - Skip K rows and continue the process
 * - Output the image
 *
 * Outcome:
 * - All test cases passed on first try.
 */
public class TheCowSignal {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TheCowSignalAttempt2\\cowsignal.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TheCowSignalAttempt2\\cowsignal.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int rows = scanner.nextInt();
        int col = scanner.nextInt();
        int multiplier = scanner.nextInt();
        String[] pattern = new String[rows];

        scanner.nextLine();
        for (int i = 0; i < rows; i++) {
            pattern[i] = scanner.nextLine();
        }

        StringBuilder[] newPattern = new StringBuilder[multiplier * rows];
        for (int i = 0; i < rows; i++) {
            StringBuilder updatedRow = new StringBuilder();
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < multiplier; k++) {
                    updatedRow.append(pattern[i].charAt(j));
                }
            }
            for (int j = 0; j < multiplier; j++) {
                newPattern[i * multiplier + j] = updatedRow;
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            for (StringBuilder row: newPattern) {
                pw.println(row.toString());
            }
        }
    }
}
