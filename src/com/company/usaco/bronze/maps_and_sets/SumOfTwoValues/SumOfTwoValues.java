// package com.company.usaco.bronze.maps_and_sets.SumOfTwoValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Problem: https://cses.fi/problemset/task/1640
 *
 * Task Notes:
 * - Given an array of n integers, your task is to find to values who sum is x.
 *
 * Input Notes:
 * - The first line has two inters n and x
 * - The next line is n integers
 *
 * Output Notes:
 * - Print the two position of the two numbers or "IMPOSSIBLE" if no such solution exists
 *
 * Solution Notes:
 * - This is two sum.
 * - I'll use the hashmap approach to solve in O(n) time. Store a map of previous values that one has seen
 *   and it's location
 * - I needed to use BufferedReader due to the time constraints and size of input
 *
 * Outcome:
 * - All testcases pass.
 */
public class SumOfTwoValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(firstLine);
        int n = Integer.parseInt(tokenizer.nextToken());
        int target = Integer.parseInt(tokenizer.nextToken());
        Map<Integer, Integer> numberLocationMap = new HashMap<>();
        int[] nums = new int[n];
        String nextLine = reader.readLine();
        tokenizer = new StringTokenizer(nextLine);
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int neededNum = target - nums[i];
            if (numberLocationMap.containsKey(neededNum)) {
                System.out.println((numberLocationMap.get(neededNum) + 1)+ " " + (i + 1));
                return;
            } else {
                numberLocationMap.put(nums[i], i);
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
