// Write a program to implement Selection Sort using Array.

import java.util.Arrays;
import java.util.Scanner;

public class Lab_94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Selection Sort: "+ Arrays.toString(a));
        selection_Sort(a);
        System.out.println("Array after Selection Sort: "+ Arrays.toString(a));
    }

    private static void selection_Sort(int[] a){
        for(int i=0;i<a.length;i++){
            int minIndex=i;
            for(int j=i+1;j<a.length;j++){
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int temp=a[minIndex];
            a[minIndex]=a[i];
            a[i]=temp;
        }
    }
}