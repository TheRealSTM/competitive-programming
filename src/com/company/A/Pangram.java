package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/520/problem/A
public class Pangram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String inputString = scanner.nextLine().toLowerCase();

        boolean[] lettersFound = new boolean[26];
        for (char let: inputString.toCharArray()) {
            lettersFound[let - 'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!lettersFound[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
