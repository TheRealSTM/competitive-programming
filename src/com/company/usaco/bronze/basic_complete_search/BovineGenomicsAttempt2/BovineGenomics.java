package com.company.usaco.bronze.basic_complete_search.BovineGenomicsAttempt;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=736
 *
 * Task Notes:
 * - FJ owns N cows with spots and N cows without spots. He is convinced that spots come from a single location in
 *   bovine genome.
 * - FJ sequences all cows genomes. Each genome is M characters w/ A/G/T/C.
 * - If a gene/genes show up in only the spotted cows, it is a potential cause of spottedness.
 * - Output the number of potential locations.
 *
 * Input Notes:
 * - First line contains N and M along w/ N lines for the spotted genome and N lines for the non-spotted genome.
 *
 * Output Notes:
 * - Number of locations.
 *
 * Solution Notes:
 * - Create a set for spotted and create set for non-spotted at a single location.
 * - If no intersection, increment count.
 *
 * Outcome:
 * - All test cases pass on the first try.
 */
public class BovineGenomics {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\BovineGenomicsAttempt2\\cownomics.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\BovineGenomicsAttempt2\\cownomics.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        String[] spottedGenome = new String[n];
        String[] nonspottedGenome = new String[n];
        for (int i = 0; i < n; i++) {
            spottedGenome[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            nonspottedGenome[i] = scanner.nextLine();
        }
        int relevantLocations = 0;
        for (int i = 0; i < m; i++) {
            Set<Character> spottedGeneSet = new HashSet<>();
            Set<Character> nonspottedGeneSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                spottedGeneSet.add(spottedGenome[j].charAt(i));
                nonspottedGeneSet.add(nonspottedGenome[j].charAt(i));
            }
            if (Collections.disjoint(spottedGeneSet, nonspottedGeneSet)) {
                relevantLocations++;
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(relevantLocations);
        }
    }
}
