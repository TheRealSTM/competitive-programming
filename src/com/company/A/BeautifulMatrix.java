package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/263/problem/A
public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingI = 0, startingJ = 0;
        int currentNum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                currentNum = scanner.nextInt();
                if (currentNum == 1) {
                    startingI = i;
                    startingJ = j;
                    break;
                }
            }
        }
        int numMoves = Math.abs(startingI - 2) + Math.abs(startingJ - 2);
        System.out.println(numMoves);
    }
}
