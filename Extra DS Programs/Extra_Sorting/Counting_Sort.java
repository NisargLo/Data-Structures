/*
     Counting Sort

     Time Complexity:
     Best Case: (O(n + k))
     Average Case: (O(n + k))
     Worst Case: (O(n + k))
     Description: Efficient for a small range of integers, stable.
 */

package Extra_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Counting_Sort {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of array: ");
          int n = sc.nextInt();
          if(n==0){
               System.out.println("Empty Array...");
               return;
          }
          int[] a = new int[n];
          for (int i = 0; i < a.length; i++) {
               System.out.println("Enter element " + (i + 1) + ":");
               a[i] = sc.nextInt();
          }
          sc.close();
          System.out.println("Array before Counting Sort - " + Arrays.toString(a));
          a=counting_Sort(a);
          System.out.println("Array after Counting Sort - " + Arrays.toString(a));
     }

     private static int[] counting_Sort(int[] a) {
          int max = a[0], min = a[0];
          for (int num : a) {
               if (num > max) {
                    max = num;
               }
               if (num < min) {
                    min = num;
               }
          }

          int range = max - min + 1;
          int[] count = new int[range];

          for (int i = 0; i < count.length; i++) {
               count[a[i] - min]++;
          }

          for (int i = 0; i < count.length - 1; i++) {
               count[i + 1] += count[i];
          }

          int[] b = new int[a.length];
          for (int i = a.length - 1; i >= 0; i--) {
               b[count[a[i] - min] - 1] = a[i];
               count[a[i] - min]--;
          }
          return b;
     }
}