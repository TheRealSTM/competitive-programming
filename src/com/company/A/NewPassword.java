package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/770/problem/A
public class NewPassword {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Scanner scanner = new Scanner(System.in);
        int passwordLen = scanner.nextInt(), distinctChars = scanner.nextInt();
        String newPassword = "";
        while (newPassword.length() < passwordLen) {
            newPassword += letters[newPassword.length() % distinctChars];
        }
        System.out.println(newPassword);
    }
}
