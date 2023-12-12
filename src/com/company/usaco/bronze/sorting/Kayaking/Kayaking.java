package com.company.usaco.bronze.sorting.Kayaking;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: https://codeforces.com/contest/863/problem/B
 *
 * Task Notes:
 * - Kayak party must choose kayaks
 * - There are 2*n people and they have (n - 1) tandems) and 2 single kayaks
 * - ith person is w_i; if the wait differential in the kayaks is too large, the kayaks can crash
 * - Instability of a tandem kayak is the weight differential between the two people
 * - Task: Determine the minimum possible total instability
 *
 * Input Notes:
 * - n (where 2 <= n <= 50)
 * - The second line contains 2*n weights where w_i is 1 <= w_i <= 1000
 *
 * Output Notes:
 * - minimum possible instability
 *
 * Solution Notes:
 * - Sort the peoples' weights
 * - Do an n^2 approach where we consider each pair of canoes to be the singles and calculate the min differential
 *   - If I wanted a slightly easier approach using a bit more space, we could create a new list with people
 *     that are not in singles. This would make it easier to calculate the weight differential.
 * - Total runtime is n^3 because we for each pair we also perform n operations.
 *
 * Outcome:
 * - All test cases pass
 */
public class Kayaking {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            weights[i] = scanner.nextInt();
        }
        Arrays.sort(weights);
        int minDifferential = Integer.MAX_VALUE;
        for (int i = 0; i < 2 * n; i++) {
            for (int j = i + 1; j < 2 * n; j++) {
                int currentDifferential = 0;
                for (int k = 0; k < 2 * n;) {
                    int firstPos = k;
                    if (firstPos == i || firstPos == j) {
                        k++;
                        continue;
                    }
                    int secondPos = k + 1;
                    while (secondPos == i || secondPos == j) {
                        secondPos++;
                    }
                    currentDifferential += (weights[secondPos] - weights[firstPos]);
                    k = secondPos + 1;
                }
                minDifferential = Math.min(currentDifferential, minDifferential);
            }
        }
        System.out.println(minDifferential);
    }
}
