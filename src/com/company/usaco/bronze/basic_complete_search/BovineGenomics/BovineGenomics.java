// package com.company.usaco.bronze.basic_complete_search.BovineGenomics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=736
 *
 * Task Notes:
 * - FJ owns N cows with spots and N cows without spots
 * - Spots are caused by a single location in genome
 * - Each genome is length M built from (A, C, G, T)
 * - Output the number of locations that could could explain spottiness
 * - First N cows are spotty and next N are plain cows
 *
 * Solution Notes:
 * - Compare the cows at each genome location
 * - Check for scenarios where there is no overlap between the spotty cows and non-spotted cows
 * - Use a set. Add the spotted cows in one set and add the non-spotted cows in a different set.
 *    - Copy the set using Set<Character> tempSet = new Set<Character>(oldSet)
 *    - I couldn't get the retainAll approach to work so I used Collections.disjoint(..., ...);
 * Outcome:
 * - All test cases passed
 *
 */
public class BovineGenomics {
    static String inputFileName = "cownomics.in";
    static String outputFileName = "cownomics.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        StringTokenizer lineTokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(lineTokenizer.nextToken());
        int m = Integer.parseInt(lineTokenizer.nextToken());
        String[] spottedGenomes = new String[n];
        String[] nonSpottedGenomes = new String[n];
        int possibilities = 0;
        for (int i = 0; i < n; i++) {
            spottedGenomes[i] = reader.readLine();
        }
        for (int i = 0; i < n; i++) {
            nonSpottedGenomes[i] = reader.readLine();
        }
        for (int i = 0; i < m; i++) {
            Set<Character> spotted = new HashSet<>();
            Set<Character> nonSpotted = new HashSet<>();
            for (int j = 0; j < n; j++) {
                spotted.add(spottedGenomes[j].charAt(i));
            }
            for (int j = 0; j < n; j++) {
                nonSpotted.add(nonSpottedGenomes[j].charAt(i));
            }
            if (Collections.disjoint(spotted, nonSpotted)) {
                possibilities++;
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(possibilities);
        }
    }
}
