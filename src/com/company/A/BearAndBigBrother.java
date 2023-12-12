package com.company.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Bear Limak wants to become the largest of bears, or at least to become larger than his brother Bob.
    Right now, Limak and Bob weigh a and b respectively. It's guaranteed that Limak's weight is smaller than
    or equal to his brother's weight. Limak eats a lot and his weight is tripled after every year,
    while Bob's weight is doubled after every year. After how many full years will Limak become strictly larger
    (strictly heavier) than Bob?

    Input
    The only line of the input contains two integers a and b (1 ≤ a ≤ b ≤ 10) — the weight of Limak and the weight
    of Bob respectively.

    Output
    Print one integer, denoting the integer number of years after which Limak will become strictly larger than Bob.
 */
public class BearAndBigBrother {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("\\s+");
        int limakWeight = Integer.parseInt(inputs[0]);
        int bobWeight = Integer.parseInt(inputs[1]);
        int years = 0;
        while (limakWeight <= bobWeight) {
            years++;
            limakWeight *= 3;
            bobWeight *= 2;
        }
        System.out.println(years);
    }
}
