package com.company.A;

import java.util.Scanner;

/*
x = 6, y = 12
for x = 1 fits y equal to 4 or 9; (12 - 4) = 8 / 5 = 1
for x = 2 fits y equal to 3 or 8;
for x = 3 fits y equal to 2, 7 or 12;
for x = 4 fits y equal to 1, 6 or 11;
for x = 5 fits y equal to 5 or 10;
for x = 6 fits y equal to 4 or 9.

 */
// https://codeforces.com/contest/682/problem/A
public class AlyonaAndNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        long numberOfPairs = 0;
        for (int i = 1; i <= n; i++) {
            int remainder = 5 - i % 5;
            if (remainder > m) {
                continue;
            }
            // Check how many times a number that divides evening into 5 appears excluding the first number
            int newPairsFound = remainder != 0 ? ((m - remainder) / 5) + 1 : m / remainder;
            numberOfPairs += newPairsFound;
        }
        System.out.println(numberOfPairs);
    }
}
