package com.company.A;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// https://codeforces.com/contest/160/problem/A
public class Twins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCoins = scanner.nextInt();
        int totalCoinsValue = 0;
        // Need to use Integer instead of int because Arrays.sort(..., Collections.reverseOrder()) - does not work for
        // primitives
        Integer[] coins = new Integer[numCoins];
        for (int i = 0; i < numCoins; i++) {
            int coin = scanner.nextInt();
            coins[i] = coin;
            totalCoinsValue += coin;
        }
        Arrays.sort(coins, Collections.reverseOrder());
        // Even (total value is 4) --> We need > 4 / 2 = 2
        // Odd (total value is 5) --> > 5 / 2 = 2
        // Check if partial sum is greater than half
        int myCoinValue = 0, numCoinsNeeded = 0;
        for (int i = 0; i < numCoins; i++) {
            if (myCoinValue <= (totalCoinsValue / 2)) {
                numCoinsNeeded++;
                myCoinValue += coins[i];
            } else {
                break;
            }
        }
        System.out.println(numCoinsNeeded);
    }
}
