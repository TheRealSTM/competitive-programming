package com.company.usaco.bronze.simulation.CensoringAttempt2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=526
 *
 * Task Notes:
 * - FJ has take all text from magazine to create string S of length at most 10^6 characters long.
 * - He would like to remove substring T of length <= 100 characters to censor inappropriate content.
 * - He finds the first occurrence of T and deletes it. He continually deletes the first occurrence
 *   until there are no more occurrences.
 * - The deletion of one occurrence may create a new occurrence.
 *
 * Input Notes:
 * - First line contains S. Second line will contain T.
 * - All characters between a and z
 *
 * Output Notes:
 * - Output the S after all deletions
 *
 * Solution Notes:
 * - It seems like a stack would be helpful for this kind of problem. We don't actually need the stack
 * - if new string less than t, we just had the characters without checking because the most recent
 *   substring cannot be equal to t.
 * - if substring >= t, we check if the most recent t characters are equal to t. if it is, we remove
 *   from (end of string length - t - 1 to end of string).
 * - then we add the next character & perform similar check until there are no more characters to add.
 * - This makes the runtime O(n).
 *
 * Outcome:
 * - All test cases pass on the first try.
 */
public class Censoring {
    static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\CensoringAttempt2\\censor.in";
    static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\CensoringAttempt2\\censor.out";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        StringBuilder censoredStringBuilder = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (censoredStringBuilder.length() < t.length()) {
                censoredStringBuilder.append(c);
            } else {
                censoredStringBuilder.append(c);
                String finalTCharacters = censoredStringBuilder.substring(censoredStringBuilder.length() - t.length());
                if (finalTCharacters.equals(t)) {
                    censoredStringBuilder.setLength(Math.max(0, censoredStringBuilder.length() - t.length()));
                }
            }
        }

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            pw.println(censoredStringBuilder.toString());
        }
    }
}

