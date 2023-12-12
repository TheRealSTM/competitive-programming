package com.company.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://codeforces.com/contest/490/problem/A
public class TeamOlympiad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numChildren = scanner.nextInt();
        List<Integer> progList = new ArrayList<>();
        List<Integer> mathList = new ArrayList<>();
        List<Integer> sportList = new ArrayList<>();
        for (int i = 0; i < numChildren; i++) {
            int child = scanner.nextInt();
            if (child == 1) {
                progList.add(i + 1);
            } else if (child == 2) {
                mathList.add(i + 1);
            } else {
                sportList.add(i + 1);
            }
        }
        int teams = Math.min(Math.min(progList.size(), mathList.size()), sportList.size());
        System.out.println(teams);
        for (int i = 0; i < teams; i++) {
            System.out.println(String.format("%d %d %d", progList.get(i), mathList.get(i), sportList.get(i)));
        }
    }
}
