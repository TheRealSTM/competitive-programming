package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/709/problem/A
public class Juicer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOranges = scanner.nextInt(), juiceSizeMax = scanner.nextInt(), garbageSizeMax = scanner.nextInt();
        int quantityJuice = 0;
        int garbageDumping = 0;
        for (int i = 0; i < numOranges; i++) {
            int nextOrange = scanner.nextInt();
            if (nextOrange <= juiceSizeMax) {
                if (quantityJuice + nextOrange > garbageSizeMax) {
                    garbageDumping++;
                    quantityJuice = 0;
                } else {
                    quantityJuice += nextOrange;
                }
            }
        }
        System.out.println(garbageDumping);
    }
}
