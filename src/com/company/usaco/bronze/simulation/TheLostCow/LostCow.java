package com.company.usaco.bronze.simulation.TheLostCow;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=735
 */
public class LostCow {
    private static String inputFileName = "lostcow.in";
    private static String outputFileName = "lostcow.out";


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));
        PrintWriter pw = new PrintWriter(outputFileName);
        int farmerPos = scanner.nextInt();
        int bessiePos = scanner.nextInt();
        if (farmerPos == bessiePos) {
            pw.println(0);
        }
        int totalDistance = 0, nextDistance = 1;
        int direction = 1;
        while (true) {
            // We need the direction because there are scenarios where nextDistance may be sufficiently big where it
            // satisfies the bessie-related position condition but we are not actually going in that direction
            if ((direction == 1 && farmerPos < bessiePos && (farmerPos + nextDistance) >= bessiePos) ||
                    (direction == -1 && farmerPos > bessiePos && (farmerPos - nextDistance <= bessiePos)))  {
                totalDistance += Math.abs(bessiePos - farmerPos);
                break;
            } else {
                totalDistance += 2 * nextDistance;
                nextDistance *= 2;
                direction *= -1;
            }
        }
        pw.println(totalDistance);
        pw.close();
    }
}
