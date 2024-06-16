/*
    Read n numbers in an array then read two different numbers, replace 1st
    number with 2nd number in an array and print its index and final array.
 */

import java.util.Scanner;

public class Lab_18 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many numbers will you enter :");
        int n=sc.nextInt(),i,j,temp,flag=1;
        String str=new String("");
        int[] a=new int[n];
        for(i=0;i<n;i++){
            System.out.println("Enter element "+(i+1));
            a[i]=sc.nextInt();
        }
        System.out.println("Enter 1st number :");
        int first=sc.nextInt();
        System.out.println("Enter 2nd number :");
        int second=sc.nextInt();
        for(i=0;i<n;i++){
            if(a[i]==first){
                a[i]=second;
                System.out.println("Index = "+i);
                break;
            }
        }
        System.out.print("Array : ");
        for(int num : a){
            System.out.print(num+", ");
        }
    }
}
