// package com.company.usaco.bronze.adhoc.SleepyCowSorting;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=892
 *
 * Task Notes:
 * - Sort N cows and they are currently in p1, p2, ..., pN
 * - Only the front cow facing FJ is paying attention
 *
 * Solution Notes://
 *
 * Outcome:
 * - All test cases pass
 */
public class SleepyCowSorting {
    static String inputFileName = "sleepy.in";
    static String outputFileName = "sleepy.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        List<Integer> cows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cows.add(scanner.nextInt());
        }
        int minNumMoves = 0, currentSortedPos = n - 1;
        while (currentSortedPos > 0) {
            if (cows.get(currentSortedPos - 1) < cows.get(currentSortedPos)) {
                currentSortedPos--;
            } else {
                break;
            }
        }
        while (currentSortedPos > 0) {
            int currentNum = cows.get(0);
            int newCowPlacement = -1;
            for (int i = currentSortedPos; i < cows.size(); i++) {
                if (currentNum < cows.get(i)) {
                    newCowPlacement = i;
                    break;
                }
            }
            if (newCowPlacement != -1) {
                cows.add(newCowPlacement, currentNum);
            } else {
                cows.add(cows.size(), currentNum);
            }
            cows.remove(0);
            minNumMoves++;
            currentSortedPos--;
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(minNumMoves);
        }
    }
}

