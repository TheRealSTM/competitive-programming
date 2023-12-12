// package com.company.usaco.bronze.sorting.DistinctNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Source: https://cses.fi/problemset/task/1621
 */
public class DistinctNumbers {
    public static void main(String[] args) throws IOException  {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int numElements = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] elements = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            elements[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(elements);
        int uniqueElements = 1;
        for (int i = 1; i < numElements; i++) {
            if (elements[i] != elements[i - 1]) {
                uniqueElements++;
            }
        }
        System.out.println(uniqueElements);
    }
}
