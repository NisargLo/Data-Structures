// Write a program to implement Merge Sort using Array.

import java.util.Arrays;
import java.util.Scanner;

public class Lab_96 {
     private static int[] a;

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of array: ");
          int n = sc.nextInt();
          int low = 0, high = n - 1;
          a = new int[n];
          for (int i = 0; i < a.length; i++) {
               System.out.println("Enter element " + (i + 1) + ":");
               a[i] = sc.nextInt();
          }
          sc.close();
          System.out.println("Array before Merge Sort - " + Arrays.toString(a));
          merge_Sort(low, high);
          merge(0, n / 2, n - 1);
          System.out.println("Array after Merge Sort - " + Arrays.toString(a));
     }

     private static void merge_Sort(int low, int high) {
          if (low < high) {
               int mid = (low + high) / 2;
               merge_Sort(low, mid);
               merge_Sort(mid + 1, high);
               merge(low, mid, high);
          }
     }

     private static void merge(int low, int mid, int high) {
          int h = low, i, j = mid + 1, k;
          int[] b = new int[a.length];
          for (i = low; h <= mid && j <= high; i++) {
               if (a[h] <= a[j]) {
                    b[i] = a[h];
                    h++;
               } else {
                    b[i] = a[j];
                    j++;
               }
          }
          if (h > mid) {
               for (k = j; k <= high; i++, k++) {
                    b[i] = a[k];
               }
          } else {
               for (k = h; k <= mid; i++, k++) {
                    b[i] = a[k];
               }
          }
          for (k = low; k <= high; k++) {
               a[k] = b[k];
          }
     }
}
