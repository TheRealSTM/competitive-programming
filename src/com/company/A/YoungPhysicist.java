package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/69/problem/A
public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numForces = scanner.nextInt();
        int totalX = 0, totalY = 0, totalZ = 0;
        for (int i = 0; i < numForces; i++) {
            int xForce = scanner.nextInt(), yForce = scanner.nextInt(), zForce = scanner.nextInt();
            totalX += xForce; totalY += yForce; zForce += zForce;
        }
        if (totalX != 0 || totalY != 0 || totalZ != 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
