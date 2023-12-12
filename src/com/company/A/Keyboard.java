package com.company.A;

import java.util.Scanner;

// https://codeforces.com/contest/474/problem/A
/*
    Keyboard:
        qwertyuiop
        asdfghjkl;
        zxcvbnm,./

    input: R
           s;;upimrrfod;pbr
 */

public class Keyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String row1 = "qwertyuiop", row2 = "asdfghjkl;", row3 = "zxcvbnm,./";
        String direction = scanner.nextLine();
        int shift = direction == "R" ? 1 : -1;
        String message = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        for (char let: message.toCharArray()) {
            int pos1 = row1.indexOf(let+ "");
            int pos2 = row2.indexOf(let + "");
            int pos3 = row3.indexOf(let + "");
            if (pos1 >= 0) {
                output.append(row1.charAt(pos1 + shift));
            } else if (pos2 >= 0) {
                output.append(row2.charAt(pos2 + shift));
            } else {
                output.append(row3.charAt(pos3 + shift));
            }
        }
        System.out.println(output.toString());
    }
}
