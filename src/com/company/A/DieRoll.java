package com.company.A;

import java.util.Scanner;

public class DieRoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt(), w = scanner.nextInt();
        int maxNumSeen = Math.max(y, w);
        String[] probability = {"", "1/1", "5/6", "2/3", "1/2", "1/3", "1/6"};
        System.out.println(probability[maxNumSeen]);
    }
}
