package com.company.A;

import java.util.Scanner;

public class PoloThePenguinAndSegments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSegments = scanner.nextInt(), k = scanner.nextInt();
        int covered = 0;
        for (int i = 0; i < numSegments; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt();
            covered += (r - l + 1);
        }
        int amountNeededToExtend = (k - (covered % k)) % k;
        System.out.println(amountNeededToExtend);
    }
}
