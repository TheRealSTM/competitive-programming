// package com.company.usaco.silver.prefix_sum.BreedCounting;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=572
 *
 * Task Notes:
 * - FJ has N cows (numbers 1, ..., N) - they are all standing in a row
 * - Each cow has a breed ID (1 for Holsteins, 2 for Guernseys, 3 for Jerseys)
 * - Task: FJ would like your help counting the number of cows of each breed within certain intervals
 *   of the ordering
 *
 * Input Notes:
 * - 1 <= N <= 100,000 where N is the number of cows
 * - Queries: 1 <= Q <= 100,000 where in each line consists of a_i and b_i
 *
 * Output Notes:
 * - For each Q query, print a line contain 3 numbers corresponding to the sum of breeds
 *
 * Solution Notes:
 * - Use a prefix sum approach where we keep track of sum of each type of cow up to that point
 *
 * Outcome:
 * - All test cases pass (15 / 15)
 */
public class BreedCounting {
    static String inputFileName = "bcount.in";
    static String outputFileName = "bcount.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] prefixSum = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            int currentCow = scanner.nextInt();
            prefixSum[i][0] = prefixSum[i - 1][0] + (currentCow == 1 ? 1 : 0);
            prefixSum[i][1] = prefixSum[i - 1][1] + (currentCow == 2 ? 1 : 0);
            prefixSum[i][2] = prefixSum[i - 1][2] + (currentCow == 3 ? 1 : 0);

        }
        PrintWriter pw = new PrintWriter(outputFileName);
        for (int i = 0; i < q; i++) {
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt();
            pw.print(prefixSum[end][0] - prefixSum[start][0] + " ");
            pw.print(prefixSum[end][1] - prefixSum[start][1] + " ");
            pw.println(prefixSum[end][2] - prefixSum[start][2]);
        }
        pw.close();
    }
}