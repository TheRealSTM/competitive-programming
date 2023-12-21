package com.company.usaco.bronze.maps_and_sets.JuryMarks;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem: https://codeforces.com/contest/831/problem/C
 *
 * Task Notes:
 * - Polycarp watched TV show where K jury members rated a participant (1 by 1) by adding or subtracting points.
 * - We know the ith member gave a_i points
 * - Polycarp doesn't remember how many points the participant had at the start, but he remembers that among the scores
 *   announced after each of the k judges there were n <= k values (b1, b2, ..., bn) where all bs are distinct
 * - Polycarp may not remember all of the scores
 * - Task: Determine the number of options for the score the participant could have before the judges rated the participant
 *
 * Input Notes:
 * - The first line contains two integers k and n (1 <= n <= k <= 2000) - number of scores Polycarp remembers and # of judges
 * - Second line contains k integers a1, a2, ..., aK from (-2000 <= a_i <= 2000) in chronological order
 * - Third line contains n distinct integers b1, b2, ..., bN - valeus that polycarp remembers (not in chronological order)
 *
 * Output Notes:
 * - Print # of options for the score the participant could have before the judges rated the participant. If there are
 *   no options, output 0
 *
 * Solution Notes:
 * -
 *
 * Outcome:
 * -
 */
public class JuryMarks {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

    }
}
