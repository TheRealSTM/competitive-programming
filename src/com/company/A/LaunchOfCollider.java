package com.company.A;

import java.util.Scanner;

public class LaunchOfCollider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numParticles = scanner.nextInt();
        scanner.nextLine();
        String particleMovements = scanner.nextLine();
        int[] particlePositions = new int[numParticles];
        for (int i = 0; i < numParticles; i++) {
            particlePositions[i] = scanner.nextInt();
        }
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < numParticles - 1; i++) {
            if (particleMovements.charAt(i) == 'R' && particleMovements.charAt(i+1) == 'L') {
                int collisionTime = (particlePositions[i + 1] - particlePositions[i]) / 2;
                minTime = Math.min(collisionTime, minTime);
            }
        }
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }
}
