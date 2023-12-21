// package com.company.code_forces_contests.div_3.round_913;


import java.io.IOException;
import java.util.*;

/**
 * Problem: https://codeforces.com/contest/1914/problem/D
 *
 * Task Notes:
 * - Winter holidays are going to last for n days
 * - Monocarp wants to try the following activities exactly once:
 *   1. Skiing, 2. Watching movie, 3. Playing board games
 * - On the ith day, exactly a_i friends will go skiing, b_i will go to movie, and c_i friends
 *   will play a board game
 * - Monocarp can only do one activity per day
 * - Task: Choose 3 distinct days (x, y, z) in order to maximize the number of friends
 *
 * Input Notes:
 * - t = # of test cases
 * - n = # of days in the holiday
 * - a_i, b_i, c_i are the next thre rows
 *
 * Output Notes:
 * - Output the max # of friends that can join him
 *
 * Solution Notes:
 * - Sort the numbers and consider all options of the final 3
 *
 * Outcome:
 * - Accepted
 */
public class D_ThreeActivities {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Activity[] skiing = new Activity[n];
            Activity[] movie = new Activity[n];
            Activity[] boardGame = new Activity[n];
            for (int j = 0; j < n; j++) {
                skiing[j] = new Activity(j, scanner.nextInt());
            }
            for (int j = 0; j < n; j++) {
                movie[j] = new Activity(j, scanner.nextInt());
            }
            for (int j = 0; j < n; j++) {
                boardGame[j] = new Activity(j, scanner.nextInt());
            }
            Arrays.sort(skiing, Comparator.comparingInt(a -> a.numPeople));
            Arrays.sort(movie, Comparator.comparingInt(a -> a.numPeople));
            Arrays.sort(boardGame, Comparator.comparingInt(a -> a.numPeople));
            int totalPeople = 0;
            for (int x = n - 3; x < n; x++) {
                for (int y = n - 3; y < n; y++) {
                    for (int z = n - 3; z < n; z++) {
                        int peopleAmount = 0;
                        Set<Integer> days = new HashSet<>();
                        days.add(skiing[x].day);
                        peopleAmount += skiing[x].numPeople;
                        days.add(movie[y].day);
                        peopleAmount += movie[y].numPeople;
                        days.add(boardGame[z].day);
                        peopleAmount += boardGame[z].numPeople;
                        if (days.size() == 3) {
                            totalPeople = Math.max(totalPeople, peopleAmount);
                        }
                    }
                }
            }
            System.out.println(totalPeople);
        }
    }
}

class Activity {
    int day;
    int numPeople;

    Activity(int day, int numPeople) {
        this.day = day;
        this.numPeople = numPeople;
    }
}
