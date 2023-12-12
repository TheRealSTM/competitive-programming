package com.company.A;

import java.util.Scanner;

public class SpojEasyMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        int[] res = new int[numCases];
        for (int i = 0; i < numCases; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int divisor = scanner.nextInt();
            int adder = scanner.nextInt();
            for (int num = start; num <= end; num++) {
                if (num % divisor != 0 && num % (divisor + adder) != 0 && num % (divisor + 2 * adder) != 0
                        && num % (divisor + 3 * adder) != 0 && num % (divisor + 4 * adder) != 0) {
                    res[i]++;
                }
            }
        }
        for (int i = 0; i < numCases; i++) {
            System.out.println(res[i]);
        }
    }
}
