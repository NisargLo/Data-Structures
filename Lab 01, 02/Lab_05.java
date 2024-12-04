// Write a program to find factorial of a number. (Using Recursion)

import java.util.*;

public class Lab_05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number :");
        int n=sc.nextInt();
        int f=factorial_recursion(n);
        System.out.println(n+"! = "+f);
    }

    private static int factorial_recursion(int n){
        if(n==1){
            return n;
        }
        else{
            return n*factorial_recursion(n-1);
        }
    }
}
