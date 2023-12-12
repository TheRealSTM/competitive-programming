package com.company.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SerejaAndDima {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCards = Integer.parseInt(br.readLine());
        List<Integer> cards = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int left = 0, right = numCards - 1, turn = 0;
        int serejaScore = 0, dimaScore = 0;
        while (left <= right) {
            if (cards.get(left) > cards.get(right)) {
                if (turn % 2 == 0) {
                    serejaScore += cards.get(left++);
                } else {
                    dimaScore += cards.get(left++);
                }
            } else {
                if (turn % 2 == 0) {
                    serejaScore += cards.get(right--);
                } else {
                    dimaScore += cards.get(right--);
                }
            }
            turn = (turn + 1) % 2;
        }
        System.out.println(serejaScore + " " + dimaScore);
    }
}
