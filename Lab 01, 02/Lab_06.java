// Write a program to find power of a number using loop.

import java.util.*;

public class Lab_06 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter base :");
        int b=sc.nextInt(),m=1;
        System.out.println("Enter exponent :");
        int e=sc.nextInt();
        for(int i=1;i<=e;i++){
            m*=b;
        }
        System.out.println("Power = "+m);
    }
}