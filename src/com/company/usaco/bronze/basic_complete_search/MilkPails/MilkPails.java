// package com.company.usaco.bronze.basic_complete_search.MilkPails;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=615
 *
 * Notes:
 * - M unit os of milk where 1 <= M <= 1000
 * - Three pails X, Y, M where X < Y < M.
 * - All three pails are empty
 * - Types of operations:
 *    1. Smallest pail can be filled to the top of X units of milk and pour into the M-sized pail (as long as no overflow)
 *    2. Fill the Y sized pail and dump into M (as long as no overflow)
 *  - Determine the max amount of milk that he can add
 *
 *  Thoughts:
 *  - One option is to consider every possible combination of X, Y
 *  - Another option is to use a DP based approach where you have an array up to the max number of 1000 and keep track of every
 *    number that you can reach.
 *  - When you find a number that you can reach, you add X and Y to it and find new numbers that you can reach.
 *
 *  Outcome:
 *  - Satisfied all tests cases
 */
public class MilkPails {
    private static String inputFileName = "pails.in";
    private static String outputFileName = "pails.out";


    public static void main(String[] args) throws IOException {
        boolean[] possibleNums = new boolean[1000];
        Scanner scanner = new Scanner(new File(inputFileName));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int maxNum = 0;
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(x);
        arrayList.add(y);
        int i = 0;
        while (i < arrayList.size()) {
            int nextNum = arrayList.get(i++);
            maxNum = Math.max(maxNum, nextNum);
            if (!possibleNums[nextNum]) {
                if (nextNum + x <= m) {
                    arrayList.add(nextNum + x);
                }
                if (nextNum + y <= m) {
                    arrayList.add(nextNum + y);
                }
            }
            possibleNums[nextNum] = true;
        }
        PrintWriter pw = new PrintWriter(outputFileName);
        pw.println(maxNum);
        pw.close();
    }
}
