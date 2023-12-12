// package com.company.usaco.bronze.basic_complete_search.Triangles;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=1011
 *
 * Task Notes:
 * - Create a triangular pasture
 * - N fence posts (3 <= N <= 100) at Distinct Points (x1, y1) ... (xN, yN)
 * - He can chose three of them to form the vertices of the triangular pasture as long as of the sides
 *   is parallel to the x-axis and onother is parallel to the y-axis.
 * - What is the maximum area of the pasture that FJ can form?
 * - At least, one triangular pasture must exist.
 *
 * Solution Notes:
 * - Consider all triplets
 * - Points are parallel to x-axis if the points share the same y
 *
 * Outcome:
 * -
 */
public class Triangles {
    static String inputFileName = "triangles.in";
    static String outputFileName = "triangles.out";
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        int[] xPoints = new int[n];
        int[] yPoints = new int[n];
        for (int i = 0; i < n; i++) {
            xPoints[i] = scanner.nextInt();
            yPoints[i] = scanner.nextInt();
        }
        int maxArea = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || i == k) continue;
                    if (yPoints[i] != yPoints[j] && yPoints[j] != yPoints[k] && yPoints[i] != yPoints[k]) continue;
                    if (xPoints[i] != xPoints[j] && xPoints[j] != xPoints[k] && xPoints[i] != xPoints[k]) continue;
                    int xDist = -1, yDist = -1;
                    if (yPoints[i] == yPoints[j]) {
                        xDist = Math.abs(xPoints[i] - xPoints[j]);
                    } else if (yPoints[j] == yPoints[k]) {
                        xDist = Math.abs(xPoints[j] - xPoints[k]);
                    } else {
                        xDist = Math.abs(xPoints[i] - xPoints[k]);
                    }
                    if (xPoints[i] == xPoints[j]) {
                        yDist = Math.abs(yPoints[i] - yPoints[j]);
                    } else if (xPoints[j] == xPoints[k]) {
                        yDist = Math.abs(yPoints[j] - yPoints[k]);
                    } else {
                        yDist = Math.abs(yPoints[i] - yPoints[k]);
                    }
                    maxArea = Math.max(maxArea, (xDist * yDist));
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(maxArea);
        }
    }

}
