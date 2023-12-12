package com.company.usaco.bronze.adhoc.SleepyCowHerding;

import java.io.*;
import java.util.Arrays;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=915
 * Outcome: All cases passed
 */
public class SleepyCowHerding {
    private static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\adhoc\\SleepyCowHerding\\herding.in";
    private static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\adhoc\\SleepyCowHerding\\herding.out";

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter pw = new PrintWriter(outputFileName)) {
            int[] cowPositions = new int[3];
            cowPositions = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(cowPositions);
            int cowPos1 = cowPositions[0];
            int cowPos2 = cowPositions[1];
            int cowPos3 = cowPositions[2];
            int minMoves = getMinMoves(cowPos1, cowPos2, cowPos3);
            int maxMoves = getMaxMoves(cowPos1, cowPos2, cowPos3);
            pw.println(minMoves);
            pw.println(maxMoves);
        }
    }

    private static int getMinMoves(int cowPos1, int cowPos2, int cowPos3) {
        if (cowPos3 - cowPos1 == 2) {
            return 0;
        }
        if ((cowPos2 - cowPos1) == 2 || (cowPos3 - cowPos2) == 2) {
            return 1;
        }
        return 2;
    }

    private static int getMaxMoves(int cowPos1, int cowPos2, int cowPos3) {
        return Math.max(cowPos2 - cowPos1, cowPos3 - cowPos2) - 1;
    }
}
