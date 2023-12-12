package com.company.usaco.bronze.basic_complete_search;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem Description: https://codeforces.com/gym/102951/problem/A
 *
 * Solution:
 * - Cycle through all the points calculating the squared distance
 *
 * Outcome:
 * - All testcases were passed.
 */
public class MaximumDistance {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numPoints = scanner.nextInt();
        int[] x = new int[numPoints];
        int[] y = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < numPoints; i++) {
            y[i] = scanner.nextInt();
        }
        int maxDistance = 0;
        for (int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                int distance = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                maxDistance = Math.max(distance, maxDistance);
            }
        }
        System.out.println(maxDistance);
    }
}
