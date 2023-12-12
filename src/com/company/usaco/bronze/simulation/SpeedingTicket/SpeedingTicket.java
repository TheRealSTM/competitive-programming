// package com.company.usaco.bronze.simulation.SpeedingTicket;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=568
 *
 * Problem Notes:
 * - Road is 100 miles long.
 * - Bessie drives the entire length.
 * - Bessie doubts that she was speeding and wants to determine if she was.
 * - Road is divided in N segments - each described by a positive length in miles and a speed limit from 1 ... 100 mph
 * - Length of all segments add up to 100.
 * - Bessie's speed is describe by M segments.
 * - Task: Determine maximum speed that Bessie exceeded the speed segment.
 *    - Use two pointers - one for each array; compare current speeds over the overlapping segments.
 *    - Decrement segments and move on until all segments have been covered.
 *
 * Outcome
 * - All problems solved
 *
 */
public class SpeedingTicket {
    private static String inputFileName = "speeding.in";
    private static String outputFileName = "speeding.out";

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter pw = new PrintWriter(outputFileName)) {
            int roadSegmentCount = scanner.nextInt();
            int bessieSegmentCount = scanner.nextInt();
            int[][] roadSegments = new int[roadSegmentCount][2];
            int[][] bessieSegments = new int[bessieSegmentCount][2];
            for (int i = 0; i < roadSegmentCount; i++) {
                roadSegments[i][0] = scanner.nextInt();
                roadSegments[i][1] = scanner.nextInt();
            }
            for (int i = 0; i < bessieSegmentCount; i++) {
                bessieSegments[i][0] = scanner.nextInt();
                bessieSegments[i][1] = scanner.nextInt();
            }
            int currentRoadSegment = 0, currentBessieSegment = 0, maxSpeedDiff = 0;
            while (currentRoadSegment < roadSegmentCount && currentBessieSegment < bessieSegmentCount) {
                maxSpeedDiff = Math.max(maxSpeedDiff,
                        bessieSegments[currentBessieSegment][1] - roadSegments[currentRoadSegment][1]);
                int roadCovered = Math.min(roadSegments[currentRoadSegment][0], bessieSegments[currentBessieSegment][0]);
                roadSegments[currentRoadSegment][0] -= roadCovered;
                bessieSegments[currentBessieSegment][0] -= roadCovered;
                if (roadSegments[currentRoadSegment][0] == 0) {
                    currentRoadSegment++;
                }
                if (bessieSegments[currentBessieSegment][0] == 0) {
                    currentBessieSegment++;
                }
            }
            pw.println(maxSpeedDiff);
        }
    }
}
