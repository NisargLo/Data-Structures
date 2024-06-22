// Write a program to merge two unsorted arrays.

import java.util.*;

public class Lab_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of Array 1 :");
        int m = sc.nextInt(),i,j;
        int[] a = new int[m];
        for (i = 0; i < a.length; i++) {
            System.out.println("Enter element "+(i+1)+" of Array 1 :");
            a[i] = sc.nextInt();
        }
        System.out.println("Size of Array 2 :");
        int n = sc.nextInt();
        int[] b = new int[n];
        int[] res = new int[m+n];
        for (i = 0; i < b.length; i++) {
            System.out.println("Enter element "+(i+1)+" of Array 2 :");
            b[i] = sc.nextInt();
        }
        for(i = 0; i < a.length; i++){
            res[i]=a[i];
        }
        for(j = a.length; j < res.length; j++){
            res[j]=b[j-m];
        }
        System.out.println("Merged Array :");
        for(i = 0; i < res.length; i++){
            System.out.println("Element "+(i+1)+" = "+res[i]);
        }
    }
}
