package com.company.A;

import java.util.Scanner;

public class BuyAShovel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coinCost = scanner.nextInt();
        int totalCost = coinCost;
        int change = scanner.nextInt();
        int rounds = 1;
        while ((totalCost % 10 != 0) && ((totalCost - change) % 10 != 0)) {
            totalCost += coinCost;
            rounds++;
        }
        System.out.println(rounds);
    }
}
