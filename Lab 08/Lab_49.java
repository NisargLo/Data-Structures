/*
    Solve - https://www.codechef.com/DSAPREP_10/problems/STKSORT

    STKSORT:

    You are given an array of integers where each integer represents the height of a stack of plates.
    You need to sort these stacks such that for any stack at index i, the stack at index i+1 has a height greater than or equal to the stack at index i.

    To achieve this sorting, you can perform the following operations:

    1.  Merge Operation: You can merge any two adjacent stacks.
        The cost of merging two stacks is equal to the maximum height of the two stacks being merged.
        Your task is to find the minimum cost required to sort the array of stacks in non-decreasing order of heights using the merge operation.

    Input:
        The first line contains an integer N, the number of stacks.
        The second line contains N integers where the integer represents the height of the ith stack.

    Output:
        Output a single integer representing the minimum cost required to sort the stacks.

    Constraints:
        1 ≤ N ≤ 10^5
        1 ≤ height of each stack ≤ 10^5

    Example:
        Input:
            5
            3 1 4 2 5
        Output:
            12

    Explanation:
        To sort the stacks in non-decreasing order of heights:
            Merge stack at index 1 (height 1) and index 2 (height 4), cost = max(1, 4) = 4
            Merge stack at index 2 (height 4) and index 3 (height 2), cost = max(4, 2) = 4
            Merge stack at index 3 (height 4) and index 4 (height 5), cost = max(4, 5) = 5
        Total cost = 4 + 4 + 5 = 13
 */

import java.util.*;

public class Lab_49 {
    public static void main(String[] args) {

    }
}
