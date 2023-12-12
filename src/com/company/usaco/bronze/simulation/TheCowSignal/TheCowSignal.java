package com.company.usaco.bronze.simulation.TheCowSignal;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=665
 *
 * Thoughts:
 * -  M x N paper where 1 <= M <= 10, 1 <= N <= 10
 * - She wants to increase the size by K where 1 <= K <= 10
 *
 * Outcome:
 * - Passed all cases
 */
public class TheCowSignal {
    private static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TheCowSignal\\cowsignal.in";
    private static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TheCowSignal\\cowsignal.out";


    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter pw = new PrintWriter(outputFileName)) {
            int rowDim = scanner.nextInt();
            int colDim = scanner.nextInt();
            int factor = scanner.nextInt();
            scanner.nextLine();


            char[][] initialArray = new char[rowDim][colDim];
            char[][] expandedArray = new char[rowDim * factor][colDim * factor];
            for (int i = 0; i < rowDim; i++) {
                initialArray[i] = scanner.nextLine().toCharArray();
            }
            for (int i = 0; i < initialArray.length; i++) {
                // expand horizontally
                for (int j = 0; j < initialArray[i].length; j++) {
                    for (int k = 0; k < factor; k++) {
                        expandedArray[i * factor][(j * factor) + k] = initialArray[i][j];
                    }
                }
                // expand vertically
                for (int j = 1; j < factor; j++) {
                    expandedArray[i * factor + j] = expandedArray[i * factor].clone();
                }
            }
            for (char[] array: expandedArray) {
                pw.println(new String(array));
            }
        }

    }
}
