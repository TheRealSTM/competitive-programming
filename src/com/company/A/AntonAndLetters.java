package com.company.A;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://codeforces.com/contest/443/problem/A
public class AntonAndLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringSet = scanner.nextLine();
        Set<Character> charSet = new HashSet<>();
        for (char let: stringSet.toCharArray()) {
            if (let >= 'a' && let <= 'z') {
                charSet.add(let);
            }
        }
        System.out.println(charSet.size());
    }
}
