package com.company.A;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://codeforces.com/contest/43/problem/A
public class Football {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> teamGoalMap = new HashMap<>();
        for (int i = 0; i < numLines; i++) {
            String team = scanner.nextLine();
            teamGoalMap.put(team, teamGoalMap.getOrDefault(team, 0) + 1);
        }
        int mostGoals = -1;
        String teamMostGoals = "";
        for (String team: teamGoalMap.keySet()) {
            if (teamGoalMap.get(team) > mostGoals) {
                mostGoals = teamGoalMap.get(team);
                teamMostGoals = team;
            }
        }
        System.out.println(teamMostGoals);
    }
}
