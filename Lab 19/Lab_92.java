// Write a program to implement Bubble Sort using Array.
/*
    Time Complexity:
    Best Case: (O(n))
    Average Case: (O(n^2))
    Worst Case: (O(n^2))

    Space Complexity: (O(1))
    Description: Simple and stable, but inefficient for large datasets.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Bubble Sort: " + Arrays.toString(a));
        bubble_Sort(a);
        System.out.println("Array after Bubble Sort: " + Arrays.toString(a));
        sc.close();
    }

    private static void bubble_Sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
