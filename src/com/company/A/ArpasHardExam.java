package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/742/problem/A
/*
    1378^0 = 1
    1378^1 = 1378
    1378^2 = 1898884
    1378^3 = 2616662152
    1378^4 = 3605760445456
    1378^5 = 4968737893838368
    1378^6 = ?
    1378^7 = ?
    1378^8 = ?

    power mod 4:
    1 -> 8
    2 -> 4
    3 -> 2
    0 -> 6
 */
public class ArpasHardExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int power = scanner.nextInt();
        if (power == 0) {
            System.out.println(1);
            return;
        }
        if (power % 4 == 1) {
            System.out.println(8);
        } else if (power % 4 == 2) {
            System.out.println(4);
        } else if (power % 4 == 3) {
            System.out.println(2);
        } else {
            System.out.println(6);
        }
    }
}
