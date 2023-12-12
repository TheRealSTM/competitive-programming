package com.company.A;

import java.util.Scanner;

public class PoliceRecruits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numEvents = Integer.parseInt(scanner.nextLine()), event;
        int policeCount = 0, unsolvedCrimes = 0;
        for (int i = 0; i < numEvents; i++) {
            event = scanner.nextInt();
            if (event > 0) {
                policeCount += event;
            } else {
                if (policeCount > 0) {
                    policeCount--;
                } else {
                    unsolvedCrimes++;
                }
            }
        }
        System.out.println(unsolvedCrimes);
    }
}
