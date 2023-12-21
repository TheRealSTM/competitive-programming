package com.company.usaco.contests.bronze.december;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem&cpid=1335
 *
 * Task Notes:
 * - Cows enjoy candy canes
 * - FJ has N total cows (each with a initial height, and he wants to feed them M candy canes)
 *   1 <= N, M <= 2 * 10^5
 * - FJ plans to feed the candy canes 1 by 1
 * - Candy cane will initially start near the ground. Cows will line up in the order order given by the input.
 * - Each eating up to their height, and the candy cane is not lowered closer to the ground.
 *   - A cow may eat nothing.
 * - After all cows have had a turn, the cows grow in height by how many units of candy cane they ate.
 * - FJ hangs the next candy cane and the process continues starting at cow 1.
 *
 * Input Notes:
 * - First line has N and M
 * - The next N line shows the cows initial heights
 * - The next M ints are the candy cane heights.
 *
 * Output Notes:
 * - Output the heights of each of the N cows
 *
 * Solution Notes:
 * - This seems like a straightforward simulation problem just do what the prompt states.
 * - Use long for the heights of the cows because the heights may exceed int sizing
 * - long shouldn't be needed for the candy cane heights.
 *
 * Outcome:
 * - All test cases pass (14/14)
 */
public class Problem1_CandyCaneFeast {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] cowHeights = new long[n];
        int[] candyCaneHeights = new int[m];
        for (int i = 0; i < n; i++) {
            cowHeights[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            candyCaneHeights[i] = scanner.nextInt();
        }
        for (int candyCaneHeight : candyCaneHeights) {
            int baseHeight = 0;
            for (int j = 0; j < cowHeights.length; j++) {
                if (baseHeight == candyCaneHeight) break;
                if (cowHeights[j] < baseHeight) continue;
                long amountConsumed = Math.min(cowHeights[j], candyCaneHeight) - Math.min(baseHeight, candyCaneHeight);
                baseHeight += amountConsumed;
                cowHeights[j] += amountConsumed;
            }
        }

        try (PrintWriter pw = new PrintWriter(System.out)) {
            for (int i = 0; i < cowHeights.length; i++) {
                pw.println(cowHeights[i]);
            }
        }
    }
}

