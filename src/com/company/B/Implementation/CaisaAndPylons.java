package com.company.B.Implementation;

import java.util.Scanner;

// https://codeforces.com/contest/463/problem/B
public class CaisaAndPylons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPylons = scanner.nextInt();
        int[] pylons = new int[numPylons + 1];
        for (int i = 1; i <= numPylons; i++) {
            pylons[i] = scanner.nextInt();
        }
        int cost = pylons[1];
        int energy = cost;
        for (int i = 1; i <= numPylons; i++) {
            energy += (pylons[i - 1] - pylons[i]);
            if (energy < 0) {
                cost += (energy * -1);
                energy = 0;
            }
        }
        System.out.println(cost);
    }
}
