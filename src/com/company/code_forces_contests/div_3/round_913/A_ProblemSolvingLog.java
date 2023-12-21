package com.company.code_forces_contests.div_3.round_913;

import java.io.*;

/**
 * Problem: https://codeforces.com/contest/1914/problem/A
 *
 * Task Notes:
 * - 26 problems from 'A' to 'Z' and the problems are sorted by difficulty
 * - monocarp can solve problems in 1 min, 2 min, ..., 26 min
 * -
 *
 * Input Notes:
 * -
 *
 * Output Notes:
 * -
 *
 * Solution Notes:
 * -
 *
 * Outcome:
 * - Accepted
 */
public class A_ProblemSolvingLog {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] letterCounts = new int[26];
            String session = reader.readLine();
            for (char let: session.toCharArray()) {
                letterCounts[let - 'A']++;
            }
            int problemsSolved = 0;
            for (int j = 0; j < 26;j++) {
                if (letterCounts[j] >= (j + 1)) {
                    problemsSolved++;
                }
            }
            System.out.println(problemsSolved);
        }
    }
}
