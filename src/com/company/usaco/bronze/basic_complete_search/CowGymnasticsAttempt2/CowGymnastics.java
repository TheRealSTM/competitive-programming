package com.company.usaco.bronze.basic_complete_search.CowGymnasticsAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=963
 *
 * Task Notes:
 * - Bessie will coach N other cows as they learn gymnastics.
 * - In K practice sessions (1 <= K <= 10), Bessie ranks the N cows according to their performance (1 <= N <= 20).
 * - She is curious about consistency (a cow is more consistent than another if they performed better in each session).
 * - Compute total number of consistent pairings.
 *
 * Input Notes:
 * - First line contains K and N (space-separated)
 * - Next K lines contain N numbers representing how the cow did relative to other cows in session (A B) indiactes
 *   that A did better than B.
 *
 * Output Notes:
 * - Number of consistent pairings
 *
 * Solution Notes:
 * - Since the numbers are so small, we can use a bruteforce approach that's n^4 because we cycle through
 *   all pairing. For each pairing, we perform N^2 operations to check if they are consistent.
 * - One could reduce to N^3 by storing a mapping of where the cow was to its position, so we don't need to search
 *   through the loop. (Taking an O(N) operation to an O(1) operation)
 *
 * Outcome:
 * - All test cases pass.
 */
public class CowGymnastics {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\CowGymnasticsAttempt2\\gymnastics.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\CowGymnasticsAttempt2\\gymnastics.out";

    static Map<Integer, Map<Integer, Integer>> cowPositionMapping = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int k = scanner.nextInt(), n = scanner.nextInt();
        int[][] results = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                results[i][j] = scanner.nextInt();
                if (cowPositionMapping.containsKey(results[i][j])) {
                    Map<Integer, Integer> positionMapping = cowPositionMapping.get(results[i][j]);
                    positionMapping.put(i, j);
                } else {
                    cowPositionMapping.put(results[i][j], new HashMap<>(Map.of(i, j)));
                }

            }
        }
        int consistentPairings = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isConsistentPairing(results, i, j)) {
                    consistentPairings++;
                }
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(consistentPairings);
        }
    }

    private static boolean isConsistentPairing(int[][] results, int cow1, int cow2) {
        boolean isCow1Dominant = cowPositionMapping.get(cow1).get(0) > cowPositionMapping.get(cow2).get(0);
        for (int i = 1; i < results.length; i++) {
            if ((isCow1Dominant && cowPositionMapping.get(cow1).get(i) < cowPositionMapping.get(cow2).get(i)) ||
                    (!isCow1Dominant && cowPositionMapping.get(cow1).get(i) > cowPositionMapping.get(cow2).get(i))
            ) {
                return false;
            }
        }
        return true;
    }
}
