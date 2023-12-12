package com.company.B.Implementation;

import java.util.Scanner;

// https://codeforces.com/contest/47/problem/B
public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pair1 = scanner.nextLine();
        String pair2 = scanner.nextLine();
        String pair3 = scanner.nextLine();
        int[][] pairings = new int[3][3];

        if (pair1.charAt(1) == '>') {
            pairings[pair1.charAt(0) - 'A'][pair1.charAt(2) - 'A'] = 1;
        } else {
            pairings[pair1.charAt(2) - 'A'][pair1.charAt(0) - 'A'] = 1;
        }
        if (pair2.charAt(1) == '>') {
            pairings[pair2.charAt(0) - 'A'][pair2.charAt(2) - 'A'] = 1;
        } else {
            pairings[pair2.charAt(2) - 'A'][pair2.charAt(0) - 'A'] = 1;
        }
        if (pair3.charAt(1) == '>') {
            pairings[pair3.charAt(0) - 'A'][pair3.charAt(2) - 'A'] = 1;
        } else {
            pairings[pair3.charAt(2) - 'A'][pair3.charAt(0) - 'A'] = 1;
        }
        char[] places = "DDD".toCharArray();
        for (int i = 0; i < 3; i++) {
            int numCompetitors = 0;
            for (int j = 0; j < 3; j++) {
                numCompetitors += pairings[i][j];
            }
            if (numCompetitors == 2) {
                places[2] = (char) (i + 65);
            } else if (numCompetitors == 1) {
                places[1] = (char) (i + 65);
            } else {
                places[0] = (char) (i + 65);
            }
        }
        if (places[0] == 'D' || places[1] == 'D' || places[2] == 'D') {
            System.out.println("Impossible");
        } else {
            System.out.println(places);
        }
    }
}
