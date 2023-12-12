package com.company.usaco.bronze.rectangle_geometry.SquarePasture;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem:
 *
 * Task Notes:
 * - Determine the minimum single square that covers area of the previous two rectangular farms
 *
 * Solution Notes:
 * - Determine min/max of the potential corners.
 * - Chose bigger side and determine its square
 *
 * Outcome:
 * - all test cases pass
 */
public class SquarePasture {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\rectangle_geometry\\SquarePasture\\square.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\rectangle_geometry\\SquarePasture\\square.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int area = 0;
        int lowerLeftX1 = scanner.nextInt();
        int lowerLeftY1 = scanner.nextInt();
        int upperRightX1 = scanner.nextInt();
        int upperRightY1 = scanner.nextInt();
        int lowerLeftX2 = scanner.nextInt();
        int lowerLeftY2 = scanner.nextInt();
        int upperRightX2 = scanner.nextInt();
        int upperRightY2 = scanner.nextInt();

        int maxUpperRightX = Math.max(upperRightX1, upperRightX2);
        int maxUpperRightY = Math.max(upperRightY1, upperRightY2);
        int minLowerLeftX = Math.min(lowerLeftX1, lowerLeftX2);
        int minLowerLeftY = Math.min(lowerLeftY1, lowerLeftY2);

        int side = Math.max(maxUpperRightX - minLowerLeftX, maxUpperRightY - minLowerLeftY);

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(side * side);
        }
    }
}
