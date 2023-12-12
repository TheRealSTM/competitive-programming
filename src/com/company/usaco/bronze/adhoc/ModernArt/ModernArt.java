package com.company.usaco.bronze.adhoc.ModernArt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;


/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=737
 *
 * Task Notes:
 * - Painting consists of an N x N blank canvas (all positions are 0 where 0 indicates empty)
 * - Cow draws 9 rectangles one in each of the colors (1, 2, ..., 9)
 * - Task count how many of the colors still visible on canvas could have possible been painted first
 *
 *
 * Solution Notes:
 *  - Get a list of the potential options (exclude 0)
 *  - Cycle through all of the potential options
 *  - Determine the bounds by looking min/max Row and Col position values (stored in an array)
 *  - Cycle over the position values check for values that overlayed on top of the region that are
 *    not matching the target value.
 *    - Keep track of the overlayed values
 *  - Remove overlayed values from the set of potential values
 *  - Output the size of the remaining potential values.
 *
 * Outcome:
 * - 10 / 10 cases solved
 */
public class ModernArt {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\adhoc\\ModernArt\\art.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\adhoc\\ModernArt\\art.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        int[][] canvas = new int[n][n];
        Set<Integer> potentialNumbers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String row = reader.readLine();
            String[] parsedRow = row.split("");
            for (int j = 0; j < n; j++) {
                canvas[i][j] = Integer.parseInt(parsedRow[j]);
                if (canvas[i][j] != 0) {
                    potentialNumbers.add(canvas[i][j]);
                }
            }
        }
        Set<Integer> numbersToRemove = new HashSet<>();
        for (int potentialNum: potentialNumbers) {
            int[] dimensions = findDimensions(canvas,potentialNum);
            for (int i = dimensions[0]; i <= dimensions[1]; i++) {
                for (int j = dimensions[2]; j <= dimensions[3]; j++) {
                    if (canvas[i][j] != potentialNum) {
                        numbersToRemove.add(canvas[i][j]);
                    }
                }
            }
        }
        potentialNumbers.removeAll(numbersToRemove);
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(potentialNumbers.size());
        }
    }

    private static int[] findDimensions(int[][] canvas, int potentialNum) {
        int minRow = canvas.length - 1, maxRow = 0, minCol = canvas[0].length - 1, maxCol = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == potentialNum) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        return new int[]{minRow, maxRow, minCol, maxCol};
    }
}