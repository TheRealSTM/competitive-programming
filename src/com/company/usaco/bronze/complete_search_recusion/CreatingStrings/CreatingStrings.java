package com.company.usaco.bronze.complete_search_recusion.CreatingStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: https://cses.fi/problemset/task/1622
 *
 * Task Notes:
 * - Given a string, generate all different strings using its letters. Each letter can be used once.
 *
 * Input Notes:
 * - string of length containing a - z
 *
 * Output Notes:
 * - number of permutations
 * - sorted strings generated
 *
 * Solution Notes:
 * - Use recursion
 * - Keep track of letters that have already been place.
 * - Always start from the beginning and skip numbers that have been placed
 *
 * Outcome:
 * - All test cases pass (6 / 6)
 */
public class CreatingStrings {
    static Set<String> results = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String initialString = reader.readLine();
        permutate(initialString, new ArrayList<>(), new StringBuilder());
        System.out.println(results.size());
        results.stream().sorted().forEach(System.out::println);
    }

    private static void permutate(String initialString, List<Integer> positionsPlaced, StringBuilder stringBuilder) {
        if (stringBuilder.length() == initialString.length()) {
            results.add(stringBuilder.toString());
        }
        for (int i = 0; i < initialString.length(); i++) {
            if (!positionsPlaced.contains(i)) {
                positionsPlaced.add(i);
                permutate(initialString, positionsPlaced, stringBuilder.append(initialString.charAt(i)));
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                positionsPlaced.remove(positionsPlaced.size() - 1);
            }
        }
    }
}
