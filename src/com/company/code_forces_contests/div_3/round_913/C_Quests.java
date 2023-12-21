// package com.company.code_forces_contests.div_3.round_913;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem: https://codeforces.com/contest/1914/problem/C
 *
 * Task Notes:
 * - Monocarp is playing a computer game. There are n quests from 1 to n
 * - Monocarp can complete quests in the following way:
 *   - The 1st quest can always be completed
 *   - The ith quest can be completed if all earlier quests have been completed
 * - Same quest can be completed multiple times
 * - Player gets experience points for completing quests. They are calculated in the following way:
 *   - The 1st completion gets a_i points
 *   - For each subsequent completion, the player gets b_i points.
 * - Monocarp can complete no more than k quests. Your task is to calculate the max possible total experience
 *   Monocarp can get if he completes no more than k quests.
 *
 * Input Notes:
 * - The number of test cases is t (1 <= t <= 10^4)
 * - The first line of each test case is n and k where 1 <= n, k <= 2 * 10^5
 * - The next line is n integers corresponding to a_i
 * - The next line is n integers corresponding to b_i
 *
 * Output Notes:
 * - Maximum # of experience points
 *
 * Solution Notes:
 * -
 *
 * Outcome:
 * - Accepted
 */
public class C_Quests {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] b = new int[n];
            int[] sums = new int[n];
            for (int j = 0; j < n; j++) {
                int nextA = scanner.nextInt();
                if (j > 0) {
                    sums[j] = sums[j - 1] + nextA;
                } else {
                    sums[0] = nextA;
                }
            }
            for (int j = 0; j < n; j++) {
                int nextB = scanner.nextInt();
                if (j > 0) {
                    b[j] = Math.max(b[j - 1], nextB);
                } else {
                    b[0] = nextB;
                }
            }
            int maxValue = 0;
            for (int j = Math.min(n - 1, k - 1); j >= 0; j--) {
                int potentialValue = sums[j] + (k - j - 1) * b[j];
                maxValue = Math.max(potentialValue, maxValue);
            }
            System.out.println(maxValue);
        }
    }
}

