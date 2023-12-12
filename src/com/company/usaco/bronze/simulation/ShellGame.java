package com.company.usaco.bronze.simulation;

import java.io.*;
import java.util.Scanner;

/**
 * Problem link: http://www.usaco.org/index.php?page=viewproblem2&cpid=891
 *
 * Problem Notes:
 * - 3 inverted shells and small pebble is placed under one of them
 * - Bessie swaps the shells and Elsie tries to guess
 * - Elsie doesn't know the initial location
 * - Bessie gives Elsie a score at the end equal to the number of guesses
 * - Given the swaps and the guesses, but not the initial pebble location,
 *   please determine the highest possible score Elsie could have earned.
 *
 *  Outcome:
 *  - Correct answer for all test cases
 */
public class ShellGame {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File("shell.in"));
             PrintWriter pw = new PrintWriter("shell.out")) {
            int numberOfRounds = scanner.nextInt();
            int[][] rounds = new int[numberOfRounds][3];
            // Fill in rounds
            for (int i = 0; i < numberOfRounds; i++) {
                rounds[i][0] = scanner.nextInt() - 1;
                rounds[i][1] = scanner.nextInt() - 1;
                rounds[i][2] = scanner.nextInt() - 1;
            }
            int winsStartingFromOne = playGame(rounds, 0);
            int winsStartingFromTwo = playGame(rounds, 1);
            int winsStartingFromThree = playGame(rounds, 2);

            pw.println(Math.max(Math.max(winsStartingFromOne, winsStartingFromTwo), winsStartingFromThree));
        }
    }

    private static int playGame(int[][] rounds, int startingPos) {
        int currentPosStone = startingPos;
        int score = 0;
        for (int i = 0; i < rounds.length; i++) {
            if (currentPosStone == rounds[i][0]) {
                currentPosStone = rounds[i][1];
            } else if (currentPosStone == rounds[i][1]) {
                currentPosStone = rounds[i][0];
            }
            if (currentPosStone == rounds[i][2]) {
                score++;
            }
        }
        return score;
    }
}
