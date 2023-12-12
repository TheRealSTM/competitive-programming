package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/766/problem/A
public class MahmoudAndLongestUncommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.nextLine(), secondString = scanner.nextLine();
        int uncommonLen = firstString.equals(secondString) ? -1 : Math.max(firstString.length(), secondString.length());
        System.out.println(uncommonLen);
    }
}
