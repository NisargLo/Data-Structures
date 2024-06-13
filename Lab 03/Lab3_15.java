// Write a program to calculate average of first n numbers.

import java.util.Scanner;

public class Lab3_15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter N :");
        int n=sc.nextInt(),i,c=0;
        for(i=1;i<=n;i++){
            c+=i;
        }
        c/=n;
        System.out.println("Average = "+c);
    }
}
