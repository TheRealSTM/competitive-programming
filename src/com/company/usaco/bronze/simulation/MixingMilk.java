package com.company.usaco.bronze.simulation;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem link: http://www.usaco.org/index.php?page=viewproblem2&cpid=855
 *
 * Problem Notes:
 * - Mix 3 different milks with milk from each cow
 * - Buckets can be different sizes and not full
 * - He pours milk from 1 -> 2, 2 -> 3, 3 -> 1, etc. for a total of 100 pours
 * - From a -> b, he pours as much milk as possible until a is empty or b is full.
 *
 * Outcome:
 * - Passed all 10 cases
 */
public class MixingMilk {
    private static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\mixmilk.in";
    private static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\mixmilk.out";

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter pw = new PrintWriter(outputFileName)) {
            int[] bucket1 = new int[2], bucket2 = new int[2], bucket3 = new int[3];
            bucket1[0] = scanner.nextInt();
            bucket1[1] = scanner.nextInt();
            bucket2[0] = scanner.nextInt();
            bucket2[1] = scanner.nextInt();
            bucket3[0] = scanner.nextInt();
            bucket3[1] = scanner.nextInt();

            int prevAmount = 0, change = 0;
            for (int i = 0; i < 100; i++) {
                if (i % 3 == 0) {
                    prevAmount = bucket2[1];
                    bucket2[1] = Math.min((bucket2[1] + bucket1[1]), bucket2[0]);
                    change = bucket2[1] - prevAmount;
                    bucket1[1] -= change;
                } else if (i % 3 == 1) {
                    prevAmount = bucket3[1];
                    bucket3[1] = Math.min((bucket3[1] + bucket2[1]), bucket3[0]);
                    change = bucket3[1] - prevAmount;
                    bucket2[1] -= change;
                } else {
                    prevAmount = bucket1[1];
                    bucket1[1] = Math.min((bucket3[1] + bucket1[1]), bucket1[0]);
                    change = bucket1[1] - prevAmount;
                    bucket3[1] -= change;
                }
            }
            pw.println(bucket1[1]);
            pw.println(bucket2[1]);
            pw.println(bucket3[1]);
        }
    }
}
