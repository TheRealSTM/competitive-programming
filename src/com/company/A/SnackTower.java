package com.company.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/767/A
public class SnackTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSnacks = scanner.nextInt();
        boolean[] snackSizes = new boolean[numSnacks + 1];
        int nextSnackToPrint = numSnacks;
        List<String> output = new ArrayList<>();
        for (int i = 0; i < numSnacks; i++) {
            int nextSnackRead = scanner.nextInt();
            snackSizes[nextSnackRead] = true;
            if (nextSnackRead != nextSnackToPrint) {
                output.add("");
            } else {
                List<String> currentRow = new ArrayList<>();
                while (snackSizes[nextSnackToPrint]) {
                    currentRow.add("" + nextSnackToPrint--);
                }
                output.add(String.join(" ", currentRow));
            }
        }
        for (String row: output) {
            System.out.println(row);
        }
    }
}
