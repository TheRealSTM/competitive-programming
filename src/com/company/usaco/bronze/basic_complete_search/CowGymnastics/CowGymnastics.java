package com.company.usaco.bronze.basic_complete_search.CowGymnastics;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=963
 *
 * Task Notes:
 * - Bessie and N other cows perform gymnastics (Bessie judges the cows)
 * - There are K practice sessions (1 <= K <= 10)
 * - Bessie ranks cows (1 <= N <= 20)
 * - She is interested in consistency where a given cow performs better than a different cow.
 * - Compute total number of consistent pairs
 *
 * Solution Notes:
 * - Cycle through all cow pairs
 * - Choose pairs where i > j for all rounds of practice (this avoids double counting); another option
 *   would be to keep track of scenarios where i < j for all rounds.
 *
 * Outcome:
 * - All test cases passed.
 */
public class CowGymnastics {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\CowGymnastics\\gymnastics.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\CowGymnastics\\gymnastics.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] practiceResults = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                practiceResults[i][j] = scanner.nextInt();
            }
        }
        int consistentResults = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                boolean consistent = true;
                for (int r = 0; r < k; r++) {
                    int iPos = findPos(i, practiceResults[r]);
                    int jPos = findPos(j, practiceResults[r]);
                    if (iPos < jPos) {
                        consistent = false;
                    }
                }
                if (consistent) {
                    consistentResults++;
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(consistentResults);
        }
    }

    private static int findPos(int pos, int[] round) {
        for (int i = 0; i < round.length; i++) {
            if (round[i] == pos) {
                return i;
            }
        }
        return -1;
    }
}
