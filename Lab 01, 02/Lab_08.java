// Write a program to check whether a number is prime or not.

import java.util.*;

public class Lab_08 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number :");
        int n=sc.nextInt();
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                System.out.println("Not Prime");
                return;
            }
        }
        System.out.println("Prime");
    }
}
