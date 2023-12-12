package com.company.A;

import java.util.Map;
import java.util.Scanner;

// https://codeforces.com/contest/785/problem/A
/*
    "Tetrahedron" (without quotes), if the i-th polyhedron in Anton's collection is a tetrahedron.
    "Cube" (without quotes), if the i-th polyhedron in Anton's collection is a cube.
    "Octahedron" (without quotes), if the i-th polyhedron in Anton's collection is an octahedron.
    "Dodecahedron" (without quotes), if the i-th polyhedron in Anton's collection is a dodecahedron.
    "Icosahedron"
 */
public class AntonAndPolyhedrons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPolyhedrons = scanner.nextInt();
        Map<String, Integer> polyhedronToSides = Map.of("Tetrahedron", 4,"Cube", 6, "Octahedron", 8,
                "Dodecahedron", 12, "Icosahedron", 20);
        scanner.nextLine();
        int totalFaces = 0;
        for (int i = 0; i < numPolyhedrons; i++) {
            String polyhedron = scanner.nextLine();
            totalFaces += polyhedronToSides.get(polyhedron);
        }
        System.out.println(totalFaces);
    }
}
