// Write a program to read and display n numbers using an array.

import java.util.*;

public class Lab_13{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many numbers will you enter :");
        int n=sc.nextInt(),i;
        int[] a=new int[n];
        for(i=0;i<a.length;i++){
            System.out.println("Enter element "+(i+1));
            a[i]=sc.nextInt();
        }
        for(i=0;i<n;i++){
            System.out.println("Element "+(i+1)+" = "+a[i]);
        }
    }
}