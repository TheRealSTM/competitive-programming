package com.company.A;

import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1, string2;
        string1 = scanner.nextLine().toLowerCase();
        string2 = scanner.nextLine().toLowerCase();
        int stringLength = string1.length();
        for (int i = 0; i < stringLength; i++) {
            if (string1.charAt(i) < string2.charAt(i)) {
                System.out.println("-1");
                return;
            } else if (string1.charAt(i) > string2.charAt(i)) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
}
