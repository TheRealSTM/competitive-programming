package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/799/problem/A
public class CarrotCakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCakesNeeded = scanner.nextInt(), ovenBakeTime = scanner.nextInt(), cakesBakedPerSession = scanner.nextInt(), secondOvenConstructionTime = scanner.nextInt();
        int timeWithOneOven = 0, timeWithTwoOven = 0;
        int currentCakes = 0;
        while (currentCakes < numCakesNeeded) {
            currentCakes += cakesBakedPerSession;
            timeWithOneOven += ovenBakeTime;
        }
        currentCakes = 0;
        int timeOven1 = ovenBakeTime, timeOven2 = secondOvenConstructionTime + ovenBakeTime;
        while (currentCakes < numCakesNeeded) {
            timeWithTwoOven++;
            if (timeWithTwoOven == timeOven1) {
                currentCakes += cakesBakedPerSession;
                timeOven1 += ovenBakeTime;
            }
            if (timeWithTwoOven == timeOven2) {
                currentCakes += cakesBakedPerSession;
                timeOven2 += ovenBakeTime;
            }
        }
        String reasonable = (timeWithTwoOven < timeWithOneOven) ? "YES" : "NO";
        System.out.println(reasonable);
    }
}
