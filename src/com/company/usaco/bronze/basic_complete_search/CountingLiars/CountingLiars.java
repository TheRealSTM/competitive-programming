// package com.company.usaco.bronze.basic_complete_search.CountingLiars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=759
 *
 * Task Notes:
 * - Bessie is hiding along the number line.
 * - Each of the N other cows (1 <= N <= 1000) have additional info.
 *    - Greater or less than some location p_i
 * - Not all cows are telling the truth
 * - Task: Count how many cows are lying (output minimum cows that could be lying)
 *
 * Solution Notes:
 * Approach 1:
 * - Keep track of possible range
 * - Cycle through all the cows and only update if the suggestion tightens the range
 *    - If a cow falls outside of the range, then count them as a liar.
 *  - Keep track of min liars and current number of liars
 *  - Solution is O(n^2(
 *
 * Approach 2:
 * - Similar to approach 1, but it is not about finding left and right bounds
 * - It's about finding the point that minimizes the number of conflicts with other points.
 * - We consider all points as being the reference point and we compare it to each of the
 *   other points.
 * - If the point falls outside of the bounds, then we have found a liar.
 * - Reference point is less than a greater than point or if the reference point is greater than
 *   a less than point.
 *
 * Outcome Notes:
 * - Approach 1 got to around half of test cases passing
 */
public class CountingLiars {
    static class Statement {
        char direction;
        int position;

        public Statement(char c, int pos) {
            position = pos;
            direction = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Statement[] statements = new Statement[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            statements[i] = new Statement(tokens.nextToken().charAt(0),
                    Integer.parseInt(tokens.nextToken()));
        }
        int minLiars = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int reference = statements[i].position;
            int currentLiars = 0;
            for (int j = 0; j < n; j++) {
                if (statements[j].direction == 'G' && reference < statements[j].position) {
                    currentLiars++;
                } else if (statements[j].direction == 'L' && reference > statements[j].position) {
                    currentLiars++;
                }
            }
            minLiars = Math.min(minLiars, currentLiars);
        }
        System.out.println(minLiars);
    }
}
