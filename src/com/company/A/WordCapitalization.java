package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/281/problem/A
public class WordCapitalization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] word = scanner.nextLine().toCharArray();
        if (word[0] < 65 || word[0] > 90) {
            word[0] -= 32;
        }
        System.out.println(word);
    }
}
