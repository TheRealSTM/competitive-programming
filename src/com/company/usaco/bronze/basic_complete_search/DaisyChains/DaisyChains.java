package com.company.usaco.bronze.basic_complete_search.DaisyChains;

import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=759
 *
 * Task Notes:
 * - Pasture has N flowers labeled (1 .. N) where (1 <= N <= 100).
 * - Each flower has pi petals where 1 <= p_i <= 1000
 * - Bessie takes a picture of flower [i, j]
 * - Bessie looks at the pictures and notices some of the flowers are average flowers (a flower that
 *   has P petals where P is the exact average number of petals among all flowers in the photo
 * - Task: How many average flowers?
 *
 * Solution Notes:
 * - Cycle through all ranges using O(n^2) and calculates the average for the range
 * - Cycle through the flowers in the range to check if any of them are equal to the average
 *
 * Outcome Notes:
 * - All test cases passed
 */
public class DaisyChains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] flowerPetals = new int[n];
        for (int i = 0; i < n; i++) {
            flowerPetals[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += flowerPetals[k];
                }
                double average = sum / (1.0 * (j - i  + 1));
                for (int k = i; k <= j; k++) {
                    if (flowerPetals[k] == average) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
