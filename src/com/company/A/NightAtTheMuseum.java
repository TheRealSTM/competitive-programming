package com.company.A;

import java.util.Scanner;

public class NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exhibitName = scanner.nextLine();
        int rotations = 0;
        char currLet = 'a';
        for (char let: exhibitName.toCharArray()) {
            int nextRound = Math.min(Math.abs(currLet - let), Math.min(Math.abs(currLet - 'a') + Math.abs(let - 'z') + 1,
                    Math.abs(currLet - 'z') + Math.abs(let - 'a') + 1));
            rotations += nextRound;
            currLet = let;
        }
        System.out.println(rotations);
    }
}
