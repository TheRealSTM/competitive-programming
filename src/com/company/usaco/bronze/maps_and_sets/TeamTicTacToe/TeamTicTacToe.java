// package com.company.usaco.bronze.maps_and_sets.TeamTicTacToe;

import java.io.*;
import java.util.*;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=831
 *
 * Task Notes:
 * - FJ has 26 cows (w/ name starting with different letters from 'A' .. 'Z'
 * - They play a version of tik tak toe that allows for more players
 * - Cows can form teams of 2 to increase likelihood of winning
 *
 *
 * Solution Notes:
 * - Create two cases 1 case for checking single and one for double
 * - Single is the normal way
 * - Double check that there's exactly two letters in a given row
 *
 * Outcome:
 * - 7 / 10 test cases pass - the official approach is better than what I have
 */
public class TeamTicTacToe {
    static String inputFileName = "tttt.in";
    static String outputFileName = "tttt.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            board[i] = reader.readLine().toCharArray();
        }
        int singleVictories = checkSingleVictories(board);
        int doubleVictories = checkDoubleVictories(board);
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(singleVictories);
            pw.println(doubleVictories);
        }
    }

    private static int checkDoubleVictories(char[][] board) {
        int wins = 0;
        List<Set<Character>> winningPairs = new ArrayList<>();
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            Set<Character> potentialSet = new HashSet<>(Arrays.asList(board[i][0], board[i][1], board[i][2]));
            if (letterCount(board[i][0], board[i][1], board[i][2]) == 2 && !winningPairs.contains(potentialSet)) {
                winningPairs.add(potentialSet);
                wins++;
            }
            potentialSet = new HashSet<>(Arrays.asList(board[0][i], board[1][i], board[2][i]));
            if (letterCount(board[0][i], board[1][i], board[2][i]) == 2 && !winningPairs.contains(potentialSet)) {
                winningPairs.add(potentialSet);
                wins++;
            }
        }
        // Check upper-left to bottom-right
        Set<Character> potentialSet = new HashSet<>(Arrays.asList(board[0][0], board[1][1], board[2][2]));
        if (letterCount(board[0][0], board[1][1], board[2][2]) == 2 && !winningPairs.contains(potentialSet)) {
            winningPairs.add(potentialSet);
            wins++;
        }
        // Check bottom-left to top-right
        potentialSet = new HashSet<>(Arrays.asList(board[2][0], board[1][1], board[0][2]));
        if (letterCount(board[2][0], board[1][1], board[0][2]) == 2 && !winningPairs.contains(potentialSet)) {
            winningPairs.add(potentialSet);
            wins++;
        }
        return wins;
    }

    private static int letterCount(char c, char c1, char c2) {
        int[] letters = new int[26];
        letters[c - 'A']++;
        letters[c1 - 'A']++;
        letters[c2 - 'A']++;
        int diffLetters = 0;
        for (int i = 0; i < 26; i++) {
            if (letters[i] > 0) {
                diffLetters++;
            }
        }
        return  diffLetters;
    }

    private static int checkSingleVictories(char[][] board) {
        int wins = 0;
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                wins++;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                wins++;
            }
        }
        // Check upper-left to bottom-right
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            wins++;
        }
        // Check bottom-left to top-right
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            wins++;
        }
        return wins;
    }
}
