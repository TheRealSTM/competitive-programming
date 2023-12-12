package com.company.code_forces_contests.div_2.round_912;

import java.util.Scanner;

/**
 * Task Notes:
 * - Theofanis needs to deliver many halloumis all over the world.
 * - He stores them in n boxes and each of which has a number a_i on it.
 * - He wants to sort them in non-decreasing order based on their number. It can only reverse any subarray
 *   boxes with length at most k
 * - Find if it's possible to sort the boxes using any number of reverses
 *
 * Input:
 * - t : number of test cases
 * - each test case consists of 2 lines:
 *   - line 1: n and k
 *   - line contains n integers
 *
 * Output:
 * - YES or NO whether it is possible or not.
 */
public class A_HalloumiBoxes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            if (isSorted(nums)) {
                System.out.println("YES");
                continue;
            }
            if (k > 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isSorted(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
