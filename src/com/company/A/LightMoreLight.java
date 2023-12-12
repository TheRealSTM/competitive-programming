package com.company.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1051
public class LightMoreLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        int nthLightbulb = scanner.nextInt();
        while (nthLightbulb != 0) {
            inputList.add(nthLightbulb);
            nthLightbulb = scanner.nextInt();
        }
        for (Integer bulbPosition : inputList) {
            double square = Math.sqrt(bulbPosition);
            if (square - Math.floor(square) == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}
