package com.company.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://codeforces.com/contest/405/problem/A
public class GravityChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numColumns = Integer.parseInt(br.readLine());
        List<Integer> columns = Arrays.stream(br.readLine().split("\\s+"))
                              .mapToInt(Integer::parseInt)
                              .boxed()
                              .collect(Collectors.toList());
        Collections.sort(columns);
        String res = columns.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
