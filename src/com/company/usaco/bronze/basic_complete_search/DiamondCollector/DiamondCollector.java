package com.company.usaco.bronze.basic_complete_search.DiamondCollector;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=639
 *
 * Notes:
 * - Bess has collected N diamonds (N <= 1000)
 * - Arrange some to display in the barn
 * - Diamonds cannot be more than K difference in size (Only <= K)
 * - Task: Given K, determine the max number of diamonds
 *
 * - There's an O(N^2) solution where you cycle through all the diamonds and count how many diamonds are within
 *   + or - K from that diamonds
 * - One likely can speed up the solution by keeping track of the number of diamonds below a certain threshold
 *   - Keep track of the numbers greater than or equal to sum number
 *   - Use an array between that's up to 10000
 *
 */
public class DiamondCollector {
    private static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\DiamondCollector\\diamond.in";
    private static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\basic_complete_search\\DiamondCollector\\diamond.out";


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] diamonds = new int[N];
        for (int i = 0; i < N; i++) {
            diamonds[i] = scanner.nextInt();
        }
        int maxDiamonds = 0;
        for (int i = 0; i < N; i++) {
            int currentDiamonds = 0;
            for (int j = 0; j < N; j++) {
                if (diamonds[j] >= (diamonds[i] - K) && diamonds[j] <= diamonds[i] + K) {
                    currentDiamonds += 1;
                }
            }
            maxDiamonds = Math.max(maxDiamonds, currentDiamonds);
        }
        PrintWriter pw = new PrintWriter(outputFileName);
        pw.println(maxDiamonds);
        pw.close();
    }
}
