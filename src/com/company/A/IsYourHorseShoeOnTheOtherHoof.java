package com.company.A;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsYourHorseShoeOnTheOtherHoof {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h1, h2, h3, h4;
        h1 = scanner.nextInt();
        h2 = scanner.nextInt();
        h3 = scanner.nextInt();
        h4 = scanner.nextInt();
        Set<Integer> hoofSet = new HashSet<>(Arrays.asList(h1, h2, h3, h4));
        System.out.println(4 - hoofSet.size());
    }
}
