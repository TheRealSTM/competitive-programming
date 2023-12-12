package com.company.B.Sort;

import java.util.Arrays;
import java.util.Scanner;

// Goal is to maximize number of matches per match box
// Sort the pairs based on most matches per box

public class BurglarAndMatches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxBoxesThieftCanCarry = scanner.nextInt(), totalBoxes = scanner.nextInt();
        Pair[] boxMatchPairs = new Pair[totalBoxes];
        for (int i = 0; i < totalBoxes; i++)
            boxMatchPairs[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        Arrays.sort(boxMatchPairs, (p1, p2) -> Integer.compare(p2.matchesPerBox, p1.matchesPerBox));
        int totalMatches = 0, currentBoxes = 0;
        for (int i = 0; i < totalBoxes; i++) {
            if (currentBoxes + boxMatchPairs[i].numBoxes < maxBoxesThieftCanCarry) {
                currentBoxes += boxMatchPairs[i].numBoxes;
                totalMatches += (boxMatchPairs[i].numBoxes * boxMatchPairs[i].matchesPerBox);
            } else {
                totalMatches += ((maxBoxesThieftCanCarry - currentBoxes) * boxMatchPairs[i].matchesPerBox);
                break;
            }
        }
        System.out.println(totalMatches);
    }
}

class Pair {
    public int numBoxes;
    public int matchesPerBox;

    Pair(int numBoxes, int matchesPerBox) {
        this.numBoxes = numBoxes;
        this.matchesPerBox = matchesPerBox;
    }
}

