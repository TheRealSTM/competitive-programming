package com.company.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marcus_10452 {
    private static String PATH = new String("IEHOVA#");
    private static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numGraphs = scanner.nextInt(); scanner.nextLine();
        List<List<Integer>> movesList = new ArrayList<>();
        for (int i = 0; i < numGraphs; i++) {
            int dimI = scanner.nextInt(), dimJ = scanner.nextInt(); scanner.nextLine();
            String[] graph = new String[dimI];
            for (int j = 0; j < dimI; j++) {
                graph[j] = scanner.nextLine();
            }
            List<Integer> moves = determineIndiesMoves(graph);
            movesList.add(moves);
        }
        printMoves(movesList);
    }

    private static void printMoves(List<List<Integer>> movesList) {
        for (List<Integer> moves: movesList) {
            List<String> output = new ArrayList<>();
            for (int move: moves) {
                if (move == 0) {
                    output.add("right");
                } else if (move == 1) {
                    output.add("left");
                } else {
                    output.add("forth");
                }
            }
            System.out.println(String.join(" ", output));
        }
    }

    private static List<Integer> determineIndiesMoves(String[] graph) {
        int startRow = graph.length - 1;
        int startCol = getStartingCol(graph);
        int[] startingPos = {startRow, startCol};
        List<Integer> moves = new ArrayList<>();
        dfs(graph, startingPos, 0, moves);
        return moves;
    }

    private static boolean dfs(String[] graph, int[] startingPos, int nextLet, List<Integer> moves) {
        int jMax = graph[0].length();
        if (nextLet == PATH.length())
            return true;
        for (int i = 0; i < 3; i++) {
            int nextI = startingPos[0] + DIRECTIONS[i][0];
            int nextJ = startingPos[1] + DIRECTIONS[i][1];
            if (nextI < 0 || nextJ < 0 || nextJ >= jMax) continue;
            if (graph[nextI].charAt(nextJ) == PATH.charAt(nextLet)) {
                moves.add(i);
                int[] nextPos = {nextI, nextJ};
                if (dfs(graph, nextPos, ++nextLet, moves))
                    return true;
                moves.remove(moves.size() - 1);
            }
        }
        return false;
    }

    private static int getStartingCol(String[] graph) {
        int startingPos = -1;
        int lastRow = graph.length - 1;
        for (int i = 0; i < graph[lastRow].length(); i++) {
            if (graph[lastRow].charAt(i) == '@') {
                startingPos = i;
                break;
            }
        }
        return startingPos;
    }
}
