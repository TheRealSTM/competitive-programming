package com.company.usaco.bronze.simulation.BovineShuffle;

import java.io.*;
import java.util.Arrays;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=760
 *
 * Notes:
 * - N cows (1 <= N <= 100)
 * - line up in a row then perform 3 shuffles in a row
 * - They will be lined up in a different order
 * - FJ marks positions of the cows
 * - Shuffle consists of N numbers (a1, ..., aN) where a cow in position i moves to position ai
 * - all ais are distinct so no two costs move the same position
 * - Each cow is a ssigned a distinct 7-digit ID number
 * - Task: given the order after 3 shuffles, determine the initial order
 *
 * Thoughts:
 * - Create a new index the corresponds to a[i] -> i to reverse the order
 *
 * Outcome:
 * - All test cases passed
 *
 *
 */
public class BovineShuffle {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BovineShuffle\\shuffle.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BovineShuffle\\shuffle.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        int[] shuffleOrder = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] reverseShuffleOrder = new int[n];
        for (int i = 0; i < n; i++) {
            reverseShuffleOrder[shuffleOrder[i] - 1] = i;
        }
        int[] currentPositions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int round = 0; round < 3; round++) {
            int[] updatedPositions = new int[n];
            for (int pos = 0; pos < n; pos++) {
                updatedPositions[reverseShuffleOrder[pos]] = currentPositions[pos];
            }
            currentPositions = updatedPositions;
        }
        PrintWriter pw = new PrintWriter(outputFileName);
        Arrays.stream(currentPositions).forEach(pw::println);
        pw.close();
    }
}
