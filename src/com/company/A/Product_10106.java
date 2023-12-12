package com.company.A;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product_10106 {
    public static void main(String[] args) {
        List<BigInteger> inputPairs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numPairs = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < 2*numPairs; i++) {
            String nextNum = scanner.nextLine();
            inputPairs.add(new BigInteger(nextNum));
        }
        for (int i = 0; i < 2 * numPairs; i+= 2) {
            System.out.println(inputPairs.get(i).multiply(inputPairs.get(i + 1)));
        }

    }
}
