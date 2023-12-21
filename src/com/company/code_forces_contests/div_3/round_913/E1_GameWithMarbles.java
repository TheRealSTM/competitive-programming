// package com.company.code_forces_contests.div_3.round_913;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Problem: https://codeforces.com/contest/1914/problem/E1
 *
 * Task Notes:
 * - Alice and Bob were given marbles of n different colors by their parents
 * - Alice has received a_1 marbles of color 1, ...
 * - Bob has received b_1 marbles of color 1, ...
 * - Alice and Bob are going to play a game. Alice starts the game.
 * - A player chooses i such that both players have at least one marble of color i
 * - The player then discards one marble of color i and their opponent discards all marbles of color i
 * - The game ends when there is no such color i where both players have at least one marble of color i
 * - Score at the end is the difference in number of marbles remaining (A - B)
 * - Calculate the score if both players play optimally
 *
 * Input Notes:
 * -
 *
 * Output Notes:
 * -
 *
 * Solution Notes:
 * -
 *
 * Outcome:
 * -
 */
public class E1_GameWithMarbles {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[]a = new int[n];
            int[]b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            for (int j= 0; j < n; j++) {
                b[j] = scanner.nextInt();
            }
            PriorityQueue<Move> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.score));
            for (int j = 0; j < n; j++) {
                pq.offer(new Move(j, -(a[j] + b[j])));
            }
            int optimalScore = 0;
            for (int j = 0; j < n; j++) {
                Move nextMove = pq.poll();
                if (j % 2 == 0) {
                    a[nextMove.pos] -= 1;
                    b[nextMove.pos] = 0;
                } else {
                    b[nextMove.pos] -= 1;
                    a[nextMove.pos] = 0;
                }
            }
            System.out.println(sumArray(a) - sumArray(b));
        }
    }

    private static long sumArray(int[] array) {
        long sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }
}

class Move {
    int pos;
    int score;

    public Move(int pos, int score) {
        this.pos = pos;
        this.score = score;
    }
}
