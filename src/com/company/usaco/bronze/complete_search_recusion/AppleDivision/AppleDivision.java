package com.company.usaco.bronze.complete_search_recusion.AppleDivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: https://cses.fi/problemset/task/1623
 *
 * Task Notes:
 * - There are n apples with known weights.
 * - Task: Divide the apples into two groups so that the weights of the groups is minimal
 *
 * Input Notes:
 * The first line contains n (number of apples) and the next line contains p_i weights of each apple
 * - 1 <= n <= 20
 * - 1 <= p_i <= 10^9
 *
 * Output Notes:
 * - Output the difference
 *
 * Solution Notes:
 * - There are 2^20 possibles which works out to be about 1M options - we can search through the entire space.
 *   - Each apple can either be in group 1 or group 2
 * - We should assign an apple to a given group
 * - It's pretty natural to use a recursive approach where the base case will be the number of apples remaining being 0
 * - Initial inputs to the recursive function are position, apple weight array, group 1, group 2
 * - Store the minWeight as a class variable
 * - After an apple has been added to one group add it to the other group. This can be done by removing the last element addeded
 * - There will be two recursive calls (one call where the apple gets added to group 1 and another whether the apple gets
 *   added to group 2)
 * - Use long when computing the weights because int won't be big enough
 *
 * Outcome:
 * - All testcases pass
 */
public class AppleDivision {
    static long minDifference = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] appleWeights = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        determineMinDifference(0, appleWeights, new ArrayList<>(), new ArrayList<>());
        System.out.println(minDifference);
    }

    private static void determineMinDifference(int pos, int[] appleWeights, ArrayList<Integer> group1, ArrayList<Integer> group2) {
        if (pos == appleWeights.length) {
            minDifference = Math.min(minDifference, Math.abs(sumList(group1) - sumList(group2)));
            return;
        }
        group1.add(appleWeights[pos]);
        determineMinDifference(pos + 1, appleWeights, group1, group2);
        group1.remove(group1.size() - 1);
        group2.add(appleWeights[pos]);
        determineMinDifference(pos + 1, appleWeights, group1, group2);
        group2.remove(group2.size() - 1);
    }

    private static long sumList(List<Integer> group) {
        long sum = 0L;
        for (int num: group) {
            sum += num;
        }
        return sum;
    }
}