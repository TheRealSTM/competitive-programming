package com.company.A;

import java.math.BigInteger;
import java.util.Scanner;

// https://codeforces.com/contest/686/problem/A
public class FreeIceCream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVisitors = scanner.nextInt();
        BigInteger currentAmount = BigInteger.valueOf(scanner.nextInt());
        int customersDenied = 0;
        for (int i = 0; i < numVisitors; i++) {
            char type = scanner.next().charAt(0);
            BigInteger quantity = BigInteger.valueOf(scanner.nextInt());
            if (type == '+') {
                currentAmount = currentAmount.add(quantity);
            } else if (currentAmount.compareTo(quantity) < 0) {
                customersDenied++;
            } else {
                currentAmount = currentAmount.subtract(quantity);
            }
        }
        System.out.println(String.format("%d %d", currentAmount, customersDenied));
    }
}
