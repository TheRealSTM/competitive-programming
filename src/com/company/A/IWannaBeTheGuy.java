package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/469/problem/A
public class IWannaBeTheGuy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalLevels = scanner.nextInt();
        int littleXLevels = scanner.nextInt();
        boolean[] levelsSolved = new boolean[totalLevels + 1];
        int level;
        for (int i = 0; i < littleXLevels; i++) {
            level = scanner.nextInt();
            levelsSolved[level] = true;
        }
        int littleYLevels = scanner.nextInt();
        for (int i = 0; i < littleYLevels; i++) {
            level = scanner.nextInt();
            levelsSolved[level] = true;
        }
        for (int i = 1; i <= totalLevels; i++) {
            if (!levelsSolved[i]) {
                System.out.println("Oh, my keyboard!");
                return;
            }
        }
        System.out.println("I become the guy.");
    }
}
