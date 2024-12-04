// Write a program to find position of the smallest number & the largest number from given n numbers.

import java.util.Scanner;

public class Lab_16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many numbers will you enter :");
        int n=sc.nextInt(),i;
        int[] a=new int[n];
        for(i=0;i<a.length;i++){
            System.out.println("Enter element "+(i+1));
            a[i]=sc.nextInt();
        }
        int min=a[0],max=a[0],minIndex=0,maxIndex=0;
        for(i=0;i<n;i++){
            if(min>a[i]){
                min=a[i];
                minIndex=i;
            }
            if(max<a[i]){
                max=a[i];
                maxIndex=i;
            }
        }
        System.out.println("Index of Min No = "+minIndex+"\nIndex of Max No = "+maxIndex);
    }
}
