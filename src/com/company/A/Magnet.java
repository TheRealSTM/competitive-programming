package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/344/problem/A
public class Magnet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        String arrangement = "", nextPosition;
        int numGroups = 0;
        for (int i = 0; i < numLines; i++) {
            nextPosition = scanner.nextLine();
            if (!nextPosition.equals(arrangement)) {
                numGroups++;
                arrangement = nextPosition;
            }
        }
        System.out.println(numGroups);
    }
}
