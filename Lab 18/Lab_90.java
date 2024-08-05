// Write a program to implement a Linear Search using Array. 

import java.util.Scanner;

public class Lab_90 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of array:");
          int n = sc.nextInt();
          int[] a = new int[n];
          for (int i = 0; i < n; i++) {
               System.out.println("Enter element " + (i + 1) + ":");
               a[i] = sc.nextInt();
          }
          System.out.println("Enter number to search:");
          int s = sc.nextInt();
          for (int i = 0; i < n; i++) {
               if (s==a[i]) {
                    System.out.println("Element found at index " + i);
                    return;
               }
          }
          System.out.println("Element not found");
     }
}
