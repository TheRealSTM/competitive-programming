package com.company.A;

import java.util.Scanner;

public class ShaassAndOskols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numWires = scanner.nextInt();
        int[] birdsOnWires = new int[numWires];
        for (int i = 0; i < numWires; i++) {
            birdsOnWires[i] = scanner.nextInt();
        }
        int numShots = scanner.nextInt();
        for (int i = 0; i < numShots; i++) {
            int wire = scanner.nextInt() - 1, bird = scanner.nextInt();
            int leftBirds = bird - 1, rightBirds = birdsOnWires[wire] - bird;
            if (wire > 0) {
                birdsOnWires[wire - 1] += leftBirds;
            }
            if (wire < numWires - 1) {
                birdsOnWires[wire + 1] += rightBirds;
            }
            birdsOnWires[wire] = 0;
        }
        for (int i = 0; i < numWires; i++) {
            System.out.println(birdsOnWires[i]);
        }
    }
}
