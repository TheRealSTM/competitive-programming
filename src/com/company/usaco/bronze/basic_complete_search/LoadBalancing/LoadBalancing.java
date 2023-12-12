package com.company.usaco.bronze.basic_complete_search.LoadBalancing;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=617
 *
 * Task Notes:
 * - Determine the smallest partition
 *
 * Input Notes:
 * - number of cows and max coordinate value
 *
 * Output Notes:
 * - output the smallest partition value
 *
 * Solution Notes:
 * - Check all potential ways of dividing the points - use the one that outputs the smallest partition
 * - created dividing line by take + 1 the relevant coordinate.
 *    - Initially I only considered creating a dividing line based on a single point. However, the dividing
 *      lines can be generated from different points. We may use one coordinate's x and use another coordinate's y
 *      in order to determine how to draw the lines
 *
 * Outcome:
 * - All test cases pass (10/10)
 */
public class LoadBalancing {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\LoadBalancing\\balancing.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\LoadBalancing\\balancing.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        int maxSize = scanner.nextInt();
        Pair<Integer, Integer>[] coordinates = new Pair[n];
        for (int i = 0; i < n; i++) {
            coordinates[i] = new Pair<>(scanner.nextInt(), scanner.nextInt());
        }
        int minPartitionValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minPartitionValue = Math.min(minPartitionValue, calculatePartitionValues(coordinates, coordinates[i].first + 1, coordinates[j].second + 1));
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(minPartitionValue);
        }
    }

    private static int calculatePartitionValues(Pair<Integer, Integer>[] coordinates, int dividingX, int dividingY) {
        int[] partititionQuantity = new int[4];
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].first < dividingX && coordinates[i].second < dividingY) {
                partititionQuantity[0]++;
            } else if (coordinates[i].first > dividingX && coordinates[i].second < dividingY) {
                partititionQuantity[1]++;
            } else if (coordinates[i].first < dividingX && coordinates[i].second > dividingY) {
                partititionQuantity[2]++;
            } else {
                partititionQuantity[3]++;
            }
        }
        return Arrays.stream(partititionQuantity).max().getAsInt();
    }
}

class Pair<S, T> {
    S first;
    T second;

    public Pair(S firstValue, T secondValue) {
        first = firstValue;
        second = secondValue;
    }
}
