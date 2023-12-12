package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/365/problem/A
public class GoodNumber {
    private static boolean allTrue(boolean[] boolArray) {
        for (int i = 0; i < boolArray.length; i++) {
            if (!boolArray[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numIntegers = scanner.nextInt(), kthGoodDigit = scanner.nextInt();
        int numGoodDigits = 0;
        boolean[] goodDigits = new boolean[kthGoodDigit + 1];
        String stringNum;
        for (int i = 0; i < numIntegers; i++) {
            int nextNum = scanner.nextInt();
            stringNum = "" + nextNum;
            while (stringNum.length() >= 1) {
                int currDigit = nextNum % 10;
                nextNum /= 10;
                if (currDigit <= kthGoodDigit) {
                    goodDigits[currDigit] = true;
                }
                stringNum = "" + nextNum;
                System.out.println(stringNum);
                if (stringNum == "0") {
                    break;
                }
            }
            if (allTrue(goodDigits)) {
                numGoodDigits++;
            }
        }
        System.out.println(numGoodDigits);
    }
}
