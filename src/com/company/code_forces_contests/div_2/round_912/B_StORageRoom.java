package com.company.code_forces_contests.div_2.round_912;

import java.util.Scanner;

/**
 * Description: https://codeforces.com/contest/1903/problem/B
 *
 * Task Notes:
 * - Weather is hot. Theofanis creates an icecream company
 * - Icecream is locked in big storage rooms - he forgot the password.
 * - There is table M with n rows and n columns of non-negative integers. To open the lock, you need
 *  to find an array of a of n elements such
 *   - 0 <= a_i < 2^30
 *   - Mi,j = a_i | a_j for all i != j where | denotes a bitwise OR operation
 *  - Table may not have any solutions. Ice cream remains locked
 *  - Can you find an array to open the lock
 *
 *  Input:
 *  - t : number of test cases
 *  - n : size of the hidden array
 *  - next n rows describe the rows of M
 *  - M i, i = 0 and Mi,j = Mj,i for 1 <= i, j <= n
 *  - It is guaranteed that the sum of n over all test cases does not exceed 10^3
 *
 *  Output:
 *  - YES and an array satisfying the solution
 *  - NO
 */
public class B_StORageRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
