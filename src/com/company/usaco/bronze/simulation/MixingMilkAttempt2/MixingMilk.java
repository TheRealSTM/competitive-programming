package com.company.usaco.bronze.simulation.MixingMilkAttempt2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=855
 *
 * Task Notes (4 minutes):
 * - there are 3 dairy cows (Bessie, Elsie, & Mildred) that produce different tasting milk.
 * - He plans to mix the different milks.
 * - He mixes the milk using 3 different buckets from each cow (buckets can be different sizes &
 *   not full). He pours from bucket 1 -> 2 to bucket 2 -> 3 to bucket 3 -> 1 and back around for
 *   a total of 100 pours.
 * - He pours as much as possible until the bucket is empty or the receiving bucket is full.
 * - Determine how much milk will be in each bucket after 100 pours.
 *
 * Input Notes:
 * - 3 rows (capacity of bucket i and amount in bucket i)
 *
 * Output Notes:
 * - Output the milk in each row
 *
 * Solution Notes:
 * - Create a class Bucket (capacity and currentAmount)
 * - Execute the operations according to the rules
 *
 * Outcome:
 * -
 */
public class MixingMilk {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\MixingMilkAttempt2\\mixmilk.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\MixingMilkAttempt2\\mixmilk.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(inputFileName));
        Bucket[] buckets = new Bucket[3];
        for (int i = 0; i < 3; i++) {
            buckets[i] = new Bucket(scanner.nextInt(), scanner.nextInt());
        }

        for (int i = 0; i < 100; i++) {
            int source = i % 3;
            int destination = (i + 1) % 3;
            int change = Math.min(buckets[source].capacity, buckets[destination].capacity - buckets[destination].amount);
            buckets[destination].amount += change;
            buckets[source].amount -= change;
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(buckets[0].amount);
            pw.println(buckets[1].amount);
            pw.println(buckets[2].amount);
        }
    }
}

class Bucket {
    public int capacity;
    public int amount;

    public Bucket(int capacity, int amount) {
        this.capacity = capacity;
        this.amount = amount;
    }

}
