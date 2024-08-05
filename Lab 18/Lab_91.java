// Write a program to implement a Binary Search using Array.
// Using both while loop & recursion.

import java.util.Scanner;

public class Lab_91 {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter size of array:");
          int n = sc.nextInt();
          int[] a = new int[n];
          for (int i = 0; i < n; i++) {
               System.out.println("Enter element " + (i + 1) + ":");
               a[i] = sc.nextInt();
          }
          System.out.println("Enter number to search:");
          int s = sc.nextInt();
          int l=0;
          int h=n-1;
          while(l<=h){
               int m=(l+h)/2;
               if(s==a[m]){
                    System.out.println("Element is found at index "+m+" (While Loop)");
                    break;
               }
               else if(s>a[m]){
                    l++;
               }
               else{
                    h--;
               }
               if(l>h){
                    System.out.println("Element not found (While Loop)");
                    break;
               }
          }
          l=0;
          h=n-1;
          binary_Search(a, l, h, s);
     }

     private static void binary_Search(int[] a, int l, int h, int s){
          if (l<=h) {
               int m=(l+h)/2;
               if(s==a[m]){
                    System.out.println("Element is found at index "+m+" (Using Recursion)");
               }
               else if(s>a[m]){
                    binary_Search(a, m+1, h, s);
               }
               else{
                    binary_Search(a, l, m-1, s);
               }
          }
          else{
               System.out.println("Element not found (Using Recursion)");
          }
     }
}
