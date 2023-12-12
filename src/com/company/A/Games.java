package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/268/problem/A
public class Games {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTeams = scanner.nextInt();
        int[] homeUni = new int[numTeams];
        int[] awayUni = new int[numTeams];
        int sameUniCount = 0;
        for (int i = 0; i < numTeams; i++) {
            homeUni[i] = scanner.nextInt();
            awayUni[i] = scanner.nextInt();
            for (int j = 0; j < i; j++) {
                if (homeUni[i] == awayUni[j]) {
                    sameUniCount++;
                }
                if (awayUni[i] == homeUni[j]) {
                    sameUniCount++;
                }
            }
        }
        System.out.println(sameUniCount);
    }
}
