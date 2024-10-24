package com.company.B.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Problem: https://codeforces.com/contest/6/problem/B
 *
 * Task Notes:
 * - Presidents and subordinates work in the same office
 * - Each person has a desk that's a unique color (desks are rectangular and parallel to the walls)
 * - President creates a assembly and is unsure how many subordinates he has
 * - The desks of subordinates are adjacent to his desk (they are share a common side of positive length)
 * - The office can be viewed as a matrix of n rows and m columns. Each cell is part of a desk or empty
 * - Emtpy cells are indicated by "." and uppercase letters indicate part of a desk
 *
 * Input Notes:
 * - The first line contains n, m and c (preseident's desk color)
 * - The next n lines are the office configuration
 * - Each desk color is unique
 *
 * Output Notes:
 * - # of deputies
 *
 * Solution Notes:
 * - Find the coordinates of the president's desk and keep track of the different adjacent desks.
 *
 * Outcome:
 * - ALl test cases pass
 *
 * Time Log:
 * - Start reading 9:32
 * - Finished reading 9:35
 * - Reviewing I/O 9:36
 * - Starting thinking at 9:39
 * - Starting implementation 9:41
 * - Finished implementation 9:51
 * - Starting testing/debugging 9:51
 */
public class PresidentsOffice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        char presidentsLetter = tokenizer.nextToken().charAt(0);
        char[][] deskConfig = new char[n][m];
        for (int i = 0; i < n; i++) {
            deskConfig[i] = reader.readLine().toCharArray();
        }
        Set<Point> presidentsDeskLocations = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (deskConfig[i][j] == presidentsLetter) {
                    presidentsDeskLocations.add(new Point(i, j));
                }
            }
        }
        Set<Character> adjacentColors = new HashSet<>();
        for (Point point : presidentsDeskLocations) {
            if (point.row + 1 < n && deskConfig[point.row + 1][point.col] != '.' && deskConfig[point.row + 1][point.col] != presidentsLetter) {
                adjacentColors.add(deskConfig[point.row + 1][point.col]);
            }
            if (point.row - 1 >= 0 && deskConfig[point.row - 1][point.col] != '.' && deskConfig[point.row - 1][point.col] != presidentsLetter) {
                adjacentColors.add(deskConfig[point.row - 1][point.col]);
            }
            if (point.col - 1 >= 0 && deskConfig[point.row][point.col - 1] != '.' && deskConfig[point.row][point.col - 1] != presidentsLetter) {
                adjacentColors.add(deskConfig[point.row][point.col - 1]);
            }
            if (point.col + 1 < m && deskConfig[point.row][point.col + 1] != '.' && deskConfig[point.row][point.col + 1] != presidentsLetter) {
                adjacentColors.add(deskConfig[point.row][point.col + 1]);
            }
        }
        System.out.println(adjacentColors.size());
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
