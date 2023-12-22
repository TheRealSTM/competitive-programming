// package com.company.usaco.bronze.rectangle_geometry.BlockedBillboard;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=759
 *
 * Task Notes:
 * - There are two billboards
 * - Truck parks in front of billboards - blocking the view
 * - Input: First line is the coordinates of the first billboard (lower-left and upper-right),
 *          Second line has coordinates of the second billboard. Third line contains the
 *          trucks coordinates. Billboards don't overlap
 * - The billboards do not overlap.
 * - Task: Given the location of the truck and the billboards, calculate the combined area of the billboards
 *   that are still visible. Truck may block neither, both or only one of the billboards
 *
 * Solution Notes:
 * - Calculate the overlap in the x direction of the billboard and truck for each billboard and do a similar calculation
 *   for the y-axis.
 * - subtract the overlap for each truck from the area of the two billboards
 *
 * Outcome Notes:
 * - All test cases pass.
 */
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    Point lowerLeftPoint;
    Point upperRightPoint;

    public Rectangle(Point ll, Point ur) {
        lowerLeftPoint = ll;
        upperRightPoint = ur;
    }

    int calculateArea() {
        return (upperRightPoint.x - lowerLeftPoint.x) * (upperRightPoint.y - lowerLeftPoint.y);
    }

    int calculateOverlap(Rectangle rectangle) {
        int xOverlap = Math.max(0, Math.min(upperRightPoint.x, rectangle.upperRightPoint.x) - Math.max(lowerLeftPoint.x, rectangle.lowerLeftPoint.x));
        int yOverlap = Math.max(0, Math.min(upperRightPoint.y, rectangle.upperRightPoint.y) - Math.max(lowerLeftPoint.y, rectangle.lowerLeftPoint.y));
        return xOverlap * yOverlap;
    }
}


public class BlockedBillboard {
    static String inputFileName = "billboard.in";
    static String outputFileName = "billboard.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        Rectangle billBoard1 = populateRectangle(scanner);
        Rectangle billboard2 = populateRectangle(scanner);
        Rectangle truck = populateRectangle(scanner);

        int visibleBillboards = billboard2.calculateArea() + billBoard1.calculateArea()
                - (billBoard1.calculateOverlap(truck) + billboard2.calculateOverlap(truck));
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(visibleBillboards);
        }
    }

    private static Rectangle populateRectangle(Scanner scanner) {
        return new Rectangle(new Point(scanner.nextInt(), scanner.nextInt()),
                             new Point(scanner.nextInt(), scanner.nextInt()));
    }
}
