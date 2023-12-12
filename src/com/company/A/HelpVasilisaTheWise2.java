package com.company.A;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HelpVasilisaTheWise2 {
    // coordinates:
    // i1 i2
    // j1 j2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r1 = scanner.nextInt(), r2 = scanner.nextInt();
        int c1 = scanner.nextInt(), c2 = scanner.nextInt();
        int d1 = scanner.nextInt(), d2 = scanner.nextInt();
        int resI1 = -1, resI2 = -1, resJ1 = -1, resJ2 = -1;
        for (int i1 = 1; i1 <= 9; i1++) {
            for (int i2 = 1; i2 <= 9; i2++) {
                for (int j1 = 1; j1 <= 9; j1++) {
                    for (int j2 = 1; j2 <= 9; j2++) {
                        Set<Integer> numSet = new HashSet<>(Arrays.asList(i1, i2, j1 , j2));
                        if (numSet.size() == 4) {
                            int r1Sum = i1 + i2;
                            int r2Sum = j1 + j2;
                            int c1Sum = i1 + j1;
                            int c2Sum = i2 + j2;
                            int d1Sum = i1 + j2;
                            int d2Sum = j1 + i2;
                            if (r1Sum == r1 && r2Sum == r2 && c1Sum == c1 && c2Sum == c2 && d1Sum == d1 && d2Sum == d2) {
                                resI1 = i1;
                                resI2 = i2;
                                resJ1 = j1;
                                resJ2 = j2;
                            }
                        }
                    }
                }
            }
        }
        if (resI1 != -1) {
            System.out.println(resI1 + " " + resI2);
            System.out.println(resJ1 + " " + resJ2);
        } else {
            System.out.println(-1);
        }
    }
}
