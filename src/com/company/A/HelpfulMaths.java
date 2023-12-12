package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/339/problem/A
public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initialString = scanner.nextLine();
        int[] numCount = new int[3];
        for (char let: initialString.toCharArray()) {
            if (let >= '1' && let <= '3') {
                numCount[let - '1']++;
            }
        }
        String output = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < numCount[i]; j++) {
                if (output.length() != 0) {
                    output += "+";
                }
                output += (i + 1);
            }
        }
        System.out.println(output);
    }
}
