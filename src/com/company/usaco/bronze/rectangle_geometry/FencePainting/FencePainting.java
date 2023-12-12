package com.company.usaco.bronze.rectangle_geometry.FencePainting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=567
 *
 * Task Notes:
 * - Paint FJ's fence
 * - Fence is a 1D number line, FJ paints from [a, b)
 * - Bessie paints from [c, d), which may overlap with part or all of FJ's interval
 * - Task: Determine portion of the fence that's covered in paint
 *
 * Solution Notes:
 * - Cases (6 Scenarios):
 *   1. No overlap
 *   2. Partial overlap
 *   3. One complete covers the other
 *
 *   7th Scenario: Exact match
 *
 *  This approach would work for really large values into the billions
 *
 * Outcome:
 * - Satisified all 10 cases
 *
 * Alternate approach:
 * - Use an array of size 100 and say whether a given region is filled in for each of the segments
 * - Cycle through the array and count how many filled in segments there are
 * - This approach is less error-prone
 *
 * An even better approach is to calculate the total distance  - intersection
 * Total = (d - c) + (a - b)
 * Intersection =
 */
public class FencePainting {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\rectangle_geometry\\FencePainting\\paint.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\rectangle_geometry\\FencePainting\\paint.out";


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int paintCoverage = -1;
        if (c < a && d <= a) {
            paintCoverage = (b - a) + (d - c);
        } else if (c < a && d <= b) {
            paintCoverage = (a - c) + (b - a);
        } else if (c < a) {
            paintCoverage = (d - c);
        } else if (a < c && b <= c) {
            paintCoverage = (b - a) + (d - c);
        } else if (a < c && b <= d) {
            paintCoverage = (c - a) + (d - c);
        } else if (a < c) {
            paintCoverage = b - a;
        } else {
            paintCoverage = b - a;
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(paintCoverage);
        }
    }
}
