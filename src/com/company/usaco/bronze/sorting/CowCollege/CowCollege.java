// package com.company.usaco.bronze.sorting.CowCollege;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: http://usaco.org/index.php?page=viewproblem2&cpid=1251
 *
 * Task Notes:
 * - N where 1 <= N <= 10^5 cows (who could potentially attend university)
 * - Each cow is willing to pay at most 1 <= c_i <= 10^6
 * -
 *
 * Solution Notes:
 * - Sort the desired tuitions in non-decreasing order
 * - Do a complete search to find the maxTuition and optimalTuition
 * - Only count a given tuition once (to save a few checks on duplicates)
 *
 * Outcome:
 */
public class CowCollege {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] desiredMax = new long[n];
        for (int i = 0; i < n; i++) {
            desiredMax[i] = scanner.nextInt();
        }
        Arrays.sort(desiredMax);
        long maxTuition = desiredMax[0] * n, optimalTuition = desiredMax[0];
        for (int i = 1; i < n; i++) {
            if (desiredMax[i] != desiredMax[i - 1]) {
                long updatedTuition = desiredMax[i] * (n - i);
                if (maxTuition < updatedTuition) {
                    maxTuition = updatedTuition;
                    optimalTuition = desiredMax[i];
                }

            }
        }
        System.out.println(maxTuition + " " + optimalTuition);
    }
}
