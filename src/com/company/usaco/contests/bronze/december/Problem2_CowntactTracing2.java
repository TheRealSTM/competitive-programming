//package com.company.usaco.contests.bronze.december;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Problem: http://www.usaco.org/index.php?page=viewproblem&cpid=1336
// *
// * Task Notes:
// * - FJ has N cows in a line where 1 <= N <= 3 * 10^5
// * - A sickness is spreading through the herd
// * - Cows spread the sickness to the left and right
// * - Once a cow is infected - they stay infected
// * - After some number of nights, FJ decides to test the cows to determine if they are sick
// * - Task: Find the min # of sick cows
// *
// * Input Notes:
// * - The first line contains N (number of cows)
// * - The nextline contains N character bit-string where 1 represents a sick cow
// *
// * Output Notes:
// * - Output a single integer: minimum number of cows that could have started with the sickness
// *
// * Solution Notes:
// * -
// *
// * Outcome:
// * -
// */
//class Cluster {
//    int left;
//    int right;
//    boolean isEdge;
//
//    int getMaxNumberOfNights() {
//        if (isEdge) {
//            return right - left;
//        }
//        if (right - left % 2 == 0) {
//            return (right - left - 1) / 2;
//        }
//        return (right - left) / 2;
//    }
//
//    int getInfected(int nights) {
//        if (nights == 0) {
//            return right - left;
//        }
//    }
//
//    Cluster(int left, int right, boolean isEdge) {
//        this.left = left;
//        this.right = right;
//        this.isEdge = isEdge;
//    }
//}
//public class Problem2_CowntactTracing2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        char[] cowStates = reader.readLine().toCharArray();
//        int currentPos = 0, clusterStart = 0, clusterEnd = 0;
//        List<Cluster> clusters = new ArrayList<>();
//        while (currentPos < cowStates.length) {
//            if (cowStates[currentPos] == '0') {
//                currentPos++;
//                continue;
//            }
//            clusterStart = currentPos;
//            while (currentPos + 1 < cowStates.length && cowStates[currentPos + 1] == '1') {
//                currentPos++;
//            }
//            clusterEnd = currentPos;
//            boolean isEdge = clusterStart == 0 || clusterEnd == (cowStates.length - 1);
//            clusters.add(new Cluster(clusterStart, clusterEnd, isEdge));
//            currentPos++;
//        }
//
//
//        try (PrintWriter pw = new PrintWriter(System.out)) {
//        }
//    }
//}
