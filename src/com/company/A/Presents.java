package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/136/problem/A
public class Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numFriends = scanner.nextInt();
        int[] matches = new int[numFriends];
        for (int i = 0; i < numFriends; i++) {
            int partner = scanner.nextInt();
            matches[partner - 1] = i + 1;
        }
        String output = "" + matches[0];
        for (int i = 1; i < numFriends; i++) {
            output += " " + matches[i];
        }
        System.out.print(output);
    }
}
