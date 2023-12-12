package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/59/problem/A
public class Word {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int upperCase = 0, lowerCase = 0;
        for (char let: word.toCharArray()) {
            if (let >= 65 && let <= 90) {
                upperCase++;
            } else {
                lowerCase++;
            }
        }
        if (upperCase > lowerCase) {
            System.out.println(word.toUpperCase());
        } else {
            System.out.println(word.toLowerCase());
        }
    }
}
