// package com.company.usaco.bronze.simulation.Censoring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Problem Description: http://www.usaco.org/index.php?page=viewproblem2&cpid=526
 *
 * Task Notes:
 *
 * Solution Notes:
 *
 * Outcome:
 */
public class Censoring {
    static String fileInputName = "censor.in";
    static String fileOutputName = "censor.out";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileInputName));
        String initialString = reader.readLine();
        String censoredString = reader.readLine();
        StringBuilder filteredString = new StringBuilder();

        for (int i = 0; i < initialString.length(); i++) {
            filteredString.append(initialString.charAt(i));
            if (filteredString.length() < censoredString.length()) {
                continue;
            }
            String lastSection = filteredString.substring(filteredString.length() - censoredString.length(), filteredString.length());
            if (lastSection.equals(censoredString)) {
                filteredString.delete(filteredString.length() - censoredString.length(), filteredString.length());
            }
        }
        try (PrintWriter pw = new PrintWriter(fileOutputName)) {
            pw.println(filteredString);
        }
    }
}
