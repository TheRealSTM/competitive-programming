package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/1/problem/A
public class TheatricalSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), a = scanner.nextInt();
        long squaresColumns = n / a + (n % a != 0 ? 1 : 0);
        long squaresRows = m / a + (m % a != 0 ? 1 : 0);
        System.out.println(squaresColumns * squaresRows);
    }
}
