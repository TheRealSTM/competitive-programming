package com.company.usaco.bronze.simulation.TeamTicTacToe;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=831
 *
 * Task Notes:
 * - FJ has 26 cows (each cow has a name starting with different letter of alphabet) (A ... Z)
 * - Cows created a multiplayer version of tic-tac-toe on a 3 x 3 board. Each square gets a
 *   single char from A to Z to indicate which cow claimed the square.
 * - Normal ways to win apply. However, cows can form teams to make it easier to win given larger
 *   number of players (teams of 2).
 * - Determine how many individuals or two-cow teams can claim victory (same square may be used
 *   multiple times)
 *
 * Input Notes:
 * - 3 x 3 grid
 *
 * Output Notes:
 * - # of individual winners
 * - # of team winners
 *
 * Solution Notes:
 * - Check for single winners and double winners. Used a set to check for double winners (must be size 2).
 * - Use additional sets to keep track of combinations (single and double that have already won).
 * - An optimization would be to remove singleWinners/teamWinners and just use the sets to keep track of the counts
 *
 * Outcome:
 * -
 */
public class TeamTicTacToe {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TeamTicTacToe\\tttt.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TeamTicTacToe\\tttt.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        String[] board = new String[3];
        board[0] = scanner.nextLine();
        board[1] = scanner.nextLine();
        board[2] = scanner.nextLine();

        int singleWinners = 0, teamWinners = 0;
        Set<Character> singleWinnersSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                singleWinners += singleWinnersSet.contains(board[i].charAt(0)) ? 0 : 1;
                singleWinnersSet.add(board[i].charAt(0));
            }
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                singleWinners += singleWinnersSet.contains(board[0].charAt(i)) ? 0 : 1;
                singleWinnersSet.add(board[i].charAt(0));
            }
        }
        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            singleWinners += singleWinnersSet.contains(board[0].charAt(0)) ? 0 : 1;
            singleWinnersSet.add(board[0].charAt(0));
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            singleWinners += singleWinnersSet.contains(board[2].charAt(0)) ? 0 : 1;
            singleWinnersSet.add(board[2].charAt(0));
        }

        Set<String> doubleWinnersSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            Set<Character> letSet = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                letSet.add(board[i].charAt(j));
            }
            if (letSet.size() == 2) {
                String potentialWinnerPair = createWinnerPair(letSet);
                teamWinners += doubleWinnersSet.contains(potentialWinnerPair) ? 0 : 1;
                doubleWinnersSet.add(potentialWinnerPair);
            }
        }
        for (int i = 0; i < 3; i++) {
            Set<Character> letSet = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                letSet.add(board[j].charAt(i));
            }
            if (letSet.size() == 2) {
                String potentialWinnerPair = createWinnerPair(letSet);
                teamWinners += doubleWinnersSet.contains(potentialWinnerPair) ? 0 : 1;
                doubleWinnersSet.add(potentialWinnerPair);
            }
        }
        Set<Character> letSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            letSet.add(board[i].charAt(i));
        }
        if (letSet.size() == 2) {
            String potentialWinnerPair = createWinnerPair(letSet);
            teamWinners += doubleWinnersSet.contains(potentialWinnerPair) ? 0 : 1;
            doubleWinnersSet.add(potentialWinnerPair);
        }
        letSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            letSet.add(board[i].charAt(2 - i));
        }
        if (letSet.size() == 2) {
            String potentialWinnerPair = createWinnerPair(letSet);
            teamWinners += doubleWinnersSet.contains(potentialWinnerPair) ? 0 : 1;
            doubleWinnersSet.add(potentialWinnerPair);
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(singleWinners);
            pw.println(teamWinners);
        }
    }

    private static String createWinnerPair(Set<Character> letSet) {
        if (letSet.size() != 2) {
            throw new InvalidParameterException("Set doesn't contain 2 chars");
        }
        List<Character> list = new ArrayList<>(letSet);
        Collections.sort(list);
        return list.get(0).toString() + list.get(1).toString();
    }
}
