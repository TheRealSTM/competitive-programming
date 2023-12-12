package com.company.usaco.bronze.basic_complete_search.LifeGuards;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=784
 *
 * Task Notes:
 * - FJ has opened a pool
 * - He hires N cows as lifeguards. They work some contiguous shift during the day.
 * - Pool opens at t = 0 until t = 1000 on a daily basis
 * - Shifts can be described by two integers (start and end)
 *   - ex: 4 7 -> [4, 7) so 3 units of time
 * - FJ hired 1 more lifeguard than can be paid.
 * - Task: Determine max time that can still be covered with the remaining lifegurads.
 *
 * Solution Notes:
 * - Since n is small (n <= 100), we remove each one and calculate coverage. Keeping track of the amount fo time.
 * - Use an array of 1001 to keep track of covered time
 *
 * Outcome:
 * - All test cases pass
 */
public class LifeGuards {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\LifeGuards\\lifeguards.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\LifeGuards\\lifeguards.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startTimes[i] = scanner.nextInt();
            endTimes[i] = scanner.nextInt();
        }

        int maxTime = 0;
        for (int cowExcluded = 0; cowExcluded < n; cowExcluded++) {
            boolean[] timeCovered = new boolean[1001];
            for (int workingCowIndex = 0; workingCowIndex < n; workingCowIndex++) {
                if (workingCowIndex != cowExcluded) {
                    for (int time = startTimes[workingCowIndex]; time < endTimes[workingCowIndex]; time++) {
                        timeCovered[time] = true;
                    }
                }
            }
            int currCoverage = 0;
            for (int i = 0; i < 1001; i++) {
                currCoverage += timeCovered[i] ? 1 : 0;
            }
            maxTime = Math.max(maxTime, currCoverage);
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(maxTime);
        }
    }
}
