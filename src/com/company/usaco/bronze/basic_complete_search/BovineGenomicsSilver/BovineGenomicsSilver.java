package com.company.usaco.bronze.basic_complete_search.BovineGenomicsSilver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=739
 *
 * Task Notes:
 * - FJ owns N cows with spots and N cows without spots. Spots are caused by the cows' genome
 * - FJ thinks that the characteristic can be explained by 3 distinct positions
 * - Determine the number of sets of 3 distinct positions that can explain spottiness
 *
 * Solution Notes:
 * - Keep track of all 3 letter sequences for a given cow using a set.
 * - Compare the spotted and nonspotted cow sets. If they are disjoint, then we have a tuple of positions
 *   that could be an indicator of spottiness.
 *
 * Outcome:
 * -
 */
public class BovineGenomicsSilver {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\BovineGenomicsSilver\\cownomics.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\BovineGenomicsSilver\\cownomics.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        String[] spottedGenomes = new String[n];
        String[] nonspottedGenomes = new String[n];
        for (int i = 0; i < n; i++) {
            spottedGenomes[i] = reader.readLine();
        }
        for (int i = 0; i < n; i++) {
            nonspottedGenomes[i] = reader.readLine();
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    HashSet<String> spottedSeq = new HashSet<>();
                    for (int a = 0; a < n; a++) {
                        spottedSeq.add("" + spottedGenomes[a].charAt(i) + + spottedGenomes[a].charAt(j) + spottedGenomes[a].charAt(k));
                    }
                    HashSet<String> nonspottedSeq = new HashSet<>();
                    for (int a = 0; a < n; a++) {
                        nonspottedSeq.add("" + nonspottedGenomes[a].charAt(i) + + nonspottedGenomes[a].charAt(j) + nonspottedGenomes[a].charAt(k));
                    }
                    if (Collections.disjoint(spottedSeq, nonspottedSeq)) {
                        count++;
                    }
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(count);
        }
    }
}
