package com.company.A;

import java.util.Scanner;

public class YaroslaveAndPermutations {
    public static void main(String[] args) {
        int[] nums = new int[1001];
        int maxCnt = 0;
        Scanner scanner = new Scanner(System.in);
        int numCnt = scanner.nextInt();
        for (int i = 0; i < numCnt; i++) {
            int nextNum = scanner.nextInt();
            nums[nextNum]++;
            if (nums[nextNum] > maxCnt) {
                maxCnt = nums[nextNum];
            }
        }
        if (maxCnt > (numCnt + 1) / 2) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
