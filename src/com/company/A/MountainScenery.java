package com.company.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MountainScenery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPeaks = scanner.nextInt(), peaksToChange = scanner.nextInt();
        int[] peaks = new int[2 * totalPeaks + 1];
        for (int i = 0; i < 2 * totalPeaks + 1; i++) {
            peaks[i] = scanner.nextInt();
        }
        int nextPeak = 0;
        while (peaksToChange > 0) {
            int peakPos = 2 * nextPeak + 1;
            int potentialPeak = peaks[peakPos] - 1;
            if (potentialPeak > peaks[peakPos - 1] && potentialPeak > peaks[peakPos + 1]) {
                peaksToChange--;
                peaks[peakPos] = potentialPeak;
            }
            nextPeak++;
        }
        // String output = String.join(Arrays.stream(peaks).mapToObj(Integer::toString).toArra, " ");
        List<String> output = new ArrayList<>();
        for (int peak: peaks) {
            output.add(peak + "");
        }
        System.out.println(String.join(" ", output));
    }
}
