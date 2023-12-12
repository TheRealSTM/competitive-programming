package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/514/problem/A
public class ChewbaccaAndNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long initialNumber = scanner.nextLong(), reversedInvertedNumber = 0;
        if (initialNumber == 9) {
            System.out.println(initialNumber);
            return;
        }
        while (initialNumber > 0) {
            long currentPos = initialNumber % 10;
            currentPos = 9 - currentPos < currentPos ? 9 - currentPos : currentPos;
            reversedInvertedNumber = (reversedInvertedNumber * 10) + currentPos;
            initialNumber /= 10;
        }
        long finalInvertedNumber = 0;
        while (reversedInvertedNumber > 0) {
            finalInvertedNumber = (finalInvertedNumber * 10) + (reversedInvertedNumber % 10);
            reversedInvertedNumber /= 10;
        }
        System.out.println(finalInvertedNumber);
    }
}
