// package com.company.usaco.bronze.simulation.MilkMeasurement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=761
 *
 * Task Notes:
 * - FJ has 3 cows and each produce 7 gallons of milk per day to start
 * - Output can change over time. FJ measures at most 1 cow per day over 100 days
 * - Entries are not in chronological order
 * - Determine the number of days where the top cow order changes
 *
 * Input Notes:
 * - N is the number of measurement
 * - Form: 7 Mildred +3
 *
 * Output Notes:
 * - Output # of days that FJ needs to change the top spot
 *
 * Solution Notes:
 * - Create a class to store the data
 * - Sort the inputs by the day
 * - Keep a running total of each cows milk production and their most recent output
 * - Check if the top spot changed
 *
 * Outcome:
 * - All test cases pass (10 / 10) - I found the phrasing in this question to be kind confusing, but I ultimately was able
 *   to get the right solution. The implementation is a little different than I would have done if I was solving the
 *   question as intended the first time.
 */
public class MilkMeasurement {
    static String inputFileName = "measurement.in";
    static String outputFileName = "measurement.out";

    public static void main(String[] args) throws IOException {
        String[] cowNames = new String[]{"Bessie", "Elsie", "Mildred"};
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        int[] days = new int [n];
        Map<Integer, Measurement> dayMeasurementMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int day = Integer.parseInt(tokenizer.nextToken());
            String name = tokenizer.nextToken();
            String relativeChangeString = tokenizer.nextToken();
            int relativeChange =  Integer.parseInt(relativeChangeString.substring(1));
            if (relativeChangeString.charAt(0) == '-') {
                relativeChange = (-1) * Integer.parseInt(relativeChangeString.substring(1));
            }
            days[i] = day;
            dayMeasurementMap.put(day, new Measurement(name, day, relativeChange));
        }
        Arrays.sort(days);

        Map<String, Integer> cowCurrentRate = new HashMap<>();
        for (String name : cowNames) {
            cowCurrentRate.put(name, 7);
        }

        Set<String> currentLeaders = new HashSet<>(Arrays.asList(cowNames));
        int leaderBoardChange = 0;
        for (int i : days) {
            if (dayMeasurementMap.containsKey(i)) {
                Measurement measurement = dayMeasurementMap.get(i);
                cowCurrentRate.put(measurement.name, cowCurrentRate.get(measurement.name) + measurement.relativeChange);
            }
            int leaderQuantity = 0;
            for (String name: cowNames) {
                leaderQuantity = Math.max(leaderQuantity, cowCurrentRate.get(name));
            }
            Set<String> newLeaders = new HashSet<>();
            for (String name: cowNames) {
                if (cowCurrentRate.get(name) == leaderQuantity) {
                    newLeaders.add(name);
                }
            }
            if (!newLeaders.equals(currentLeaders)) {
                leaderBoardChange += 1;
            }
            currentLeaders = newLeaders;
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(leaderBoardChange);
        }
    }
}

class Measurement {
    String name;
    int day;
    int relativeChange;

    Measurement(String name, int day, int relativeChange) {
        this.name = name;
        this.day = day;
        this.relativeChange = relativeChange;
    }
}
