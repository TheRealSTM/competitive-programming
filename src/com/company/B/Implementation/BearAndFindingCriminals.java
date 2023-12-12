package com.company.B.Implementation;

import java.util.Scanner;

public class BearAndFindingCriminals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCities = scanner.nextInt(), startPos = scanner.nextInt() - 1;
        int[] cityCriminals = new int[numCities];
        for (int i = 0; i < numCities; i++) {
            cityCriminals[i] = scanner.nextInt();
        }
        int cnt = 0, distance = 0;
        while (startPos + distance < numCities || startPos - distance > -1) {
            int right = startPos + distance, left = startPos - distance;
            if (right < numCities && left > -1) {
                if (cityCriminals[left] == 1 && cityCriminals[right] == 1) {
                    cnt += (left != right ? 2 : 1);
                }
            } else if (right < numCities && cityCriminals[right] == 1) {
                cnt++;
            } else if (left > -1 && cityCriminals[left] == 1) {
                cnt++;
            }
            distance++;
        }
        System.out.println(cnt);
    }
}
