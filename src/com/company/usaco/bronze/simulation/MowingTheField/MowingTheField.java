package com.company.usaco.bronze.simulation.MowingTheField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=593
 *
 * Task Notes:
 * - Farm is a large 2D grid of square unit cells
 * - FJ starts at one cell at t = 0
 * - Mowing sequence is described by N statements
 *   - W 10 --> mows next 10 units in next 10 units of time in the west direction
 * - Grass may grow back before he's done - grass re-appears at t + x
 * - He will revisit certain cells multiple times, but the grass is never already cut (every time a cell
 *   is revisited, it must have grown back)
 * - Determine the max possible value of x
 *
 * Solution Notes:
 * - Use a map to create keep track of points visited at what time
 * - Keep track of the minX
 * - Output minX if it's not equal to MAX_INT, otherwise output -1
 *
 * Outcome:
 * -
 */
class Step {
    public char direction;
    public int magnitude;

    public Step(char direction, int magnitude) {
        this.direction = direction;
        this.magnitude = magnitude;
    }
}

public class MowingTheField {
    static String inputFileName = "mowing.in";
    static String outputFileName = "mowing.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        Step[] steps = new Step[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            char dir = tokenizer.nextToken().charAt(0);
            int magnitude = Integer.parseInt(tokenizer.nextToken());
            steps[i] = new Step(dir, magnitude);
        }
        Map<List<Integer>, Integer> coordinateTimeMap = new HashMap<>();
        int currX = 0, currY = 0, time = 0, minX = Integer.MAX_VALUE;
        for (Step step : steps) {
            int dx, dy;
            if (step.direction == 'W') {
                dx = -1;
                dy = 0;
            } else if (step.direction == 'E') {
                dx = 1;
                dy = 0;
            } else if (step.direction == 'N') {
                dx = 0;
                dy = 1;
            } else {
                dx = 0;
                dy = -1;
            }
            for (int i = 0; i < step.magnitude; i++) {
                currX += dx;
                currY += dy;
                time++;
                if (coordinateTimeMap.containsKey(List.of(currX, currY))) {
                    minX = Math.min(minX, time - coordinateTimeMap.get(List.of(currX, currY)));
                }
                coordinateTimeMap.put(List.of(currX, currY), time);
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(minX == Integer.MAX_VALUE ? -1 : minX);
        }
    }
}
