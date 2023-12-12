package com.company.B.Strings;

import java.util.Scanner;

// https://codeforces.com/contest/746/problem/B
public class Decoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLet = scanner.nextInt();
        scanner.nextLine();
        String decodedString = scanner.nextLine();
        char[] initialString = new char[numLet];
        int medianPos = numLet % 2 != 0 ? numLet / 2 : (numLet - 1) / 2;
        int sign = numLet % 2 != 0 ? 1 : -1;
        for (int i = 0; i < numLet; i++) {
            int shift = (i + 1) / 2;
            initialString[medianPos + (shift * sign)] = decodedString.charAt(i);
            sign *= -1;
        }
        System.out.println(initialString);
    }
}
