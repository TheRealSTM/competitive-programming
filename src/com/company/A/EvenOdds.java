package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/318/problem/A
public class EvenOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long upperBound = scanner.nextLong();
        long pos = scanner.nextLong();
        if ((upperBound % 2 == 0 && pos <= (upperBound / 2))
            || (upperBound % 2 != 0 && pos <= (upperBound / 2) + 1)){
            System.out.println(2 * (pos - 1) + 1);
        } else if (upperBound % 2 == 0) {
            System.out.println(2 * (pos - (upperBound / 2)));
        } else {
            System.out.println(2 * (pos - (upperBound / 2) - 1));
        }
    }
}
