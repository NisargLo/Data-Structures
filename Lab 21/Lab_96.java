// Write a program to implement Merge Sort using Array.
/*
    Time Complexity:
    Best Case: (O(n * log n))
    Average Case: (O(n * log n))
    Worst Case: (O(n * log n))
    Description: Stable and efficient, uses a divide-and-conquer approach.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Lab_96 {
     private static int[] a;

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of array: ");
          int n = sc.nextInt();
          a = new int[n];
          for (int i = 0; i < a.length; i++) {
               System.out.println("Enter element " + (i + 1) + ":");
               a[i] = sc.nextInt();
          }
          sc.close();
          System.out.println("Array before Merge Sort - " + Arrays.toString(a));
          divide(0, a.length-1); //divide(low,high)
          conquer(0, a.length / 2, a.length - 1); //conquer(low,mid,high)
          System.out.println("Array after Merge Sort - " + Arrays.toString(a));
     }

     private static void divide(int low, int high) {
          if (low < high) {
              int mid = low + (high - low) / 2;
              divide(low, mid);
              divide(mid + 1, high);
              conquer(low, mid, high);
          } 
     }

     private static void conquer(int low, int mid, int high){
          int[] merged=new int[high-low+1];
          int index1=low;
          int index2=mid+1;
          int x=0;

          while(index1<=mid && index2<=high){
               if(a[index1]<=a[index2]){
                    merged[x++]=a[index1++];
               }
               else{
                    merged[x++]=a[index2++];
               }
          }

          while(index1<=mid){
               merged[x++]=a[index1++];
          }

          while(index2<=high){
               merged[x++]=a[index2++];
          }

          for(int i=0, j=low; i<merged.length; i++, j++){
               a[j]=merged[i];
          }
     }
}
