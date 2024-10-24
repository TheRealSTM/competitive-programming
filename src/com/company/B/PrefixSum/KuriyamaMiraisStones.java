package com.company.B.PrefixSum;// package com.company.B.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Problem: https://codeforces.com/contest/433/problem/B
 *
 * Task Notes:
 * - Kuriyama kills monsters to get stonres. She numbers the stonre from 1 to n.The cost of the ith stone is v_i.
 * - She asks two kind of questions:
 *    1. She will tell you two numbers, l and r where 1 <= l <= r <= n. You should tell her sum from l to r of v_i
 *    2. Let u_i be the cost of the cheapest stone (if the stones were arranged in non-decreasing order).
 *  - For every question, provide the correct answer
 *
 * Input Notes:
 * - The first line is n. The next line is n integers (costs of the stones)
 * - The third line contains the number of questions, m.
 * - Each question will contain 3 ints (1 or 2) along with l and r
 *
 * Output Notes:
 * -
 *
 * Solution Notes:
 * - Question 1. indicates that a prefix sum will be useful
 * - Question 2. indicates that the costs should be ordered and use a prefix sum
 *
 * Outcome:
 * - The solution keeps timing out on test 46 - I am not sure what else I can do so I am moving on.
 */
public class KuriyamaMiraisStones {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] stonesUnsorted = new long[n + 1];
        long[] stonesSorted = new long[n + 1];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            stonesUnsorted[i] = Long.parseLong(tokenizer.nextToken());
            stonesSorted[i] = stonesUnsorted[i];
        }
        Arrays.sort(stonesSorted);
        for (int i = 1; i <= n; i++) {
            stonesUnsorted[i] += stonesUnsorted[i - 1];
            stonesSorted[i] += stonesSorted[i - 1];
        }
        int q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int question = Integer.parseInt(tokenizer.nextToken());
            int l = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            if (question == 1) {
                System.out.println(stonesUnsorted[r] - stonesUnsorted[l - 1]);
            } else {
                System.out.println(stonesSorted[r] - stonesSorted[l - 1]);
            }
        }
    }
}
