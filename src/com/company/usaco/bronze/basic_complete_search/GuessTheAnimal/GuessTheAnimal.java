// package com.company.usaco.bronze.basic_complete_search.GuessTheAnimal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=893
 *
 * Task Notes:
 * - Bessie and Elsie are playing a game "guess the animal"
 * - Bessie thinks of an animal
 * - Else asks a series of questions to guess the animal
 * - Given all of the animals that Bessie and Elsie know as well as their characteristics, please determine the maximum
 *   number of "yes" answers Elsie could possibly receive before she knows the right animal.
 * - We need to find the max overlap of characteristics
 *
 * Solution Notes:
 * - Keep a map of Animal name to set of characteristics
 * - Compare each animal characteristics to the characteristics of all other animals
 * - Use set operations to determine the amx overlap (use retainAll & make sure to copy the set)
 * - Don't compare the same two animals
 * - Print the max overlap + 1
 *
 * Outcome:
 * - All test cases pass
 */
public class GuessTheAnimal {
    static String inputFileName = "guess.in";
    static String outputFileName = "guess.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        Map<String, Set<String>> animalCharacteristicMap = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] parsedLine = reader.readLine().split(" ");
            Set<String> characteristics = new HashSet<>();
            for (int j = 2; j < parsedLine.length; j++) {
                characteristics.add(parsedLine[j]);
            }
            animalCharacteristicMap.put(parsedLine[0], characteristics);
        }
        int maxOverlap = 0;
        for (String a1: animalCharacteristicMap.keySet()) {
            for (String a2: animalCharacteristicMap.keySet()) {
                if (a1.equals(a2)) continue;
                Set<String> copiedSet = new HashSet<>(animalCharacteristicMap.get(a1));
                copiedSet.retainAll(animalCharacteristicMap.get(a2));
                maxOverlap = Math.max(maxOverlap, copiedSet.size());
            }

        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(maxOverlap + 1);
        }
    }
}
