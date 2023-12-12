package com.company.usaco.bronze.maps_and_sets.WhereAmI;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=964
 *
 * Task Notes:
 * - N farms (1 <= N <= 100) in a row.
 * - Houses don't have #s but they do have colorful mailboxes.
 * - Colors are specified A to Z.
 * - Determine smallest K determine smallest K such that he can look at any K Sequence of mailboxes
 *   and he can determine the location of that sequence./
 *
 * Solution Notes:
 * - Try the smallest K and see if it results in all unique substrings
 * - If the current K doesn't, increase the length of K
 * - Keep track of the unique substrings for a given K in a set
 * - This is the optimized approach (O(n^2)) - the unoptimized approach uses O(n^3)
 *
 * Outcome:
 * - All test cases pass
 */
public class WhereAmI {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\maps_and_sets\\WhereAmI\\whereami.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\maps_and_sets\\WhereAmI\\whereami.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(reader.readLine());
        String houses = reader.readLine();
        int len;
        for (len = 1; len <= n; len++) {
            Set<String> uniqueIds = new HashSet<>();
            boolean allUnique = true;
            for (int i = 0; i <= n - len; i++) {
                String substring = houses.substring(i, i + len);
                if (uniqueIds.contains(substring)) {
                    allUnique = false;
                    break;
                } else {
                    uniqueIds.add(substring);
                }
            }
            if (allUnique) {
                break;
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(len);
        }
    }
}
