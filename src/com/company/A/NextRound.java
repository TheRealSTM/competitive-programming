package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/158/problem/A
public class NextRound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numParticipants = scanner.nextInt(), kthPlace = scanner.nextInt();
        int[] scores = new int[numParticipants + 1];
        int currentScore = 0;
        for (int i = 0; i < kthPlace; i++) {
            currentScore = scanner.nextInt();
            if (currentScore == 0) {
                System.out.println(i);
                return;
            }
        }
        int scoreAfterK;
        for (int i = kthPlace; i < numParticipants; i++) {
            scoreAfterK = scanner.nextInt();
            if (scoreAfterK != currentScore) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(numParticipants);
    }
}
