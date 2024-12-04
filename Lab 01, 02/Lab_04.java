// Write a program to find factorial of a number. (Using Loop)

import java.util.*;

public class Lab_04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number :");
        int n=sc.nextInt(),m=1;
        for(int i=n;i>=1;i--){
            m*=i;
        }
        System.out.println(n+"! = "+m);
    }
}
