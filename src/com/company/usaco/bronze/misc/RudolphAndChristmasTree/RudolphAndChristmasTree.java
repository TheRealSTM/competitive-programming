package com.company.usaco.bronze.misc.RudolphAndChristmasTree;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem: https://codeforces.com/contest/1846/problem/D
 *
 * Task Notes:
 * - Rudolph wants to print a picture, but there's an issue with insufficient ink.
 * - Rudolph wants to calculate how much ink he will need
 * - Christmas tree is constructed from identical christmas trees at different heights
 * - The branches are isosceles triangles with base d and height.
 * - The trunk passes exactly in the middle.
 * - The base of the ith triangle is located at height y_i
 *
 * Input Notes:
 * - The first line is t for the number of test cases.
 * - For each test case, the first line has n, d, and h
 * - The next line has n integers where y1 < y2 < ... < yn (aka heights of the triangles)
 *
 * Output Notes:
 * - Output a single real #
 *
 * Solution Notes:
 * - We will likely need to calculate area of triangles (area of triangle = base * height * 1/2)
 *   - Isosceles triangles have at least 2 sides of equal length.
 * - The problem boils down to figure out the overlap
 *
 * Outcome:
 * - All test cases pass
 * - Another approach would be to calculate the area of a trapezoid,
 */
public class RudolphAndChristmasTree {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long d = scanner.nextInt();
            long h = scanner.nextInt();
            int[] branchPositions = new int[n];
            for (int j = 0; j < n; j++) {
                branchPositions[j] = scanner.nextInt();
            }
            double totalArea = calculateTotalArea(d, h, branchPositions);
            System.out.println(totalArea);
        }
    }

    private static double calculateTotalArea(long d, long h, int[] branchPositions) {
        double totalArea = 0;
        double wholeTriangleArea = (h * d * 0.5);
        for (int i = 0; i < branchPositions.length; i++) {
            if (i == (branchPositions.length - 1) || branchPositions[i] + h <= branchPositions[i + 1]) {
                totalArea += wholeTriangleArea;
            } else {
                long heightSmallerTri = h - (branchPositions[i + 1] - branchPositions[i]);
                totalArea += (wholeTriangleArea - (heightSmallerTri * ((heightSmallerTri * d * 1.0) / h) * 0.5));
            }

        }
        return totalArea;
    }
}
