// package com.company.usaco.bronze.simulation.BlockGameAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=664
 *
 * Task Notes:
 * - FJ is teaching his cows to read with a set of N boards (1 <= N <= 100)
 * - The boards have images & words on each side. All N boards are on the ground with one side up.
 * - FJ wants to help with spelling so all words that are facing up can be spelled.
 * - Help FJ determine the number of boards that he needs to help with spelling.
 *
 *
 * Input Notes:
 * - N
 * - Boards (front & back)
 *
 * Output Notes:
 * - output 26 lines - one for each board
 *
 * Solution Notes:
 * - If a letter isn't shared between front and back, then you need to add it. If it is shared, then you need max number
 *   of the letter in a word.
 *   - The approach used was the same one that was used by usaco.guide and the official solution.
 *
 * Optimizations:
 * - Keep a set of letters seen between the front and back - interestingly this was slower than the version using only
 *   arrays.
 *
 * Outcome:
 * - All test cases pass.
 */
public class BlockGame {
    static String inputFileName = "blocks.in";
    static String outputFileName = "blocks.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int numBoards = Integer.parseInt(scanner.nextLine());
        int[] letCount = new int[26];
        for (int i = 0; i < numBoards; i++) {
            String[] pair = scanner.nextLine().split(" ");
            int[] letCountFront = new int[26];
            Set<Character> letSet = new HashSet<>();
            for (char let: pair[0].toCharArray()) {
                letCountFront[let - 'a']++;
                letSet.add(let);
            }
            int[] letCountBack = new int[26];
            for (char let: pair[1].toCharArray()) {
                letCountBack[let - 'a']++;
                letSet.add(let);
            }
            for (char let: letSet) {
                letCount[let - 'a'] += Math.max(letCountFront[let - 'a'], letCountBack[let - 'a']);
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            for (int i = 0; i < 26; i++) {
                pw.println(letCount[i]);
            }
        }
    }
}
