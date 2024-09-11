// Write a program to implement Selection Sort using Array.
/*
    Time Complexity:
    Best Case: (O(n^2))
    Average Case: (O(n^2))
    Worst Case: (O(n^2))
    Description: Simple but inefficient, always performs (O(n^2)) comparisons.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        if(n==0){
            System.out.println("Empty Array...");
            return;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Selection Sort: " + Arrays.toString(a));
        selection_Sort(a);
        System.out.println("Array after Selection Sort: " + Arrays.toString(a));
    }

    private static void selection_Sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
    }
}
