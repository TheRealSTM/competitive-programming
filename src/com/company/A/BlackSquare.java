package com.company.A;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlackSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> numToCalorieMap = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            numToCalorieMap.put((char) (i + 48), scanner.nextInt());
        }
        scanner.nextLine();
        String sequence = scanner.nextLine();
        int count = 0;
        for (char let: sequence.toCharArray()) {
            count += numToCalorieMap.get(let);
        }
        System.out.println(count);
    }
}
