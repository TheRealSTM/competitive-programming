package com.company.B.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem: https://codeforces.com/contest/363/problem/B
 *
 * Task Notes:
 * - Fence consists of n planks of the same width. They are placed from left to right.
 * - Each of the planks of distinct lengths.
 * - In order to get his piano into the house, he needs to remove k planks
 * - He wants to minimize the sum.
 * - Task find the minimal # of planks tht need to be removed
 *
 * Input Notes:
 * - the first line has n and k
 * - The next line has the sequence of integers.
 *
 * Output Notes:
 * - Output the first index where the min location is found.
 *
 * Solution Notes:
 * - Calculate prefix sum and find the min location - O(n) solution
 *
 * Outcome:
 * - All test cases pass
 */
public class Fence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] heights = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < n; i++) {
            heights[i] += heights[i - 1];
        }
        int minHeight = heights[k - 1];
        int minPos = 0;
        for (int i = 1; i <= (n - k); i++) {
            int currentHeightRange = heights[i + k - 1] - heights[i - 1];
            if (currentHeightRange < minHeight) {
                minHeight = currentHeightRange;
                minPos = i;
            }
        }
        System.out.println(minPos + 1);
    }
}
