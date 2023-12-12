package com.company.B.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheSeasonWar_352 {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numImages = scanner.nextInt();
        int[] warEagleCount = new int[numImages];
        for (int i = 0; i < numImages; i++) {
            int sizeImage = scanner.nextInt();
            scanner.nextLine();
            List<StringBuilder> image = new ArrayList<>();
            for (int j = 0; j < sizeImage; j++) {
                String line = scanner.nextLine();
                image.add(new StringBuilder(line));
            }
            warEagleCount[i] = determineNumberOfWarEagles(image);
        }
        for (int i = 0; i < numImages; i++) {
            System.out.println(String.format("Image number %d contains %d war eagles.", (i + 1), warEagleCount[i]));
        }
    }

    private static int determineNumberOfWarEagles(List<StringBuilder> image) {
        int dimension = image.get(0).length();
        int count = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (image.get(i).charAt(j) == '1') {
                    count++;
                    searchImage(image, i, j);
                }
            }
        }
        return count;
    }

    private static void searchImage(List<StringBuilder> image, int i, int j) {
        int dimension = image.size();
        image.get(i).setCharAt(j, '0');
        for (int[] pair: directions) {
            int newI = i + pair[0], newJ = j + pair[1];
            if (newI >= 0 && newI < dimension
                    && newJ >= 0 && newJ < dimension
                    && (image.get(newI).charAt(newJ) == '1')) {
                searchImage(image, newI, newJ);
            }
        }
    }
}
