package com.company.B.Implementation;
import java.util.Scanner;

// https://codeforces.com/contest/102/problem/B
public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringNum = scanner.nextLine();
        int cnt = 0;
        if (stringNum.length() == 1) {
            System.out.println(0);
            return;
        }
        while (true) {
            int currNum = 0;
            for (char num: stringNum.toCharArray()) {
                currNum += (num - '0');
            }
            cnt++;
            if (currNum >= 10) {
                stringNum = Integer.toString(currNum);
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}
