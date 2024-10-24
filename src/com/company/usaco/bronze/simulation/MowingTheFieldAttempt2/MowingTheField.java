//package com.company.usaco.bronze.simulation.MowingTheFieldAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=593
 *
 * Task Notes:
 * - FJ is bad at mowing the grass. The farm is a 2D grid of square unit cells.
 * - FJ stats in a cell at t = 0 and the mowing pattern is described in N steps.
 * - Steps are defined as "W 10" where he will mow the next 10 squares to the west over 10 units of time.
 * - Grass may re-grow while he is still cutting (t + x)
 * - FJ may revisit the same cell multiple times (but he says the gras is never already cut, so it regrew in the time).
 * - Please determine the max possible value of x such that FJ's observation is true.
 *
 * Input Notes:
 * - N where 1 <= N <= 100.
 * - Remaining N lines are in the form of "<D> <S>" where D is direction and S is number of steps.
 *
 * Output Notes:
 * -
 *
 * Solution Notes:
 * - Keep track of the locations visited and the times visited. When visit the place twice, keep track of the
 *   min time between visits.
 *
 * Outcome:
 * - After fixing a couple bugs, all test cases pass. Use Java 11
 */
public class MowingTheField {
    static String inputFileName = "mowing.in";
    static String outputFileName = "mowing.out";

    static Map<String, Pair<Integer, Integer>> DIRECTION_MAP = Map.of(
            "N", new Pair<>(-1, 0),
            "S", new Pair<>(1, 0),
            "E", new Pair<>(0, 1),
            "W", new Pair<>(0, -1)
    );

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = Integer.parseInt(scanner.nextLine());
        List<Pair<String, Integer>> directions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            directions.add(new Pair<>(tokens[0], Integer.parseInt(tokens[1])));
        }
        Map<List<Integer>, Integer> mowLocationTimeMap = new HashMap<>();
        mowLocationTimeMap.put(List.of(0, 0), 0);
        Pair<Integer, Integer> currentLocation = new Pair<>(0, 0);
        int t = 0, maxX = Integer.MAX_VALUE;
        for (Pair<String, Integer> direction: directions) {
            Pair<Integer, Integer> change = DIRECTION_MAP.get(direction.first);
            for (int i = 0; i < direction.second; i++) {
                currentLocation.first += change.first;
                currentLocation.second += change.second;
                t++;
                List<Integer> updatedLocation =List.of(currentLocation.first, currentLocation.second);
                if (mowLocationTimeMap.containsKey(updatedLocation)) {
                    maxX = Math.min(maxX, t - mowLocationTimeMap.get(updatedLocation));
                }
                mowLocationTimeMap.put(updatedLocation, t);
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            if (maxX == Integer.MAX_VALUE) {
                pw.println(-1);
            } else {
                pw.println(maxX);
            }
        }
    }
}

class Pair<S, T> {
    public S first;
    public T second;

    public Pair(S s, T t) {
        first = s;
        second = t;
    }
}

