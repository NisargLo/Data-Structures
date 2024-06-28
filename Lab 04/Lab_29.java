/*
    Solve : https://www.codechef.com/problems/CHEFHAM

    Chef and Hamming Distance of arrays

    Chef likes to work with arrays a lot.
    Today he has an array A of length N consisting of positive integers.
    Chef's little brother likes to follow his elder brother, so he thought of creating an array B of length N.
    The little brother is too small to think of new numbers himself, so he decided to use all the elements of array A to create the array B.
    In other words, array B is obtained by shuffling the elements of array A.

    The little brother doesn't want Chef to know that he has copied the elements of his array A.
    Therefore, he wants to create the array B in such a way that the Hamming distance between the two arrays A and B is maximized.
    The Hamming distance between A and B is the number of indices i (1 ≤ i ≤ N) such that Ai ≠ Bi.

    The brother needs your help in finding any such array B.
    Can you please find one such array for him?

    Note that it's guaranteed that no element in A appears more than twice, i.e. frequency of each element is at most 2.


    Input
        The first line of the input contains a single integer T denoting the number of test cases.
        The description of T test cases follows.
        The first line of each test case contains an integer N denoting the length of the array A.
        The second line contains N space-separated integers A1, A2 ... AN.


    Output
        For each test case, print two lines.
        The first line should contain the maximum possible Hamming distance that array B can have from array A.
        The second line should contain N space-separated integers denoting the array B; the i-th integer should denote the value of Bi.
        Note that B should be an array obtained after shuffling the elements of A.


    Constraints
        1 ≤ T ≤ 10
        1 ≤ N ≤ 105
        1 ≤ Ai ≤ 105
        The frequency of each integer in the array A will be at most 2.


    Subtasks
        Subtask #1 (30 points): all elements in the array A are unique
        Subtask #2 (30 points): 5 ≤ N ≤ 105
        Subtask #3 (40 points): original constraints


    Sample 1 :-

    Input
        3
        2
        1 2
        3
        1 2 1
        4
        2 6 5 2

    Output
        2
        2 1
        2
        2 1 1
        4
        6 2 2 5
 */

import java.util.*;

public class Lab_29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();

        while (tc-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int[] original = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                original[i] = arr[i];
            }

            if (n == 1) {
                System.out.println("0");
                System.out.println(arr[0]);
                continue;
            }

            int maxHamming = -1;
            int[] result = new int[n];

            // Try rotating the array and calculate Hamming distance
            for (int rotation = 0; rotation < n; rotation++) {
                rotateLeft(arr);
                int hamming = calculateHamming(arr, original);
                if (hamming > maxHamming) {
                    maxHamming = hamming;
                    copyArray(arr, result);
                }
            }

            // Print the result for the current test case
            System.out.println(maxHamming);
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Method to rotate the array one position to the left
    private static void rotateLeft(int[] arr) {
        int firstElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = firstElement;
    }

    // Method to calculate Hamming distance between two arrays
    private static int calculateHamming(int[] arr1, int[] arr2) {
        int hammingDistance = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    // Method to copy contents of one array into another
    private static void copyArray(int[] source, int[] destination) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }
}
