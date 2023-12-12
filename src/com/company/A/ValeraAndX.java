package com.company.A;

import java.util.Scanner;

public class ValeraAndX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = Integer.parseInt(scanner.nextLine());
        char diagonal = ' ', nonDiagonal = ' ';
        boolean isX = true;
        for (int i = 0; i < numRows; i++) {
            String row = scanner.nextLine();
            if (i == 0) {
                diagonal = row.charAt(0);
                nonDiagonal = row.charAt(1);
                if (diagonal == nonDiagonal) {
                    isX = false;
                }
            }
            for (int j = 0; j < row.length(); j++) {
                if (i == j || (j == (numRows - i - 1))) {
                    if (row.charAt(j) != diagonal) {
                        isX = false;
                    }
                } else {
                    if (row.charAt(j) != nonDiagonal) {
                        isX = false;
                    }
                }
            }
        }
        if (isX) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
