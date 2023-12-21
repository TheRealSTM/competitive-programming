package com.company.usaco.contests.bronze.december;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem&cpid=1337
 *
 * Task Notes:
 * - FJ is grown N plants (1 <= N <= 2 * 10^5) of asparagus
 * - Some plants grow faster than others.
 * - For the ith plant, it's height is h_i inches and it grows a_i inches per day
 * - FJ wants certain plants to be taller than others. He gives an array of distinct t values
 *   t0 to t_N-1. He wants the ith plant to have t_i number of plants taller than it.
 * - Find the min # of days so that FJ's request is satisfied or is impossible
 *
 * Input Notes:
 * - T is the number of test cases
 * - For each test:
 *    - First line contains N (# of plants)
 *    - Next line consists of N integers denoting the initial of the plant in inches
 *    - 3rd line consists of N integers showing the change in grow per day
 *    - 4th line is the array
 *    - sum of all N does not exceed 2 * 10^5
 *
 * Output Notes:
 * - Output T lines with the answer or -1 if the request is impossible
 *
 * Solution Notes:
 * -
 *
 * Outcome:
 * - I only had 2 hours for the original contest and I ran out of time to submit this question. If I had the 4 hours,
 *   I would have been able to solve this one.
 */
class Plant {
    int initialHeight;
    int growthRate;
    int ordering;

    Plant(int initialHeight, int growthRate, int order) {
        this.initialHeight = initialHeight;
        this.growthRate = growthRate;
        this.ordering = order;
    }
}
public class Problem3_FarmerJohnActuallyFarms {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Plant[] plants = new Plant[n];
            int[] initialHeights = new int[n];
            int[] growthRates = new int[n];
            int[] ordering = new int[n];
            for (int j = 0; j < n; j++) {
                initialHeights[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                growthRates[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                ordering[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                plants[j] = new Plant(initialHeights[j], growthRates[j], ordering[j]);
            }
            Arrays.sort(plants, Comparator.comparingInt(p -> p.ordering));
            int minDaysAllPlants = 0;
            for (int j = 0; j < n - 1; j++) {
                int minDays = daysUntilTallerThanNeighbor(plants, j);
                if (minDays == -1) {
                    minDaysAllPlants = -1;
                    break;
                } else {
                    minDaysAllPlants = Math.max(minDays, minDaysAllPlants);
                }
            }
            pw.println(minDaysAllPlants);
        }
        pw.close();
    }

    private static int daysUntilTallerThanNeighbor(Plant[] plants, int j) {
        if (plants[j].initialHeight <= plants[j + 1].initialHeight && plants[j].growthRate <= plants[j + 1].growthRate) {
            return -1;
        }
        return ((plants[j + 1].initialHeight - plants[j].initialHeight) / (plants[j].growthRate - plants[j + 1].growthRate)) + 1;
    }
}
