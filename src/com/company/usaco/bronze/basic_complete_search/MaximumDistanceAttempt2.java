// package com.company.usaco.bronze.basic_complete_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: https://codeforces.com/gym/102951/problem/A
 *
 * Task Notes:
 * - You are given N where 3 <= N <= 5000 integer points on the coordinate plane. Find the square of the maximum
 *   Euclidean distance (length of the straight line) between any two of the points.
 *
 * Input Notes:
 * - N where (N between 3 and 5000).
 * - Second line contains N x points where (-1000 <= x <= 1000)
 * - Third line contaisn N y points where (-1000 <= y <= 1000)
 *
 * Output Notes:
 * - Output the max
 *
 * Solution Notes:
 * - Cycle through all combinations - search space is 5000 * 5000 = 25M combinations which can be checked in < 4 seconds
 * - distance = squart root((x_2 - x_1)^2 + (y_2 - y_1)^2)
 * - Max possible distance is 2000^2 + 2000^2 = 4M + 4M = 8M <<< 4B
 *
 * Outcome:
 * - All test cases pass.
 */
public class MaximumDistanceAttempt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] xPositions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] yPositions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxDist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dist = (int) (Math.pow(xPositions[i] - xPositions[j], 2.0) + Math.pow(yPositions[i] - yPositions[j], 2.0));
                maxDist = Math.max(dist, maxDist);
            }
        }
        System.out.println(maxDist);
    }
}
