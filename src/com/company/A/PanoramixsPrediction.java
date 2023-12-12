package com.company.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://codeforces.com/contest/80/problem/A
public class PanoramixsPrediction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<Integer> primeNumbers = new ArrayList<>(Arrays.asList(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
        int nPos = primeNumbers.indexOf(n);
        if (nPos < primeNumbers.size() - 1 && m == primeNumbers.get(nPos + 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
