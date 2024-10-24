package com.company.usaco.bronze.simulation.BovineShuffleAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=760
 *
 * Task Notes:
 * - Cows are learning to dance the Bovine Shuffle.
 * - The bovine shuffle consists of N cows (1 <= N <= 100), then perform 3 shuffles in a row where may be in different
 *   positions.
 * - FJ marked positions 1, 2, ... N.
 * - A shuffle is described with N numbers (a_1, ..., a_N) where the cow in position i move to position a_i (all are distinct).
 * - Every cow moves to its new location during the suffle.
 * - FJ assigned each a cow a distinct 7 digit integer ID. If you are given the order of the cows after three shuffles,
 *   determine the original order.
 *
 * Input Notes:
 * - First line contains N, next line contains N integers a_i to a_N. The final line contains the order of the N
 *   cows after the three shuffles.
 *
 * Output Notes:
 * - Output N lines with a single cow ID per line.
 *
 * Solution Notes:
 * - Determine the reverse order cow in a_i must have been in position i.
 * - Perform 3 reverse shuffle.
 *
 * Outcome:
 * -
 */
public class BovineShuffle {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BovineShuffleAttempt2\\shuffle.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BovineShuffleAttempt2\\shuffle.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int numCows = Integer.parseInt(scanner.nextLine());
        int[] reverseShufflePositions = new int[numCows];
        int[] shufflePositions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] cowPositionIdMapping = Arrays.stream(scanner.nextLine().split(" ")).toArray(String[]::new);
        for (int i = 0; i < numCows; i++) {
            reverseShufflePositions[shufflePositions[i] - 1] = i;
        }
        for (int round = 0; round < 3; round++) {
            String[] updatedCowPositionIdMapping = new String[numCows];
            for (int i = 0; i < numCows; i++) {
                updatedCowPositionIdMapping[reverseShufflePositions[i]] = cowPositionIdMapping[i];
            }
            cowPositionIdMapping = updatedCowPositionIdMapping;
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            Arrays.stream(cowPositionIdMapping).forEach(pw::println);
        }
    }
}
