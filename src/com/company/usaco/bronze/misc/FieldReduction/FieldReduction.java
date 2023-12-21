package com.company.usaco.bronze.misc.FieldReduction;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=642
 *
 * Task Notes:
 * - FJ has N cows where 5 <= N <= 50000. They are all located at different positions
 *   on a 2D plane
 * - FJ wants to enclose all the cows with a rectangular fence whose sides are parallel to x
 *   and y-axis
 * - He wants to minimize size of fence (cows can be on boundary)
 * - He wants to make the fence even smaller and is willing to sell 3 cows
 * - Task: Compute the smallest area if up to 3 cows are sold (0 cows may be sold)
 *
 * Input Notes:
 * - Cow positions range from 1 to 40000
 *
 * Output Notes:
 * - Min area
 *
 * Solution Notes:
 * - If we are going to remove any points, it would be the biggest or smallest values.
 * - For any given side, there are 4 potential points that we could remove.
 * - We can do a complete search of the potential points so its 4^4 choices.
 * - In order to determine if a given set of points is up for consideration, we check that the total cows
 *   within the updated range is within 3 of the initial number of cows.
 * - We keep track of the min area.
 *
 * Outcome:
 * - All testcases pass (10/10)
 */
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FieldReduction {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\misc\\FieldReduction\\reduce.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\misc\\FieldReduction\\reduce.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        Point[] smallestX = new Point[4];
        for (int i = 0; i < 4; i++) {
            smallestX[i] = new Point(points[i].x, points[i].y);
        }
        Point[] biggestX = new Point[4];
        for (int i = points.length - 1, j = 0; i >= points.length - 1 - 3; i--) {
            biggestX[j++] = new Point(points[i].x, points[i].y);
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p.y));
        Point[] smallestY = new Point[4];
        for (int i = 0; i < 4; i++) {
            smallestY[i] = new Point(points[i].x, points[i].y);
        }
        Point[] biggestY = new Point[4];
        for (int i = points.length - 1, j = 0; i >= points.length - 1 - 3; i--) {
            biggestY[j++] = new Point(points[i].x, points[i].y);
        }
        int minArea = Integer.MAX_VALUE;
        for (Point xSmall: smallestX) {
            for (Point xBig: biggestX) {
                for (Point ySmall: smallestY) {
                    for (Point yBig: biggestY) {
                        int total = 0;
                        for (Point currPoint: points) {
                            if (currPoint.x >= xSmall.x && currPoint.x <= xBig.x && currPoint.y >= ySmall.y && currPoint.y <= yBig.y) {
                                total++;
                            }
                        }
                        if (total >= (points.length - 3)) {
                            minArea = Math.min(minArea, (xBig.x - xSmall.x) * (yBig.y - ySmall.y));
                        }
                    }
                }
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(minArea);
        }
    }
}
