package com.company.usaco.bronze.maps_and_sets.CitiesAndState;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=667
 *
 * Task Notes:
 * - States are a special pair if the first two letters in the city correspond to the
 *   state of another city, and the first two letters in other city correspond to the state of the original
 *   city
 * - How many special pairs?
 *
 * Solution Notes:
 * - We only care about the first two letters in the city
 * - We can store the different city state combinations in a class
 * - We can keep a map of how many times that we have seen different pairings.
 * - We first add the desired pairing count because the current city-state pair can be paired with all of the desired
 *   combinations. If it's not present, we just add 0.
 * - Increment how many times the current city initial-state pair have been seen by 1.
 * - Return the total.
 *
 * - An initial approach worked but it used too much memory so it failed.
 *
 * Outcome:
 * - All test cases pass with the latest approach
 */
class CityStatePair {
    public String city;
    public String state;

    public CityStatePair(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
public class CitiesAndStates {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\maps_and_sets\\CitiesAndState\\citystate.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\maps_and_sets\\CitiesAndState\\citystate.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        CityStatePair[] pairs = new CityStatePair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String city = tokenizer.nextToken();
            String state = tokenizer.nextToken();
            pairs[i] = new CityStatePair(city.substring(0, 2), state);
        }

        int count = 0;
        Map<String, Integer> pairCountMap = new HashMap<>();
        for (CityStatePair pair: pairs) {
            if (!pair.city.equals(pair.state)) {
                count += pairCountMap.getOrDefault(pair.state + pair.city, 0);
            }
            pairCountMap.put(pair.city + pair.state, pairCountMap.getOrDefault(pair.city + pair.state, 0) + 1);
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(count);
        }
    }
}
