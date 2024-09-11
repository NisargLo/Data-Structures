//Write a program to implement Quick Sort using Array.
/*
    Time Complexity:
    Best Case: (O(n * log n))
    Average Case: (O(n * log n))
    Worst Case: (O(n^2))
    Description: Fast and efficient, but not stable. Uses divide-and-conquer.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_97 {
    private static int[] a=null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        if(n==0){
            System.out.println("Empty Array...");
            return;
        }
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Quick Sort: " + Arrays.toString(a));
        quick_Sort(0, n-1);
        System.out.println("Array after Quick Sort: " + Arrays.toString(a));
    }

    private static void quick_Sort(int low, int high){
        if(low<high){
            int pivotIndex=partition(low, high);
            quick_Sort(low, pivotIndex-1);
            quick_Sort(pivotIndex+1, high);
        }
    }

    private static int partition(int low, int high){
        int pivot=a[high];
        int i=low-1, temp;
        for(int j=low;j<high;j++){
            if(a[j]<pivot){
                i++; // it will make space for elements which are less than pivot element.
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        i++; // it will make space for pivot element.
        temp=a[i];
        a[i]=pivot;
        a[high]=temp;  //a[high] was the position where the pivot element was there.
        return i;  //returns index of pivot element.
    }
}