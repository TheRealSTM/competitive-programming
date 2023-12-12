package com.company.usaco.bronze.simulation.BlockGame;

import java.io.*;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=759
 *
 * Task Notes:
 * - There are N spelling boards (1 <= N <= 100)
 * - Each board has a word and image on each side; if the board is flipped, a
 *   different word/image pair is shown
 * - FJ wants to create blocks with single letters on them
 * - He wants enough letters such that the cows can spell any word that's being shown
 *
 * Solution Notes:
 * - For each letter, check max count and increment letter count array
 *
 * Outcome Notes:
 * - All tests passed
 */
public class BlockGame {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BlockGame\\blocks.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BlockGame\\blocks.out";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] letCount = new int[26];
        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            String front = line[0];
            String back = line[1];

            for (int j = 0; j < 26; j++) {
                int frontLetCount = 0, backLetCount = 0;
                for (char let : front.toCharArray()) {
                    if (let == (char)('a' + j)) {
                        frontLetCount++;
                    }
                }
                for (char let: back.toCharArray()) {
                    if (let == (char)('a' + j)) {
                        backLetCount++;
                    }
                }
                letCount[j] += Math.max(frontLetCount, backLetCount);
            }
        }
        PrintWriter pw = new PrintWriter(outputFileName);
        for (int i = 0; i < 26; i++) {
            pw.println(letCount[i]);
        }
        pw.close();
    }
}
