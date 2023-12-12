package com.company.usaco.bronze.sorting.AngryCows;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=592
 *
 * Task Notes:
 * - Bessie comes up with Angry Cows (same rules as Angry Birds)
 * - N bales are on the number line at distinct locations (x1, x2, ..., xN)
 * - Hay bales explode with a blast radius of 1, each subsequent bales blast radius
 *   increases by 1 per iteration
 * - Task: Determine the max # of hay bales that can explode if a single cow is launched
 *         onto the best possible location
 *
 * Input Notes:
 * - N is 1 <= N <= 100
 * - Xs are between 0 and 1,000,000
 *
 * Output Notes:
 * - Output the maximum # of hay bales engulfed
 *
 * Solution Notes:
 * - Sort the numbers
 * - Perform simulation on each # (we can exclude all #s that are not specified because they cannot start
 *   the sequence of explosions because they don't have the desired plasted radius)
 * - When simulating the explsion, one only needs to keep track of the leftmost/rightmost values because they will
 *   overlap with the positions closer to the initial location
 * - Time is not an issue because there are only at most 10^2 and the runtime is O(n^2) so there will be around 10^4 operations
 * - Keep track of the max
 *
 * Outcome:
 * - All test cases (10/10) pass.
 */
public class AngryCows {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\sorting\\AngryCows\\angry.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\sorting\\AngryCows\\angry.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        int[] baleLocations = new int[n];
        for (int i = 0; i < n; i++) {
            baleLocations[i] = scanner.nextInt();
        }
        Arrays.sort(baleLocations);
        int maxBales = 0;
        for (int i = 0; i < n; i++) {
            maxBales = Math.max(maxBales, simulateExplosion(baleLocations, i));
        }
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(maxBales);
        }
    }

    private static int simulateExplosion(int[] baleLocations, int i) {
        boolean continueExplosionLeft = true, continueExplosionRight = true;
        int left = i, right = i, blastRadius = 1;
        while (continueExplosionLeft || continueExplosionRight) {
            int currentBlastLocationRight = right;
            while (right < (baleLocations.length - 1) &&
                    continueExplosionRight &&
                    (baleLocations[currentBlastLocationRight] + blastRadius) >= baleLocations[right + 1]) {
                right++;
            }
            int currentBlastLocationLeft = left;
            while (left > 0 &&
                    continueExplosionLeft &&
                    baleLocations[currentBlastLocationLeft] - blastRadius <= baleLocations[left - 1]) {
                left--;
            }
            if (currentBlastLocationLeft == left) {
                continueExplosionLeft = false;
            }
            if (currentBlastLocationRight == right) {
                continueExplosionRight = false;
            }
            blastRadius++;
        }
        return right - left + 1;
    }
}

