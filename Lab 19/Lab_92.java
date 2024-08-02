// Write a program to implement Bubble Sort using Array.

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
        System.out.println("Array before Bubble Sort: "+ Arrays.toString(a));
        bubble_Sort(a);
        System.out.println("Array after Bubble Sort: "+ Arrays.toString(a));
    }

    private static void bubble_Sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
        }
    }
}