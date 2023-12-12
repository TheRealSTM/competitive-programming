package com.company.A;

import java.math.BigInteger;
import java.util.Scanner;

// https://codeforces.com/contest/483/problem/A
public class CounterExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long lowerBound = scanner.nextLong(), upperBound = scanner.nextLong();
        long sol_i = -1, sol_j = -1, sol_k = -1;
        for (long i = lowerBound; i <= upperBound; i++) {
            for (long j = i + 1; j <= upperBound; j++) {
                for (long k = j + 1; k <= upperBound; k++) {
                    // Lookup the java api method for gcd
                    if (BigInteger.valueOf(i).gcd(BigInteger.valueOf(j)).intValue() == 1
                            && BigInteger.valueOf(j).gcd(BigInteger.valueOf(k)).intValue() == 1
                            && BigInteger.valueOf(i).gcd(BigInteger.valueOf(k)).intValue() != 1) {
                        sol_i = i;
                        sol_j = j;
                        sol_k = k;
                    }
                }
            }
        }
        if (sol_i == -1) {
            System.out.println(sol_i);
        } else {
            System.out.println(sol_i + " " + sol_j + " " + sol_k);
        }
    }
}
