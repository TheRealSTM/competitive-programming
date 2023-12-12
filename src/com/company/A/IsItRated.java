package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/807/problem/A
public class IsItRated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numParticipants = scanner.nextInt();
        int priorRating = scanner.nextInt();
        int updatedRating = scanner.nextInt();
        boolean outOfOrder = false;
        boolean rated = false;
        if (priorRating != updatedRating) {
            rated = true;
        }
        int prevRating = priorRating;
        for (int i = 0; i < (numParticipants - 1); i++) {
            priorRating = scanner.nextInt();
            updatedRating = scanner.nextInt();
            if (priorRating != updatedRating) {
                rated = true;
            }
            if (updatedRating > prevRating) {
                outOfOrder = true;
            }
            prevRating = updatedRating;
        }
        if (rated) {
            System.out.println("rated");
        } else if (outOfOrder) {
            System.out.println("unrated");
        } else {
            System.out.println("maybe");
        }
    }
}
