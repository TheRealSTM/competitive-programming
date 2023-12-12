package com.company.usaco.bronze.simulation.BucketList;

import java.io.*;
import java.util.Arrays;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=856
 *
 * Notes:
 * - Keep track of the change in buckets in an array
 * - Keep track of current and max buckets used
 *
 * Result:
 * - All test cases passed.
 */
public class BucketList {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BucketList\\blist.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\BucketList\\blist.out.";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] bucketChange = new int[1001];
        for (int i = 0; i < n; i++) {
            int[] milkSchedule = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            bucketChange[milkSchedule[0]] += milkSchedule[2];
            bucketChange[milkSchedule[1]] -= milkSchedule[2];
        }
        int totalBuckets = 0, bucketsUsed = 0;
        for (int i = 1; i <= 1000; i++) {
            bucketsUsed += bucketChange[i];
            totalBuckets = Math.max(totalBuckets, bucketsUsed);
        }
        PrintWriter pw = new PrintWriter(outputFileName);
        pw.println(totalBuckets);
        pw.close();
    }
}

