package com.company.A;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

// https://codeforces.com/contest/236/problem/A
public class BoyOrGirl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        Set<Character> charSet = userName.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        if (charSet.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
