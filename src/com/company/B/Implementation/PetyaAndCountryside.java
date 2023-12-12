package com.company.B.Implementation;

import java.util.Scanner;

public class PetyaAndCountryside {
    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeYard = scanner.nextInt();
        int[] yard = new int[sizeYard];
        for (int i = 0; i < sizeYard; i++) {
            yard[i] = scanner.nextInt();
        }
        int maxFlow = -1;
        for (int i = 0; i < sizeYard; i++) {
            int left = i, right = i;
            while (left > 0 && yard[left] >= yard[left - 1]) {
                left--;
            }
            while (right < sizeYard - 1 && yard[right] >= yard[right + 1]) {
                right++;
            }
            maxFlow = Math.max(maxFlow, right - left + 1);
        }
        System.out.println(maxFlow);
    }
}
