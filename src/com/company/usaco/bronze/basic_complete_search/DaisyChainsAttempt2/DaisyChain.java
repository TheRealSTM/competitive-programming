// package com.company.usaco.bronze.basic_complete_search.DaisyChainsAttempt2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=1060
 *
 * Task Notes:
 * - Bessie visits her favorite pasture that has N flowers (1 <= N <= 100) and
 *   each flower i has petals (1 <= p_i <= 1000)
 * - Bessie take pictures of these flowers. For every pair of flowers (i, j), she takes pictures
 *   of all flowers from flower i to flower j (1 <= i <= j <= N)
 * - Bessie notices an average flower -- a flower that has P petals where P is the exact average number of petals
 *   among all flowers in the photo
 * - How many of Bessie's photos have an average flower
 *
 * Input Notes:
 * - First line has N
 * - Next line contains N space separated integers p1, ..., pN
 *
 * Output Notes:
 * - Number of photos with an average flower
 *
 * Solution Notes:
 * - Cycle through all ranges (O(N^2))
 * - Calculate average of the range
 *   - The average calculation can be optimized to use a prefix sum approach. This takes the runtime from
 *     O(n^3).
 *   - check how many flowers equal the average
 *
 * Outcome:
 * -
 */
public class DaisyChain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] flowerPetals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sums = new int[n + 1];
        sums[0] = flowerPetals[0];
        for (int i = 1; i < n; i++) {
            sums[i] = flowerPetals[i] + sums[i - 1];
        }
        int averageCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                double average = (sums[j] - (i > 0 ? sums[i - 1] : 0)) / (j - i + 1.0);
                for (int k = i; k <= j; k++) {
                    if (flowerPetals[k] == average) {
                        averageCount++;
                        break;
                    }
                }
            }
        }
        System.out.println(averageCount);
    }
}
