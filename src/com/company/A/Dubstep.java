package com.company.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://codeforces.com/contest/208/problem/A
public class Dubstep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dubbedSong = scanner.nextLine();
        String[] splitSong = dubbedSong.split("(WUB)+");
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < splitSong.length; i++) {
            if (splitSong[i] != " ") {
                resList.add(splitSong[i]);
            }
        }
        System.out.println(String.join(" ", resList).strip());
    }
}
