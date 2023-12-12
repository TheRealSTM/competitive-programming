package com.company.usaco.bronze.adhoc.TamingTheHeard;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=809
 *
 * Task Notes:
 * - FJ nails # of days since last breakout on wall (0 indicates breakout that day)
 * - Some of the log entries are missing
 * - Task: Determine the min and max # of breakouts over the logged time
 *
 * Solution Notes:
 * - Keep a rolling count of min and max days since breakout
 * - Should we start processing from the beginning or the end?
 * - It seems like we need to start from the front in order to build from [1, 1]
 * - An option would be start from the back and assume the max [n, n] and gradually subtract
 *   from each position
 * - In order to handle the errant scenario, I can't skip days. I need to check if they don't match
 *   the expected value.
 *
 * Outcome:
 * - 9 / 10 pass. I didn't handle the scenario where the logs are invalid.
 */
public class TamingTheHeard {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\adhoc\\TamingTheHeard\\taming.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\adhoc\\TamingTheHeard\\taming.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        int n = scanner.nextInt();
        int[] daysSinceBreakout = new int[n];
        for (int i = 0; i < n; i++) {
            daysSinceBreakout[i] = scanner.nextInt();
        }
        if (daysSinceBreakout[0] > 0) {
            try (PrintWriter pw = new PrintWriter(outputFileName)) {
                pw.println(-1);
                return;
            }
        }
        daysSinceBreakout[0] = 0;
        int minDays = n, maxDays = n;
        for (int i = n - 1; i >= 0;) {
            if (daysSinceBreakout[i] == 0) {
                --i;
            } else if (daysSinceBreakout[i] == -1) {
                minDays--;
                --i;
            } else {
                minDays -= daysSinceBreakout[i];
                maxDays -= daysSinceBreakout[i];
                i -= (daysSinceBreakout[i] + 1);
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(minDays + " " + maxDays);
        }
    }
}
