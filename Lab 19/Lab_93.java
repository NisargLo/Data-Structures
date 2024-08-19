// Write a program to implement Insertion Sort using Array.
/*
     Time Complexity:
     Best Case: (O(n))
     Average Case: (O(n^2))
     Worst Case: (O(n^2))

     Space Complexity: (O(1))
     Description: Efficient for small or nearly sorted datasets, stable.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_93 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of array: ");
          int n = sc.nextInt();
          int[] a = new int[n];
          for (int i = 0; i < a.length; i++) {
               System.out.println("Enter element " + (i + 1) + ":");
               a[i] = sc.nextInt();
          }
          sc.close();
          System.out.println("Array before Insertion Sort - " + Arrays.toString(a));
          insertion_Sort(a);
          System.out.println("Array after Insertion Sort - " + Arrays.toString(a));
     }

     private static void insertion_Sort(int[] a) {
          for (int i = 1; i < a.length; i++) {
               int key = a[i], j;
               for (j = i - 1; j >= 0 && a[j] > key; j--) {
                    a[j + 1] = a[j];
               }
               a[j + 1] = key;
          }
     }
}