package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/567/problem/A
public class LinelandMail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPeople = scanner.nextInt();
        int[] distances = new int[numPeople];
        for (int i = 0; i < numPeople; i++) {
            distances[i] = scanner.nextInt();
        }
        int maxDist, minDist;
        for (int i = 0; i < numPeople; i++) {
            if (i == 0) {
                maxDist = Math.abs(distances[i] - distances[numPeople - 1]);
                minDist = Math.abs(distances[i] - distances[i + 1]);
            } else if (i == numPeople - 1) {
                maxDist = Math.abs(distances[i] - distances[0]);
                minDist = Math.abs(distances[i] - distances[i - 1]);
            } else {
                maxDist = Math.max(Math.abs(distances[i] - distances[0]),
                        Math.abs(distances[i] - distances[numPeople - 1]));
                minDist = Math.min(Math.abs(distances[i] - distances[i - 1]),
                        Math.abs(distances[i] - distances[i + 1]));
            }
            System.out.println(minDist + " " + maxDist);
        }
    }
}
