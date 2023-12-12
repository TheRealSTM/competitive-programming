package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/382/problem/A
public class KseniaAndPanScales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Need the -1 to tell the split function to include trailing empty splits if present
        String[] weights = scanner.nextLine().split("\\|", -1);
        String left = weights[0], right = weights[1];
        String freeWeights = scanner.nextLine();
        for (char let: freeWeights.toCharArray()) {
            if (left.length() <= right.length()) {
                left += let;
            } else {
                right += let;
            }
        }
        if (left.length() == right.length()) {
            System.out.println(left + "|" + right);
        } else {
            System.out.println("Impossible");
        }
    }
}
