package com.company.usaco.bronze.greedy.MadScientist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=1012
 *
 * Task Notes:
 * - FJ ordered N cows (1 <= N <= 1000) of two breeds (H and G)
 * - The order is specified in a string of N characters (H and G)
 * - Order of cows formed a different string (A, B); FJ doesn't want to
 *   re-arrange the cows.
 * - Machins flips all H and Gs in a substring.
 * - Task: Find min # of operations to transform B -> A
 *
 * Solution Notes:
 * - Keep extending substring as long as possible before flipping to avoid unnecessary
 *   operations; Keep extending while there's a mismatch between the letters in the two strings
 *
 * Outcome:
 * - All test cases passed.
 */
public class MadScientist {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\greedy\\MadScientist\\breedflip.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\greedy\\MadScientist\\breedflip.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        String a = reader.readLine();
        String b = reader.readLine();
        int pos = 0;
        int minOperations = 0;
        while (pos < a.length()) {
            boolean misMatch = false;
            while (pos < a.length() && a.charAt(pos) != b.charAt(pos)) {
                misMatch = true;
                pos++;
            }
            pos++;
            if (misMatch) {
                minOperations++;
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(minOperations);
        }

    }
}
