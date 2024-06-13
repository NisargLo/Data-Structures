// Write a program to calculate sum of numbers from m to n.

import java.util.Scanner;

public class Lab3_14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter M :");
        int m=sc.nextInt(),i,c=0;
        System.out.println("Enter N :");
        int n=sc.nextInt();
        for(i=m;i<=n;i++){
            c+=i;
        }
        System.out.println("Sum = "+c);
    }
}
