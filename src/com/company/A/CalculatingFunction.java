package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/486/problem/A
public class CalculatingFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long upperLimit = scanner.nextLong();
        long alternatingSum = 0;
        if (upperLimit % 2 == 0) {
            alternatingSum = upperLimit / 2;
        } else {
            alternatingSum = ((upperLimit + 1) / 2) * -1;
        }
        System.out.println(alternatingSum);
    }
}
