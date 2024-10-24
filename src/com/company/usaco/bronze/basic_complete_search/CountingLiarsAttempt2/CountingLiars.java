package com.company.usaco.bronze.basic_complete_search.CountingLiarsAttempt2;

import java.util.Scanner;

/**
 * Problem: https://usaco.org/index.php?page=viewproblem2&cpid=1228
 *
 * Task Notes:
 * - Bessie is hiding on the number line. Each of FJ's N other cows (1 <= N <= 1000) have
 *   a piece of info to share.
 * - ith cow says that Bessie is hiding at some location less than or equal to p_i or
 *   some location greater than or equal to p_i
 * - Count number of cows that must be lying.
 *
 * Input Notes:
 * - First line has N
 * - Next line contains L or G along w/ p_i
 *
 * Output Notes:
 * - Min number of cows that must be lying
 *
 * Solution Notes:
 * Approach 1
 * - We can keep track of a range, then update it based on what the cows say
 * - If a cow conflicts with the given range, then there is a liar.
 * - The above won't work because it won't give the min number of conflicts
 *
 * Approach 2:
 * - Treat one point as being the location where Bessie is then compare all other directions to see if the conflict
 * - This will guarantee that we find the minimum number of conflicts
 *
 * Outcome:
 * - Approach 2 worked successfully on first try.
 */
public class CountingLiars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Guess[] guesses = new Guess[n];
        for (int i = 0; i < n; i++) {
            String[] guessInputs = scanner.nextLine().split(" ");
            guesses[i] = new Guess(guessInputs[0], Integer.parseInt(guessInputs[1]));
        }
        int minConflicts = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Guess reference = guesses[i];
            int conflicts = 0;
            for (int j = 0; j < n; j++) {
                if (("G".equals(guesses[j].direction) && guesses[j].position > reference.position) ||
                        ("L".equals(guesses[j].direction) && guesses[j].position < reference.position)) {
                    conflicts++;
                }
            }
            minConflicts = Math.min(minConflicts, conflicts);
        }
        System.out.println(minConflicts);
    }
}

class Guess {
    public int position;
    public String direction;

    public Guess(String dir, int pos) {
        position = pos;
        direction = dir;
    }
}