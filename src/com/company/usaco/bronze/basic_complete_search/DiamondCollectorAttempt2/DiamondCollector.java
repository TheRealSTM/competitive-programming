//package com.company.usaco.bronze.basic_complete_search.DiamondCollectorAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=639
 *
 * Task Notes:
 * - Bessie has collected N diamonds of varying sizes. She wants to arrange them in the barn.
 * - Bessie wants the diamonds to be relatively similar in size where they cannot differ by
 *   more than K (<= K).
 * - Given K, please help Bessie determine the max number of diamonds that she can display.
 *
 * Input Notes:
 * - First line contains N and K (0 <= K <= 10000)
 * - The next N lines are the diamond sizes (1 <= size <= 10000)
 *
 * Output Notes:
 * - Output max number of diamonds that can be showcased
 *
 * Solution Notes:
 * - O(n^2), use two loops and keep track of all diamonds between some diamond size and + K
 * - O(n) approach can be found by sorting the diamonds and using a low/high pointer approach &
 *   keep track the max differences between high and low where all diamonds are only k apart
 * - Both approaches will work because N is small. The O(n) approach would work for > 7000
 *   up to a few million.
 *
 * Outcome:
 * -
 */
public class DiamondCollector {
    static String inputFileName = "diamond.in";
    static String outputFileName = "diamond.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] diamondSizes = new int[n];
        for (int i = 0; i < n; i++) {
            diamondSizes[i] = scanner.nextInt();
        }
        Arrays.sort(diamondSizes);
        int low = 0, high = 0, maxDifference = 0;
        while (high < n) {
            if (diamondSizes[high] - diamondSizes[low] <= k) {
                maxDifference = Math.max(high - low + 1, maxDifference);
                high++;
            } else {
                low++;
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(maxDifference);
        }
    }
}
