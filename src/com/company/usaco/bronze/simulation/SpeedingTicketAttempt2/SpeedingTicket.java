package com.company.usaco.bronze.simulation.SpeedingTicketAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=568
 *
 * Task Notes:
 * - Bessie stole a tractor and is driving down the road. The road is 100 miles long.
 * - Bessie got a speeding ticket & wants to determine if it is valid.
 * - The road is divided into N segments (THey have a length & speed limit).
 * - Bessie's journey is described by a series of M segments (length at a given speed)
 * - Determine max amount over that Bessie exceeded the speed limit
 *
 * Input Notes:
 * - N segments describing the road & M segments describing Bessie's speeds
 *
 * Output Notes:
 * - Max speed over the limit or 0
 *
 * Solution Notes:
 * - Cycle through each mile (compare bessie segment speed vs the road segment speed)
 * - Store the maxSpeed = Math.max(maxSpeed, Math.max(0, bessie[0].speed - road[0].speed)
 * - increment bessie position & update segment that bessie's current position belongs to
 *
 * Outcome:
 * - All test cases pass on the first try
 */
public class SpeedingTicket {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\SpeedingTicketAttempt2\\speeding.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\SpeedingTicketAttempt2\\speeding.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int[] currentSpeedLimit = new int[101];
        int[] currentBessieSpeed = new int[101];
        int roadSegments = scanner.nextInt(), bessieSegment = scanner.nextInt();
        int currentRoadMile = 1;
        for (int i = 0; i < roadSegments; i++) {
            int segmentLength = scanner.nextInt(), segmentSpeed = scanner.nextInt();
            for (int j = 0; j < segmentLength; j++) {
                currentSpeedLimit[currentRoadMile++] = segmentSpeed;
            }
        }
        currentRoadMile = 1;
        for (int i = 0; i < bessieSegment; i++) {
            int bessieSegmentLength = scanner.nextInt(), bessieSpeed = scanner.nextInt();
            for (int j = 0; j < bessieSegmentLength; j++) {
                currentBessieSpeed[currentRoadMile++] = bessieSpeed;
            }
        }

        int maxDifference = 0;
        for (int mile = 1; mile <= 100; mile++) {
            maxDifference = Math.max(maxDifference, Math.max(0, currentBessieSpeed[mile] - currentSpeedLimit[mile]));
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(maxDifference);
        }
    }
}

