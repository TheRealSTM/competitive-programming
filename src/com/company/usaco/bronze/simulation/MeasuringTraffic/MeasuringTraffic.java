package com.company.usaco.bronze.simulation.MeasuringTraffic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeasuringTraffic {
    private static String inputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\MeasuringTraffic\\traffic.in";
    private static String outputFileName = "C:\\Users\\stmon\\IdeaProjects\\CompetitiveProgramming\\src\\com\\company\\usaco\\bronze\\simulation\\MeasuringTraffic\\traffic.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        StringTokenizer initialRow = new StringTokenizer(reader.readLine());
        int numSensors = Integer.parseInt(initialRow.nextToken());
        String[][] inputs = new String[numSensors][3];
        for (int i = 0; i < numSensors; i++) {
            inputs[i] = reader.readLine().split(" ");
            System.out.println(Arrays.toString(inputs[i]));
        }



        PrintWriter pw = new PrintWriter(outputFileName);
        for (int i = 0; i < numSensors; i++) {
            pw.println(Arrays.toString(inputs[i]));
        }
        pw.close();
    }
}
