package com.company.code_forces_contests.div_3.round_913;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Problem: https://codeforces.com/contest/1914/problem/B
 *
 * Task Notes:
 * - Monocarp plans to solve n problems
 * - The problems have increasing difficulty from 1 to n
 * - Monocarp will chose some order to solve all n problems
 * - He get's excited when he solves hard problems and he doesn't get excited when
 *   he solves the first problem in the chosen order.
 * - Monocarp wants to get excited exactly k times during a practice session. Help him
 *   chose an order
 *
 * Input Notes:
 * - t = # of test cases
 * - n and k are on the next line
 *
 * Output Notes:
 * - print distinct integers from 1 to n (any solution works)
 *
 * Solution Notes:
 * - Print the last k + 1 numbers in increasing order and print (k - 1) in decreasing order
 *
 * Outcome:
 * -
 */
public class B_PreparingForTheContest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> numOrder = new ArrayList<>();
            for (int j = (n - k); j <= n; j++) {
                numOrder.add(j);
            }
            for (int j = (n - k - 1); j > 0; j--) {
                numOrder.add(j);
            }
            String result = numOrder.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
