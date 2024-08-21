//Write a program to implement Quick Sort using Array.
/*
    Time Complexity:
    Best Case: (O(n \log n))
    Average Case: (O(n \log n))
    Worst Case: (O(n^2))
    Description: Fast and efficient, but not stable. Uses divide-and-conquer.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Quick Sort: " + Arrays.toString(a));
        quick_Sort(a, 0, n-1);
        System.out.println("Array after Quick Sort: " + Arrays.toString(a));
    }

    private static void quick_Sort(int[] a, int low, int high){
        if(low<high){
            int pivotIndex=partition(a, low, high);
            quick_Sort(a, low, pivotIndex-1);
            quick_Sort(a, pivotIndex+1, high);
        }
    }

    private static int partition(int[] a, int low, int high){
        int pivot=a[high];
        int i=low-1, temp;
        for(int j=low;j<high;j++){
            if(a[j]<pivot){
                i++;
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        i++;
        temp=a[i];
        a[i]=pivot;
        a[high]=temp;  //a[high] is a position where the pivot element is there.
        return i;  //index of pivot element.
    }
}