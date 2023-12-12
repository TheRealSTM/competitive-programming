package com.company.B.Constructive;

import java.util.Scanner;

// https://codeforces.com/contest/78/my
public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numEggs = scanner.nextInt();
        char[] outputColors = new char[numEggs];
        outputColors[numEggs - 1] = 'V';
        outputColors[numEggs - 2] = 'I';
        outputColors[numEggs - 3] = 'B';
        for (int i = 0; i < (numEggs - 3); i++) {
            if (i % 4 == 0) {
                outputColors[i] = 'R';
            } else if (i % 4 == 1) {
                outputColors[i] = 'O';
            } else if (i % 4 == 2) {
                outputColors[i] = 'Y';
            } else {
                outputColors[i] = 'G';
            }
        }
        System.out.println(outputColors);
    }
}
