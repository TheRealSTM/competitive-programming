// package com.company.usaco.bronze.sorting.WhyDidTheCowsCrossTheRoad3;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=713
 *
 * Task Notes:
 * - Cows can only enter through a single gate where each cow is subject to intense questioning
 *   - Cows queue up in a long line
 * - N cows visiting the farm - we are given time of approval and duration to answer questions
 * - Only cow is questioned at a time
 * - Task determine the earliest time that all of the cows may enter the farm
 *
 * Solution Notes:
 * - Sort by the time arrived, then calculate the total duration based on the two potential conditions
 *
 * Outcome:
 * - All test cases passed
 */
public class CowsCrossRoad3 {
    static String inputFileName = "cowqueue.in";
    static String outputFileName = "cowqueue.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        int[][] cowQueue = new int[n][2];
        for (int i = 0; i < n; i++) {
            cowQueue[i][0] = scanner.nextInt();
            cowQueue[i][1] = scanner.nextInt();
        }
        Arrays.sort(cowQueue, (a, b) -> a[0] - b[0]);
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            if (currentTime < cowQueue[i][0]) {
                currentTime += (cowQueue[i][0] - currentTime) + cowQueue[i][1];
            } else {
                currentTime += cowQueue[i][1];
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(currentTime);
        }
    }
}
