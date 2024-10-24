// package com.company.usaco.bronze.simulation.ShellGameAttempt2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem:
 *
 * Task Notes:
 * - Bessie places 3 inverted shells with a pebble underneath one of them. Bessie swaps pairs of shells & Elsie guesses.
 * - Standard version allows one to see where the pebble is initially placed.
 * - Cows play game where they don't know the initial location and they can guess after every swap.
 * - Bessie gives Elsie a score based on number of correct guesses.
 * - Given swaps and guesses, determine the highest possible score Elise could have earned.
 *
 * Input Notes:
 * - First line is number of swaps, n (max of 100). Each of the next n lines contain three numbers a b g.
 * - a and b are the shells swapped and g is the guess.
 *
 * Output Notes:
 * - Please out put max number of points that Elsie could have gotten.
 *
 * Solution Notes:
 * - Since the number of swaps is small, we can simulate the game 3 times & keep track of the highest score.
 * - Read in all of the data and store in an array.
 * - Keep track of the max score.
 * - Start by making an assumption that the pebble is under 1.
 * - Keep track of the current position. If the current position is equal to either of the values being swapped,
 *   update the current location of the pebble.
 * - Compare the guess and update current score if the guess is right.
 * - After the game is simulated given the initial assumption of the starting position, compare the current score to the
 *   max score. Update the max score if the current score is greater.
 *
 * Outcome:
 * - Attempt 1: All cases pass. Total time: 29 minutes.
 */
public class ShellGame {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("shell.in"));
        int rows = scanner.nextInt();
        int[][] storedInputs = new int[rows][3];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 3; j++) {
                storedInputs[i][j] = scanner.nextInt();
            }
        }

        int maxScore = 0;
        for (int i = 1; i <= 3; i++) {
            int currentScore = 0, currentPebblePosition = i;
            for (int j = 0; j < rows; j++) {
                if (currentPebblePosition == storedInputs[j][0]) {
                    currentPebblePosition = storedInputs[j][1];
                } else if (currentPebblePosition == storedInputs[j][1]) {
                    currentPebblePosition = storedInputs[j][0];
                }
                currentScore += (currentPebblePosition == storedInputs[j][2]) ? 1 : 0;
            }
            maxScore = Math.max(maxScore, currentScore);
        }
        try (PrintWriter pw = new PrintWriter("shell.out")) {
            pw.println(maxScore);
        }
    }
}
