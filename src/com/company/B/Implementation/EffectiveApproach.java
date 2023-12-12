package com.company.B.Implementation;

import java.util.Scanner;

public class EffectiveApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSize = scanner.nextInt();
        int[] numPositionMap = new int[numSize + 1];
        for (int i = 1; i <= numSize; i++) {
            int number = scanner.nextInt();
            numPositionMap[number] = i;
        }
        // Vasya (iterate starting at 1), Petya (iterate starting at n)
        long vasyaQueryCount = 0, petyaQueryCount = 0;
        int queryCount = scanner.nextInt();
        for (int i = 0; i < queryCount; i++) {
            int query = scanner.nextInt();
            vasyaQueryCount += (numPositionMap[query] - 1 + 1);
            petyaQueryCount += (numSize - numPositionMap[query] + 1);
        }
        System.out.println(vasyaQueryCount + " " + petyaQueryCount);
    }
}
