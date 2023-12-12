package com.company.usaco.bronze.basic_complete_search.CrossTheRoad2;


import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=712
 *
 * Task Notes:
 * - Determine how many crossing pairs are present: a pair of cows (a,b) a "crossing" pair if cow a's
 * path from entry to exit must cross cow b's path from entry to exit.
 *
 * Solution Notes:
 * - Keep a map of the starting and ending positions for each character
 * - Cycle through all of the letters and compare it to all of the other letters
 * - Outer loop checks if the letter corresponds to a  in the crossing pair description
 * - Inner loop checks if the letter corresponds to b in the crossing pair description
 *
 * Outcome:
 * - All test cases pass
 */
public class CrossTheRoad2 {
    static String inputFileName = "circlecross.in";
    static String outputFileName = "circlecross.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        char[] input = scanner.nextLine().toCharArray();
        Map<Character, List<Integer>> charPositionMap = new HashMap<>();
        for (int i = 0; i < 52; i++) {
            charPositionMap.computeIfAbsent(input[i], k -> new ArrayList<>()).add(i);
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26;j ++ ) {
                List<Integer> iPositions = charPositionMap.get((char)('A' + i));
                List<Integer> jPositions = charPositionMap.get((char)('A' + j));
                if ((iPositions.get(0) < jPositions.get(0) && iPositions.get(1) > jPositions.get(0) &&
                        iPositions.get(1) < jPositions.get(1))) {
                    count++;
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(count);
        }
    }
}
