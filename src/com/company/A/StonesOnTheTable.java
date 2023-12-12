package com.company.A;

import java.util.Scanner;

public class StonesOnTheTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStones = Integer.parseInt(scanner.nextLine()), stonesToRemove = 0;
        String stones = scanner.nextLine();
        char prevStone = ' ';
        for (int i = 0; i < numStones; i++) {
            if (stones.charAt(i) == prevStone) {
                stonesToRemove++;
            } else {
                prevStone = stones.charAt(i);
            }
        }
        System.out.println(stonesToRemove);
    }
}
