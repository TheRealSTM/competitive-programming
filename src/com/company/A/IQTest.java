package com.company.A;

import java.util.Scanner;

public class IQTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] image = new String[4];
        for (int i = 0; i < 4; i++) {
            image[i] = scanner.nextLine();
        }
        boolean possibleToCreate2by2 = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nw = image[i].charAt(j) == '#' ? 1 : 0;
                int ne = image[i].charAt(j + 1) == '#' ? 1 : 0;
                int sw = image[i + 1].charAt(j) == '#' ? 1 : 0;
                int se = image[i + 1].charAt(j + 1) == '#' ? 1 : 0;
                if (nw + ne + sw + se >= 3) {
                    possibleToCreate2by2 = true;
                }
                nw = image[i].charAt(j) == '.' ? 1 : 0;
                ne = image[i].charAt(j + 1) == '.' ? 1 : 0;
                sw = image[i + 1].charAt(j) == '.' ? 1 : 0;
                se = image[i + 1].charAt(j + 1) == '.' ? 1 : 0;
                if (nw + ne + sw + se >= 3) {
                    possibleToCreate2by2 = true;
                }
            }
        }
        System.out.println(possibleToCreate2by2 ? "YES" : "NO");
    }
}
