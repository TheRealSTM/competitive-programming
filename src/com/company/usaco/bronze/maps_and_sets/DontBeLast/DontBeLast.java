package com.company.usaco.bronze.maps_and_sets.DontBeLast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.*;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=687
 *
 * Task Notes:
 * - 7 dairy cows
 * - Milked every day and how much milk
 * - Cows don't care about milk production, but they don't want to be last
 * - Task: Determine which cow is second to last
 *
 * Solution Notes:
 * -
 *
 * Outcome:
 * - 9 / 11 testcases passed (so far)
 */
public class DontBeLast {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\maps_and_sets\\DontBeLast\\notlast.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\maps_and_sets\\DontBeLast\\notlast.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> cowQuantityMap = new HashMap<>();
        cowQuantityMap.put("Bessie", 0);
        cowQuantityMap.put("Elsie", 0);
        cowQuantityMap.put("Daisy", 0);
        cowQuantityMap.put("Gertie", 0);
        cowQuantityMap.put("Annabelle", 0);
        cowQuantityMap.put("Maggie", 0);
        cowQuantityMap.put("Henrietta", 0);
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String name = tokenizer.nextToken();
            int amount = Integer.parseInt(tokenizer.nextToken());
            cowQuantityMap.put(name, cowQuantityMap.getOrDefault(name, 0) + amount);
        }
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(cowQuantityMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());
        int minValue = sortedEntries.get(0).getValue();
        int secondValue = -1;
        String secondSmallest = "";
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (entry.getValue() != minValue) {
                secondSmallest = entry.getKey();
                secondValue = entry.getValue();
                break;
            }
        }
        int secondSmallestCount = 0;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (entry.getValue() == secondValue) {
                secondSmallestCount++;
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            String output = "".equals(secondSmallest) || secondSmallestCount > 1 ? "TIE" : secondSmallest;
            pw.println(output);
        }
    }
}
