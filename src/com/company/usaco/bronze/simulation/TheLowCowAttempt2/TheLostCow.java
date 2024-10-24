package com.company.usaco.bronze.simulation.TheLowCowAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=735
 *
 * Task Notes:
 * - Farmer John lost Bessie, but Bessie must be on a straight lin path on the farm.
 * - FJ is at X and Bessie is at Y.
 * - FJ can only find her by walking back and forth until he reaches her position.
 * - The recommended approach is zig-zag back-and-forth.
 * - Compute the total distance that FJ will travel until he finds her.
 *
 * Input Notes:
 * - X and Y where they are distinct integers between 0 and 100.
 *
 * Output Notes:
 * - Output the total distance
 *
 * Solution Notes:
 * - Implement the algorithm as described but note that FJ returns to his position each time.
 *
 * Outcome:
 * - I initially got the question wrong because I didn't fully understand the algorithm, specifically that farm John
 *   returned to the original position. Once I understood this, I was able to solve the problem with all test cases
 *   passing.
 */
public class TheLostCow {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TheLowCowAttempt2\\lostcow.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\TheLowCowAttempt2\\lostcow.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int farmerJohnPosition = scanner.nextInt(), bessiePosition = scanner.nextInt();
        boolean isFound = false;
        if (farmerJohnPosition == bessiePosition) {
            isFound = true;
        }
        int totalDistance = 0, nextStep = 1;

        while (!isFound) {
            if ((farmerJohnPosition < bessiePosition && (farmerJohnPosition + nextStep) >= bessiePosition) ||
                    (farmerJohnPosition > bessiePosition && (farmerJohnPosition + nextStep) <= bessiePosition)
            ){
                totalDistance += Math.abs(bessiePosition - farmerJohnPosition);
                isFound = true;
            } else {
                totalDistance += (2 * Math.abs(nextStep));
                nextStep *= -2;
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(totalDistance);
        }
    }
}
