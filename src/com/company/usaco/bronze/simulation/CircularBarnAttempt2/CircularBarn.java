// package com.company.usaco.bronze.simulation.CircularBarnAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=616
 *
 * Task Notes:
 * - FJ has built a barn in the shape of a circular.
 * - Barn consists of n rooms (1 to n) around the perimeter of the barn (3 <= n <= 1000)
 * - Each room has to neighboring doors.
 * - FJ wants exact r_i cows in each room where 1 <= r_i <= 100.
 * - FJ will unlock exactly one door. Cows then walk clockwise through the relevant rooms.
 * - FJ wants to minimize the distance walked.
 * - Please determine the min distance walked if he picks the optimal door & distance is the number of exterior
 *   doors that the cow has to walk past.
 *
 * Input Notes:
 * - first line is n
 * - The next n lines are r_1, r_2, ..., r_n
 *
 * Output Notes:
 * - Output min distance
 *
 * Solution Notes:
 * - Try all possible combinations and output the min. Use modulo to figure out distance if target door is less than
 *   entrance door.
 *
 * Outcome:
 * -
 */
public class CircularBarn {
    static String inputFileName = "cbarn.in";
    static String outputFileName = "cbarn.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int numDoors = scanner.nextInt();
        int[] targetCowsPerRoom = new int[numDoors];
        for (int i = 0; i < numDoors; i++) {
            targetCowsPerRoom[i] = scanner.nextInt();
        }
        int minDoorsWalked = Integer.MAX_VALUE;
        for (int i = 0; i < numDoors; i++) {
            int doorsWalked = 0;
            for (int j = 0; j < numDoors; j++) {
                int doorDifference = (j < i) ? (numDoors - i + j) : j - i;
                doorsWalked += (targetCowsPerRoom[j] * doorDifference);
            }
            minDoorsWalked = Math.min(minDoorsWalked, doorsWalked);
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(minDoorsWalked);
        }
    }
}

