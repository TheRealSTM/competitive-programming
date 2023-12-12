package com.company.A;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://codeforces.com/contest/707/problem/A
public class BrainsPhoto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> coloredPixels = new HashSet<>(Arrays.asList("C", "M", "Y"));
        int i_dim = scanner.nextInt(), j_dim = scanner.nextInt();
        boolean colored = false;
        for (int i = 0; i < i_dim; i++) {
            for (int j = 0; j < j_dim; j++) {
                String nextLet = scanner.next();
                if (coloredPixels.contains(nextLet)) {
                    colored = true;
                }
            }
        }
        if (colored) {
            System.out.println("#Color");
        } else {
            System.out.println("#Black&White");
        }
    }
}
