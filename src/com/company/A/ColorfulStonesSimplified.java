package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/265/problem/A
public class ColorfulStonesSimplified {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stones = scanner.nextLine(), instructions = scanner.nextLine();
        int stonePos = 0, instructPos = 0;
        while (stonePos < stones.length() && instructPos < instructions.length()) {
            if (stones.charAt(stonePos) == instructions.charAt(instructPos)) {
                stonePos++;
            }
            instructPos++;
        }
        System.out.println(stonePos + 1);
    }
}
