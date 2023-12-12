// package com.company.usaco.bronze.simulation.CircularBarn;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=616
 *
 * Notes:
 * - barn is in the shape of a circle
 * - barn consists of n rooms (numbered clockwise from 1 .. n)
 *   where 3 <= n <= 1000
 * - There are 2 neighboring doors next to a given door
 * - FJ wants exactly r_i cows to end up in each room.
 * - One exterior door will be opened and the cows will walk through the adjacent connecting
 *   doors to the desired room
 * - Task: FJ wants to minimize the distance walked. Determine the min distance walked, given best
 *   option is selected. Distance is measured by number of doors walked past.
 *
 * Thoughts:
 * - Calculate the distance for each position and print the lowest one out
 *
 * Outcome:
 * - Solved all of the test cases
 */
public class CircularBarn {

    static String inputFileName = "cbarn.in";
    static String outputFileName = "cbarn.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));
        int n = scanner.nextInt();
        int[] roomCapacity = new int[n];
        for (int i = 0; i < n; i++) {
            roomCapacity[i] = scanner.nextInt();
        }
        int totalMinDistanceTravel = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int distanceTraveled = 0;
            for (int j = 0; j < n; j++) {
                int minDistance;
                if (j < i) {
                    minDistance = j + (n - i);
                } else {
                    minDistance = j - i;
                }
                distanceTraveled += (minDistance * roomCapacity[j]);
            }
            totalMinDistanceTravel = Math.min(totalMinDistanceTravel, distanceTraveled);
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(totalMinDistanceTravel);
        }
    }
}

