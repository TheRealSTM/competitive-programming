package com.company.A;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/contest/768/problem/A
public class OathOfTheNightsWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numWatchmen = scanner.nextInt();
        int[] watchmenStrengths = new int[numWatchmen];
        for (int i = 0; i < numWatchmen; i++) {
            watchmenStrengths[i] = scanner.nextInt();
        }
        Arrays.sort(watchmenStrengths);
        int minStrength = watchmenStrengths[0];
        int maxStrength = watchmenStrengths[numWatchmen - 1];
        int count = 0;
        for (int i = 1; i < numWatchmen - 1; i++) {
            if (watchmenStrengths[i] > minStrength && watchmenStrengths[i] < maxStrength) {
                count++;
            }
        }
        System.out.println(count);
    }
}
