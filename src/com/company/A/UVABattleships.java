package com.company.A;

import java.util.Scanner;

public class UVABattleships {
    static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }
    public static void main(String[] args) {
        int numTestCases = Integer.parseInt(scanner.nextLine());
        int[] outputTestCase = new int[numTestCases];
        for (int i = 0; i < numTestCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            outputTestCase[i] = processTestCase(size);
        }
        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case " + (i + 1) + ": " + outputTestCase[i]);
        }
    }

    private static int processTestCase(int size) {
        StringBuilder[] grid = readInGrid(size);
        int shipCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char currentLet = grid[i].charAt(j);
                if (isPartOfShip(currentLet)) {
                    shipCount++;
                    searchPos(grid, i, j);
                }
            }
        }
        return shipCount;
    }

    private static void searchPos(StringBuilder[] grid, int i, int j) {
        grid[i].setCharAt(j, '.');
        if (isValidPos(i, j + 1, grid.length) && isPartOfShip(grid[i].charAt(j + 1))) {
            for (int nextJ = j + 1; nextJ < grid.length; nextJ++) {
                if (isValidPos(i, nextJ, grid.length) && isPartOfShip(grid[i].charAt(nextJ))) {
                    grid[i].setCharAt(nextJ, '.');
                }
            }
        } else {
            for (int nextI = i + 1; nextI < grid.length; nextI++) {
                if (isValidPos(nextI, j, grid.length) && isPartOfShip(grid[nextI].charAt(j))) {
                    grid[nextI].setCharAt(j, '.');
                }
            }
        }
    }

    private static boolean isValidPos(int i, int j, int size) {
        return i >= 0 && i < size && j >= 0 && j < size;
    }

    private static boolean isPartOfShip(char gridLet) {
        return gridLet == '@' || gridLet == 'x';
    }

    private static StringBuilder[] readInGrid(int size) {
        StringBuilder[] newGrid = new StringBuilder[size];
        for (int i = 0; i < size; i++) {
            newGrid[i] = new StringBuilder(scanner.nextLine());
        }
        return newGrid;
    }
}
