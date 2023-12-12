package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/71/problem/A
public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numWords = scanner.nextInt();
        scanner.nextLine();
        String[] mutatedWords = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            String word = scanner.nextLine();
            int wordLen = word.length();
            if (wordLen > 10) {
                word = String.format("%c%d%c", word.charAt(0), wordLen - 2, word.charAt(wordLen - 1));
            }
            mutatedWords[i] = word;
        }
        for (int i = 0; i < numWords; i++) {
            System.out.println(mutatedWords[i]);
        }
    }
}
