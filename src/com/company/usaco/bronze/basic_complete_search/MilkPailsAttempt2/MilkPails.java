package com.company.usaco.bronze.basic_complete_search.MilkPailsAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=615
 *
 * Task Notes:
 * - FJ has received an order for exactly M units of milk (1 <= M <= 1000).
 * - FJ has 3 milk pails of size (X, Y, and M) where 1 <= X < Y < M
 * - All pails are initially empty.
 * - He can perform the following operations:
 *   - He can fill X to the top and pour it into size M pail as long as M won't overflow
 *   - He can fill Y to the top and pour it into size M pail as long as M won't overflow
 * - Please determine the max amount of milk that he can possibly add to M
 *
 * Input Notes:
 * - First line contains X Y and M separated by spaces
 *
 * Output Notes:
 * - Output max amount of milk FJ can possibly add to M
 *
 * Solution Notes:
 * - Cycle through all possible combinations of X and Y to determine the max
 * - Runtime will be N^2 since N < 7K (no concern with time)
 *
 * Outcome:
 * - All test cases pass. I needed two submissions because I had an off by error in the loop where I wasn't considering
 *   scenario where all possible X or Y dumps were used.
 */
public class MilkPails {
    static String inputFileName = "pails.in";
    static String outputFileName = "pails.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int currentMMax = 0;
        int maxXiterations = m / x, maxYiterations = m / y;
        for (int i = 0; i <= maxXiterations; i++) {
            for (int j = 0; j <= maxYiterations; j++) {
                int currentAmount = x * i + j * y;
                if (currentAmount > m) {
                    break;
                }
                currentMMax = Math.max(currentAmount, currentMMax);
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(currentMMax);
        }
    }
}