// package com.company.usaco.bronze.simulation.BucketListAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=856
 *
 * Task Notes:
 * - FJ is changing how he allocates buckets. FJ has N cows between 1 and 100.
 * - The ith cow gets milked between s_i and t_i and requires b_i buckets to be used.
 * - Several cows may be milked at the same time & cannot use the same buckets (no sharing during the time frame).
 * - All s_i and t_i are distinct & associated with one cow.
 * - Buckets are labeled 1, 2, 3, ... FJ grabs the smallest available buckets when it's time to start milking.
 * - Determine how many buckets FJ would need to keep in his storage room to milk all cows sucessfully.
 *
 * Input Notes:
 * - N lines w/ s_i, t_i and b_i where s_i & t_i are between 1 and 1000 & b_i is between 1 and 10.
 *
 * Output Notes:
 * - Output number of buckets needed
 *
 * Solution Notes:
 * - Create a class to store the data
 * - Use number line to keep track at start time increment number line and at end time decrement number line
 * - Cycle over list incrementing & decrementing keep track of the max number
 *
 * Outcome:
 * - All test cases pass on first try.
 */
public class BucketList {
    static String inputFileName = "blist.in";
    static String outputFileName = "blist.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int numCows = Integer.parseInt(scanner.nextLine());
        int[] timeLine = new int[1001];
        for (int i = 0; i < numCows; i++) {
            int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            timeLine[inputs[0]] += inputs[2];
            timeLine[inputs[1]] -= inputs[2];
        }
        int maxBuckets = 0, currentBuckets = 0;
        for (int i = 0; i <= 1000; i++) {
            currentBuckets += timeLine[i];
            maxBuckets = Math.max(maxBuckets, currentBuckets);
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(maxBuckets);
        }
    }
}